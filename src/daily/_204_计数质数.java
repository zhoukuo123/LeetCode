package daily;

/**
 * https://leetcode-cn.com/problems/count-primes/
 */
public class _204_计数质数 {
    // 枚举优化 O(n√n)
    public int countPrimes(int n) {
        int ans = 0;
        for (int i = 2; i < n; i++) {
            ans += isPrime(i) ? 1 : 0;
        }
        return ans;
    }

    private boolean isPrime(int x) {
        for (int i = 2; i * i <= x; i++) {
            if (x % i == 0) {
                return false;
            }
        }
        return true;
    }

    // 直接暴力枚举 超时 O(n^2)
    public int countPrimes2(int n) {
        if (n == 0 || n == 1) return 0;
        int count = 0;
        int flag;
        for (int i = 2; i < n; i++) {
            flag = 1;
            for (int j = 2; j < i; j++) {
                if (i % j == 0) {
                    flag = 0;
                    break;
                }
            }
            if (flag == 1) {
                count++;
            }
        }
        return count;
    }
}
