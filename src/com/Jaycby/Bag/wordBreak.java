package com.Jaycby.Bag;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * @ClassName wordBreak
 * @Author cby
 * @Date 2022/12/19 18:10
 * @Version 1.0
 */
public class wordBreak {

    public static void main(String[] args) {

        String s = "applepenapple";
        List<String> wordDict = new ArrayList<>();
        wordDict.add("apple");
        wordDict.add("pen");
        boolean b = wordBreakApi(s, wordDict);
        System.out.println(b);
    }

    public static boolean wordBreakApi(String s, List<String> wordDict) {
        HashSet<String> set = new HashSet<>(wordDict);
        boolean[] valid = new boolean[s.length() + 1];
        valid[0] = true;

        for (int i = 0; i <= s.length(); i++) {
            for (int j = 0; j < i && !valid[i]; j++) {
                if (set.contains(s.substring(j, i)) && valid[j]) {
                    valid[i] = true;
                }
            }
        }

        return valid[s.length()];
    }
}
