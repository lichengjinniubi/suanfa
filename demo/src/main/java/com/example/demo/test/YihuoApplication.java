package com.example.demo.test;

public class YihuoApplication {


    public static void main(String[] args) {
        int[] aa = {0,3,1};
        test(aa);
    }


    public static void test(int[] nums){
        System.out.println(nums);
        int res = 0;
        for (int i = 0; i < nums.length; ++i) {
            System.out.println(i);
            System.out.println(res);
            res ^= i;
            res ^= nums[i];
            System.out.println(res);
            System.out.println("&&&&&&&&&&&&&&&");
        }
        System.out.println(res);
        System.out.println(nums.length);
        res ^= nums.length;

        System.out.println(res);

    }
}
