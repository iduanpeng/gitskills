package com.iduanpeng.leetcode;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * 字符串最大不重复子串长度
 */
public class T2_StringMaxChildString {

    public static void main(String[] args) {
        T2_StringMaxChildString test = new T2_StringMaxChildString();
        String s = "abcabfgrbb";
        int length = test.lengthOfLongestSubString(s);
        System.out.println(length);

        int length1 = test.lengthOfLongestSubString2(s);
        System.out.println(length1);
    }

    //1 判断两个位置质检的字符串是否有重复的 没有 判断当前长度是否最大
    public int lengthOfLongestSubString(String s){
        int n = s.length();
        int ans = 0;
        for(int i = 0;i< n;i++){
            for(int j = i+1;j<=n;j++){
                if(allUnique(s,i,j)){
                    ans = Math.max(ans,j-i);
                }
            }
        }
        return ans;
    }

    public boolean allUnique(String s,int start,int end){
        Set<Character> set = new HashSet<>();
        for(int i = start;i < end; i++){
            char c = s.charAt(i);
            if (set.contains(c)){
                return false;
            }
            set.add(c);
        }
        return true;
    }

    //2 滑动窗口思想
    /**
     * 如果确定字串s[i,j](假设表示字符串的第i个字符串到第j-1个字符表示的字串) 那么只需要比较s[j]是否与字串s[i,j]重复即可
     *
     * 若重复：记录此时滑动窗口大小，并与最大滑动窗口比较，赋值，然后滑动窗口尾部位置不变，头位置右移一个单位，
     *
     * 若不重复：滑动窗口不变 结尾+1，整个窗口加大一个单位，继续比较下一个
     */
    public int lengthOfLongestSubString2(String s){
        int n = s.length();
        Set<Character> set = new LinkedHashSet<>();
        int ans = 0;
        int i = 0;
        int j = 0;
        int start = 0;
        int end = 0;
        while(i<n && j<n){
            if(!set.contains(s.charAt(j))){
                set.add(s.charAt(j++));
                //输出字符串的话 加此代码
//                if (j-i > ans){
//                    start = i;
//                    end = j;
//                }
                ans = Math.max(ans,j -i);
            } else {
                set.remove(s.charAt(i++));
            }
        }
//        System.out.println(s.substring(start,end));
        return ans;
    }



}
