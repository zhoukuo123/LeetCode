package 贪心;

import java.util.Arrays;

/**
 * @author CoderZk
 * <p>
 * 零钱交换
 */
public class CoinChange {
    public static void main(String[] args) {
        int[] faces = {25, 10, 5, 1};
        Arrays.sort(faces); // 1 5 10 25

        int money = 41, coins = 0;
        for (int i = faces.length - 1; i >= 0; i--) {
            if (faces[i] <= money) {
                money -= faces[i];
                coins++;
                i++;
            }
        }
        System.out.println(coins);
    }
}
