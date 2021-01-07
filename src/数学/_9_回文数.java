package 数学;

/**
 * https://leetcode-cn.com/problems/palindrome-number/
 */
public class _9_回文数 {
    public boolean isPalindrome(int x) {
        // 边界判断, 末尾为0直接返回false
        if (x % 10 == 0 && x != 0) return false;
        int revertNum = 0;
        int y;
        while (x > revertNum) {
            y = x % 10;
            revertNum = revertNum * 10 + y;
            x /= 10;
        }
        return x == revertNum || x == revertNum / 10;
    }

    // 数学解法
    public boolean isPalindrome2(int x) {
        if (x < 0) return false;
        int div = 1;

        while (x / div >= 10) {
            div *= 10;
        }
        while (x > 0) {
            int left = x / div;
            int right = x % 10;
            if (left != right) return false;
            x = (x % div) / 10;
            div /= 100;
        }
        return true;
    }

    public static void main(String[] args) {
        new _9_回文数().isPalindrome2(1221);
    }

    // 转为字符串
    public boolean isPalindrome3(int x) {
        String reversedStr = new StringBuilder(x + "").reverse().toString();
        return (x + "").equals(reversedStr);
    }
}
