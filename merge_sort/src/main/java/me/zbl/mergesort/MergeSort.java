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
package me.zbl.mergesort;

/**
 * 归并排序
 *
 * @author JamesZBL
 * @date 2018-04-01
 */
public class MergeSort {

  /**
   * 归并排序
   *
   * @param raw 待排序列
   *
   * @return 有序序列
   */
  public static int[] sort(int[] raw) {
    divideAndSort(raw, 0, raw.length - 1, new int[raw.length]);
    return raw;
  }

  /**
   * 合并序列 raw[start...center] 与序列[center+1...end]
   *
   * @param raw    序列
   * @param start  起始位置
   * @param center 中间位置
   * @param end    结束位置
   * @param temp   临时序列
   */
  private static void mergeArray(int[] raw, int start, int center, int end, int[] temp) {
    int i = start, j = center + 1;
    int k = 0;

    //     循环依次取两序列中较小的值
    while (i <= center && j <= end) {
      if (raw[i] < raw[j]) {
        temp[k++] = raw[i++];
      } else {
        temp[k++] = raw[j++];
      }
    }

    //     检查左序列是否剩余
    while (i <= center) {
      temp[k++] = raw[i++];
    }

    //     检查右序列是否剩余
    while (j <= end) {
      temp[k++] = raw[j++];
    }

    //     使序列 raw[start...end] 有序
    for (int ii = 0; ii < k; ii++) {
      raw[start + ii] = temp[ii];
    }
  }

  /**
   * 递归分治
   *
   * @param raw   待排序列
   * @param start 起始位置
   * @param end   结束位置
   * @param temp  临时序列
   */
  private static void divideAndSort(int[] raw, int start, int end, int[] temp) {
    if (start < end) {
      //      计算中间位置
      int center = (start + end) / 2;
      //      做序列排序
      divideAndSort(raw, start, center, temp);
      //      右序列排序
      divideAndSort(raw, center + 1, end, temp);
      //      合并左右序列
      mergeArray(raw, start, center, end, temp);
    }
  }
}
