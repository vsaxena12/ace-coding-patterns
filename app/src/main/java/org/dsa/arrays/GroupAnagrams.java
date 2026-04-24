package org.dsa.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class GroupAnagrams {
    private String checkAnagram(String s) {
        int[] num = new int[26];

        for(char c: s.toCharArray()) {
            num[c-'a']++;

        }

        StringBuilder stringBuilder = new StringBuilder();
        for(int n: num) {
            stringBuilder.append(n).append("#");
        }
        //System.out.println(stringBuilder.toString());
        return stringBuilder.toString();
    }
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for(String s: strs) {
            String val = checkAnagram(s);
            map.putIfAbsent(val, new ArrayList<>());
            map.get(val).add(s);
        }
        return new ArrayList<>(map.values());
    }

    public static void main(String[] args) {
        GroupAnagrams groupAnagrams = new GroupAnagrams();
        List<List<String>> list = groupAnagrams.groupAnagrams(new String[]{"bdddddddddd","bbbbbbbbbbc"});
        System.out.println(list);
    }
}
