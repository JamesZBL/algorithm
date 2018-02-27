/*
 * Copyright 2018 JamesZBL
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */
package me.zbl.simplechoice;

/**
 * 简单选择排序
 * <p>
 * a.从待排序序列中，找到关键字最小的元素
 * b.如果最小元素不是待排序序列的第一个元素，将其和第一个元素互换
 * 从余下的 N - 1 个元素中，找出关键字最小的元素，重复 a、b，直到排序结束
 * 循环 1：依次遍历序列当中的每一个元素
 * 循环 2：将遍历得到的当前元素依次与余下的元素进行比较，符合最小元素的条件，则交换
 *
 * @author JamesZBL
 * @date 2018-02-26
 */
public class SimpleChoiceSort {

  public static int[] sort(int[] raw) {
    for (int i = 0; i < raw.length; i++) {
      for (int j = i; j < raw.length; j++) {
        if (raw[j] < raw[i]) {
          int tmp = raw[i];
          raw[i] = raw[j];
          raw[j] = tmp;
        }
      }
    }
    return raw;
  }
}
