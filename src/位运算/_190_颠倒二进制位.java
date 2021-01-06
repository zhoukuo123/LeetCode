package 位运算;

/**
 * https://leetcode-cn.com/problems/reverse-bits/
 */
public class _190_颠倒二进制位 {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int res = 0;
        int bits = 0;
        int power = 31;
        while (n != 0) {
            bits = n & 1;
            res = res + (bits << power);
            power--;
            n >>>= 1;
        }
        return res;
    }
}
