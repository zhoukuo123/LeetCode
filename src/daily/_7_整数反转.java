package daily;

/**
 * https://leetcode-cn.com/problems/reverse-integer/
 */
public class _7_整数反转 {
    public int reverse(int x) {
        long n = 0;
        while (x != 0) {
            n = n * 10 + x % 10;
            x = x / 10;
        }
        return (int) n == n ? (int) n : 0;
    }

    public int reverse2(int x) {
        String str = Integer.toString(x);
        int flag = 1;
        if (x < 0) {
            flag = -1;
            str = Integer.toString(-x);
        }
        String s = new StringBuilder(str).reverse().toString();

        try {
            return Integer.parseInt(s) * flag;
        } catch (NumberFormatException e) {
            return 0;
        }
    }

    public static void main(String[] args) {
        int m = new _7_整数反转().reverse2(1534236469);
        System.out.println(m);
    }
}
