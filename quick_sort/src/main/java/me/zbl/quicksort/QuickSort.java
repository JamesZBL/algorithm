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
package me.zbl.quicksort;

/**
 * 快速排序
 *
 * @author JamesZBL
 * @date 2018-03-01
 */
public class QuickSort {

  /**
   * 排序
   *
   * @param raw 无序序列
   */
  public static int[] sort(int[] raw) {
    quickSort(raw, 0, raw.length - 1);
    return raw;
  }

  /**
   * 递归分治
   *
   * @param raw   无序序列
   * @param start 左端点位置
   * @param end   右端点位置
   */
  public static void quickSort(int[] raw, int start, int end) {
    int pivot = divide(raw, start, end);
    if (start < pivot) {
      quickSort(raw, start, pivot - 1);
    }
    if (pivot < end) {
      quickSort(raw, pivot + 1, end);
    }
  }

  /**
   * 分治
   *
   * @param raw   无序序列
   * @param start 左端点位置
   * @param end   右端点位置
   *
   * @return 枢轴位置
   */
  private static int divide(int[] raw, int start, int end) {
    int pivot = raw[start];
    while (start < end) {
      while (start < end && raw[end] >= pivot) {
        end--;
      }
      raw[start] = raw[end];
      while (start < end && raw[start] <= pivot) {
        start++;
      }
      raw[end] = raw[start];
    }
    raw[start] = pivot;
    return start;
  }
}
