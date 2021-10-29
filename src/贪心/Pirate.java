package 贪心;

import java.util.Arrays;

/**
 * @author CoderZk
 * <p>
 * 海盗船取古董
 */
public class Pirate {
    public static void main(String[] args) {
        int[] weights = {3, 5, 4, 10, 7, 14, 2, 11};
        Arrays.sort(weights);
        int capacity = 30;
        int weight = 0;
        int count = 0;
        for (int i = 0; i < weights.length && weight < capacity; i++) {
            int newWeight = weight + weights[i];
            if (newWeight <= capacity) {
                weight = newWeight;
                count++;
            }
        }

        System.out.println("一共选了" + count + "件古董");
    }
}
