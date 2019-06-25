package com.springcloud.cn.heap;

public class FindNumK{

    private static void build(int[] arr, int length) {
        int i = length;
        for(i = (i - 2) / 2; i >= 0; --i) {
            adjustHeap(arr, i, length);
        }
    }

    private static void adjustHeap(int[] arr, int index, int length) {
        int temp = arr[index];
        // 先找到待调整节点的左孩子
        int childIndex = 2 * index + 1;

        while(childIndex < length) {
            // 如果有有孩子，且右孩子小于左孩子的值，则定位到右孩子
            if(childIndex + 1 < length && arr[childIndex+1] < arr[childIndex]) {
                childIndex++;
            }
            // 如果父节点小于任何一个孩子的值，直接跳出，因为此时childIndex代表的是节点孩子的最小值了
            if(temp <= arr[childIndex]) {
                break;
            }
            arr[index] = arr[childIndex];
            index = childIndex;
            childIndex = 2 * childIndex + 1;
        }
        arr[index] = temp;
    }

    public static void main(String[] args) {
        int[] num = new int[]{10, 9, 8, 7, 6, 5, 1,2, 3, 4};
        build(num, 10);
        for(int i = 0; i < 10; ++i) {
            System.out.print(num[i] + " ");
        }
    }

}
