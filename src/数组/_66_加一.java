package 数组;

/**
 * https://leetcode-cn.com/problems/plus-one/
 */
public class _66_加一 {
    public int[] plusOne(int[] digits) {
        int len = digits.length - 1;
        if (digits[len] < 9) {
            digits[len]++;
        } else {
            for (int i = len; i >= 0; i--) {
                if (digits[i] == 9) {
                    digits[i] = 0;
                    if (i == 0) {
                        int[] newArray = new int[digits.length + 1];
                        newArray[0] = 1;
                        digits = newArray;
                    }
                } else {
                    digits[i]++;
                    break;
                }
            }
        }
        return digits;
    }
}
