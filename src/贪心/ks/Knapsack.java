package 贪心.ks;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/**
 * @author CoderZk
 * <p>
 * 01背包 - 贪心
 */
public class Knapsack {
    public static void main(String[] args) {
        // 价值主导
        select(new Comparator<Article>() {
            @Override
            public int compare(Article o1, Article o2) {
                return o2.value - o1.value;
            }
        });

        // 重量主导
        select(new Comparator<Article>() {
            @Override
            public int compare(Article o1, Article o2) {
                return o1.weight - o2.weight;
            }
        });

        // 价值密度主导
        select(new Comparator<Article>() {
            @Override
            public int compare(Article o1, Article o2) {
                return Double.compare(o2.valueDensity, o1.valueDensity);
            }
        });
    }

    static void select(Comparator<Article> cmp) {
        Article[] articles = new Article[]{
                new Article(35, 10), new Article(30, 40),
                new Article(60, 30), new Article(50, 50),
                new Article(40, 35), new Article(10, 40),
                new Article(25, 30)
        };
        Arrays.sort(articles, cmp);

        int capacity = 150, weight = 0, value = 0;
        List<Article> selectedArticles = new LinkedList<>();
        for (int i = 0; i < articles.length; i++) {
            int newWeight = articles[i].weight + weight;
            if (newWeight <= capacity) {
                selectedArticles.add(articles[i]);
                weight = newWeight;
                value += articles[i].value;
            }
        }
        System.out.println("总价值: " + value);
    }
}
