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
package me.zbl.straightinsert;

/**
 * 直接插入排序
 * <p>
 * 将数组中的每个元素与其前面已完成排序的元素进行比较，如果后面的比前面的小，则相互交换位置，直至所有元素都比较完成
 * 循环 1：遍历数组
 * 循环 2：将当前元素与前面所有完成排序的元素进行比较，后面的小则相互交换
 *
 * @author JamesZBL
 * @date 2018-02-26
 */
public class StraightInserSort {

  public static int[] sort(int[] raw) {
    for (int i = 0; i < raw.length; i++) {
      for (int j = i - 1; j > -1; j--) {
        if (raw[j] > raw[j + 1]) {
          int tmp = raw[j];
          raw[j] = raw[j + 1];
          raw[j + 1] = tmp;
        }
      }
    }
    return raw;
  }
}
