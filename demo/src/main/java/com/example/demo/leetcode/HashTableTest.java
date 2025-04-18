package com.example.demo.leetcode;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class HashTableTest {


    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("fkdjfjfdh"));
    }


    /**
     * 3. 无重复字符的最长子串
     * 使用滑动窗口解决
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstring(String s) {
        // 哈希集合，记录每个字符是否出现过
        Set<Character> occ = new HashSet<>();
        int n = s.length();
        // 右指针，初始值为 -1，相当于我们在字符串的左边界的左侧，还没有开始移动
        int rk = -1, ans = 0;
        for (int i = 0; i < n; ++i) {
            if (i != 0) {
                // 左指针向右移动一格，移除一个字符,这样做是为了从每个位置都检查一下看看有没有更长的字符串
                occ.remove(s.charAt(i - 1));
            }


            while (rk + 1 < n && !occ.contains(s.charAt(rk + 1))) {
                System.out.println(i);
                System.out.println(rk);
                System.out.println(occ);
                System.out.println("*************");
                // 不断地移动右指针
                occ.add(s.charAt(rk + 1));
                ++rk;
            }
            // 第 i 到 rk 个字符是一个极长的无重复字符子串
            ans = Math.max(ans, rk - i + 1);
        }
        return ans;
    }


}
