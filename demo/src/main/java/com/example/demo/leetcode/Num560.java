package com.example.demo.leetcode;

import java.util.HashMap;

public class Num560 {

    public static void main(String[] args) {
        int i = subarraySum(new int[]{1, 1, 1}, 2);
        System.out.println(i);
    }
    public static int subarraySum(int[] nums, int k) {
        int count = 0, pre = 0;
        HashMap < Integer, Integer > mp = new HashMap<>();
        mp.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            System.out.println("*******");
            System.out.println(mp);
            System.out.println(pre);
            pre += nums[i];
            if (mp.containsKey(pre - k)) {
                count += mp.get(pre - k);
            }
            mp.put(pre, mp.getOrDefault(pre, 0) + 1);
        }
        return count;
    }
}
