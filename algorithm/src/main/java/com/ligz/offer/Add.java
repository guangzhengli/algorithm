package com.ligz.offer;

/**
 * 不用加减乘除做加法
 * 写一个函数，求两个整数之和，要求在函数体内不得使用+、-、*、/四则运算符号
 * author:ligz
 */
public class Add {
    /**
     * 首先看十进制是如何做的： 5+7=12，三步走
     * 第一步：相加各位的值，不算进位，得到2。
     * 第二步：计算进位值，得到10. 如果这一步的进位值为0，那么第一步得到的值就是最终结果。
     * 第三步：重复上述两步，只是相加的值变成上述两步的得到的结果2和10，得到12。
     */
    public int Add(int num1,int num2) {//a ^ b 表示没有考虑进位的情况下两数的和，(a & b) << 1 就是进位。
        while (num2 != 0) {
            int temp = num1 ^ num2;//计算没有进位的和
            num2 = (num1 & num2) << 1;//计算进位
            num1 = temp;
        }
        return num1;
    }
}