package org.lsh;

import java.util.*;

/**
 * @author lsh
 * @description:
 */
public class Ap {
    public static void main(String[] args) {
        String[] words = new String[]{"abc", "deq", "mee", "aqq", "dkd", "ccc"};
        String pattern = "abb";
        System.out.println(findAndReplacePattern(words, pattern));
    }

    public static List<String> findAndReplacePattern(String[] words, String pattern) {
        int[] zm;
        int[] pat = new int[55];
        int[] dest;
        int index = 0;
        int count = 1;
        int t = 97;
        zm = new int[55];
        for (char c : pattern.toCharArray()) {
            int temp = (int) c - t;
            if (zm[temp] == 0) {
                zm[temp] = count;
                pat[index++] = count++;
            } else {
                pat[index++] = zm[temp];
            }
        }
        List<String> ans = new ArrayList<>();
        for (String word : words) {
            dest = new int[55];
            zm = new int[55];
            count = 1;
            index = 0;
            for (char c : word.toCharArray()) {
                int temp = (int) c - t;
                if (zm[temp] == 0) {
                    zm[temp] = count;
                    dest[index++] = count++;
                } else {
                    dest[index++] = zm[temp];
                }
            }
            boolean isEq = true;
            for (int i = 0; i < zm.length; i++) {
                if (dest[i] != pat[i]) {
                    isEq = false;
                    break;
                }
            }
            if (isEq) {
                ans.add(word);
            }
        }
        return ans;
    }
}