package 字符串;

/**
 * https://leetcode-cn.com/problems/valid-palindrome/
 */
public class _125_验证回文串 {
    // 筛选 + 判断(使用reverse API)
    public boolean isPalindrome1(String s) {
        StringBuilder sgood = new StringBuilder();
        int length = s.length();
        for (int i = 0; i < length; i++) {
            char ch = s.charAt(i);
            if (Character.isLetterOrDigit(ch)) {
                sgood.append(Character.toLowerCase(ch));
            }
        }
        return sgood.toString().equals(sgood.reverse().toString());
    }

    // 筛选 + 判断(使用双指针)
    public boolean isPalindrome2(String s) {
        StringBuilder sgood = new StringBuilder();
        int length = s.length();
        for (int i = 0; i < length; i++) {
            char ch = s.charAt(i);
            if (Character.isLetterOrDigit(ch)) {
                sgood.append(Character.toLowerCase(ch));
            }
        }

        for (int left = 0, right = sgood.length() - 1; left < right; left++, right--) {
            char ch1 = sgood.charAt(left);
            char ch2 = sgood.charAt(right);

            if (ch1 != ch2) return false;
        }
        return true;
    }

    // 在原字符串上直接判断 双指针 Space: O(1)
    public boolean isPalindrome3(String s) {
        int left = 0, right = s.length() - 1;
        while (left < right) {
            char ch1 = s.charAt(left);
            char ch2 = s.charAt(right);
            if (Character.isLetterOrDigit(ch1) && Character.isLetterOrDigit(ch2)) {
                if (Character.toLowerCase(ch1) != Character.toLowerCase(ch2)) return false;
                left++;
                right--;
                continue;
            }
            if (!Character.isLetterOrDigit(ch1)) {
                left++;
            }
            if (!Character.isLetterOrDigit(ch2)) {
                right--;
            }
        }
        return true;
    }
}
