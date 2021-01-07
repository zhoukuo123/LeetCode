package 字符串;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode-cn.com/problems/determine-if-string-halves-are-alike/
 */
public class _1704_判断字符串的两半是否相似 {
    // Brute Force
    // Time: O(n) Space: O(1)
    public boolean halvesAreAlike(String s) {
        Set<Character> set = new HashSet<Character>() {
            {
                add('a');
                add('e');
                add('i');
                add('o');
                add('u');
                add('A');
                add('E');
                add('I');
                add('O');
                add('U');
            }
        };

        int len = s.length();
        int count1 = 0;
        int count2 = 0;
        for (int i = 0; i < len / 2; i++) {
            char ch = s.charAt(i);
            if (set.contains(ch)) {
                count1++;
            }
        }
        for (int i = len / 2; i < len; i++) {
            char ch = s.charAt(i);
            if (set.contains(ch)) {
                count2++;
            }
        }
        return count1 == count2;
    }
}
