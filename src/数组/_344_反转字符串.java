package 数组;

/**
 * https://leetcode-cn.com/problems/reverse-string/
 */
public class _344_反转字符串 {
    public void reverseString(char[] s) {
        int length = s.length;
        for (int left = 0, right = length - 1; left < right; left++, right--) {
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;
        }
    }
}
