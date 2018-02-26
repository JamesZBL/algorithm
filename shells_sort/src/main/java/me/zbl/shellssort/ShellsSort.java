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
package me.zbl.shellssort;

/**
 * 希尔排序
 * <p>
 * 将待排序数组按照步长 span 进行分组，然后将每组的元素利用直接插入排序的方法进行排序，
 * 每次将 span 折半减小，循环上述操作，
 * 当 span =1 时，利用直接插入，完成排序
 * <p>
 * <p>
 * 循环 1：将步长依次折半，对序列进行分组，直到步长为 1
 * 循环 2、3：即直接插入排序所需要的两次循环
 *
 * @author JamesZBL
 * @date 2018-02-26
 */
public class ShellsSort {

  public static int[] sort(int[] raw) {
    int span = raw.length / 2;
    while (span >= 1) {
      for (int i = span; i < raw.length; i++) {
        for (int j = i; j - span > -1; j -= span) {
          if (raw[j - span] > raw[j]) {
            int tmp = raw[j - span];
            raw[j - span] = raw[j];
            raw[j] = tmp;
          }
        }
      }
      span /= 2;
    }
    return raw;
  }
}
