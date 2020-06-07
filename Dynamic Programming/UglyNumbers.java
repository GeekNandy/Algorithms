package com.algos.dynamic_programming;

/*
* Problem Statement:
* Ugly numbers are numbers whose only prime factors are 2, 3 or 5.
* The sequence 1, 2, 3, 4, 5, 6, 8, 9, 10, 12, 15, … shows the first 11 ugly numbers.
* By convention, 1 is included. Given a number n, the task is to find n’th Ugly number
* */

import java.util.*;

public class UglyNumbers {
    public static void main(String[] args) {
        int i2=0, i3=0, i5=0, nxtMulOf2s = 2, nxtMulOf3s = 3, nxtMulOf5s = 5;
        Scanner s = new Scanner(System.in);
        System.out.println("Kindly enter which nth ugly number you want");
        int n = s.nextInt();
        int[] uglyNums = new int[n];
        uglyNums[0]=1;
        for(int i=1; i<n; i++) {
            uglyNums[i] = Math.min(nxtMulOf2s, Math.min(nxtMulOf3s, nxtMulOf5s));
            if (uglyNums[i] == nxtMulOf2s) {
                i2++;
                nxtMulOf2s = uglyNums[i2] * 2;
            }
            if (uglyNums[i] == nxtMulOf3s) {
                i3++;
                nxtMulOf3s = uglyNums[i3] * 3;
            }
            if (uglyNums[i] == nxtMulOf5s) {
                i5++;
                nxtMulOf5s = uglyNums[i5] * 5;
            }
        }
        System.out.println(uglyNums[n-1]);
        s.close();
    }
}
