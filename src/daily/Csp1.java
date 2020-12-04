package daily;

import java.util.Scanner;

import static java.lang.Math.pow;
import static java.lang.Math.sqrt;

public class Csp1 {
    private static Node[] nodes;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int X = input.nextInt();
        int Y = input.nextInt();

        nodes = new Node[n];

        for (int i = 0; i < n; i++) {
            int x = input.nextInt();
            int y = input.nextInt();
            double distance = sqrt(pow(X - x, 2) + pow(Y - y, 2));
            nodes[i] = new Node(i + 1, x, y, distance);
        }

        for (int begin = 1; begin < nodes.length; begin++) {
            int cur = begin;
            while (cur > 0 && cmp(cur, cur - 1) < 0) {
                swap(cur, cur - 1);
                cur--;
            }
        }

        for (int i = 0; i < 3; i++) {
            System.out.println(nodes[i].id);
        }
    }

    protected static int cmp(int i1, int i2) {
        return nodes[i1].compareTo(nodes[i2]);
    }

    protected static void swap(int i1, int i2) {
        Node tmp = nodes[i1];
        nodes[i1] = nodes[i2];
        nodes[i2] = tmp;
    }

    private static class Node implements Comparable<Node> {
        int id;
        int x;
        int y;
        double distance;

        Node(int id, int x, int y, double distance) {
            this.id = id;
            this.x = x;
            this.y = y;
            this.distance = distance;
        }

        @Override
        public int compareTo(Node o) {
            if (distance == o.distance) return 0;
            return distance - o.distance > 0 ? 1 : -1;
        }
    }
}

