package com.example.demo.leetcode;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * 最小覆盖子串
 */
class Shifoushizishu {

    public static void main(String[] args) {
        //Num76 solution = new Num76();
        System.out.println(countPrimes(2));
    }


    public static int countPrimes(int n) {
        int ans = 0;
        for (int i = 2; i < n; ++i) {
            ans += isPrime(i) ? 1 : 0;
        }
        return ans;
    }

    public static boolean isPrime(int x) {
        for (int i = 2; i * i <= x; ++i) {
            if (x % i == 0) {
                return false;
            }
        }
        return true;
    }
}

