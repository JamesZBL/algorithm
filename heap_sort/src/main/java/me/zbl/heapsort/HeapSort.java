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
package me.zbl.heapsort;

/**
 * 堆排序
 * <p>
 * 先将数组构造成大顶堆
 * a.取出当前大顶堆的根节点，将其与序列末尾元素进行交换；此时：序列末尾的元素为已排序的最大值；由于交换了元素，
 * 当前位于根节点的堆并不一定满足大顶堆的性质
 * b.对交换后的 n-1 个序列元素进行调整，使其满足大顶堆的性质
 * 循环 a、b，直到堆中只剩下 1 个元素
 * <p>
 * 一般的，升序排列用大顶堆，降序排列用小顶堆
 *
 * @author JamesZBL
 * @date 2018-02-26
 */
public class HeapSort {

  public static int[] sort(int[] raw) {
    getMaxHeap(raw);
    for (int i = raw.length - 1; i > 0; i--) {
      int tmp = raw[0];
      raw[0] = raw[i];
      raw[i] = tmp;
      adjust(raw, 0, i);
    }
    return raw;
  }


  private static int[] getMaxHeap(int[] raw) {
    for (int i = raw.length / 2; i > -1; i--) {
      adjust(raw, i, raw.length - 1);
    }
    return raw;
  }

  /**
   * 对树中的某个节点进行调整
   *
   * @param raw    待调整树
   * @param root   调整的位置
   * @param length 树节点总数
   */
  private static int[] adjust(int[] raw, int root, int length) {
    int tmp = raw[root];
    int child = leftIndex(root);
    while (child < length) {
      if (child + 1 < length && raw[child] < raw[child + 1]) {
        child++;
      }
      if (tmp >= raw[child]) {
        break;
      }
      raw[root] = raw[child];
      root = child;
      child *= 2;
      child++;
    }
    raw[root] = tmp;
    return raw;
  }

  /**
   * 获取左子节点的位置
   *
   * @param i 在堆中的位置序号
   *
   * @return i 位置的元素的左子节点的位置序号
   */
  private static int leftIndex(int i) {
    return 2 * i + 1;
  }

  /**
   * 获取左子节点的位置
   *
   * @param i 在堆中的位置序号
   *
   * @return i 位置的元素的左子节点的位置序号
   */
  private static int rightIndex(int i) {
    return 2 * i + 2;
  }
}
