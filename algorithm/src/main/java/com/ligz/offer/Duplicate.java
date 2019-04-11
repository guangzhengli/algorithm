package com.ligz.offer;

/**
 * 数组中重复的数字
 * 在一个长度为 n 的数组里的所有数字都在0到 n-1 的范围内。 数组中某些数字是重复的，但不知道有几个数字是重复的。也不知道每个数字重复几次。
 * 请找出数组中任意一个重复的数字。
 * 例如，如果输入长度为7的数组{2,3,1,0,2,5,3}，那么对应的输出是第一个重复的数字2
 * author:ligz
 */
public class Duplicate {
    public boolean duplicate(int numbers[],int length,int [] duplication) {
        if (numbers == null || length == 0) return false;
        //因为长度为 n ，数字最大为 n， 所以可以在O(1)的空间里面完成
        for (int i = 0; i < length; i++) {//对于这种数组元素在 [0, n-1] 范围内的问题，可以将值为 i 的元素调整到第 i 个位置上进行求解
            while (i != numbers[i]) {
                if (numbers[i] == numbers[numbers[i]]) {
                    duplication[0] = numbers[i];//这里要特别注意~返回任意重复的一个，赋值duplication[0]
                    return true;
                }
                swap(numbers, i, numbers[i]);
            }
        }
        return false;
    }

    private void swap(int[] numbers, int a, int b) {
        int temp = numbers[a];
        numbers[a] = numbers[b];
        numbers[b] = temp;
    }
}
