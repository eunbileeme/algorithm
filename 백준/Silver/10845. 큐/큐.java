import java.io.*;
import java.util.*;

public class Main {
    public static boolean[][] arr;
    public static int min = 64;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        Queue<Integer> queue = new LinkedList<>();
        int lastElement = -1;  // ※ 가장 최근에 추가된 원소를 추적

        for (int i = 0; i < n; i ++) {
            String[] str = br.readLine().split(" ");

            if (str[0].equals("push")) {
                queue.add(Integer.parseInt(str[1]));
                lastElement = Integer.parseInt(str[1]);
            } else if (str[0].equals("pop")) {
                if (queue.size() == 0) {
                    System.out.println(-1);
                } else {
                    System.out.println(queue.peek());
                    queue.remove();
                }
            } else if (str[0].equals("size")) {
                System.out.println(queue.size());
            } else if (str[0].equals("empty")) {
                System.out.println(queue.isEmpty() ? 1 : 0);
            } else if (str[0].equals("front")) {
                System.out.println(queue.isEmpty() ? -1 : queue.peek());
            } else {
                System.out.println(queue.isEmpty() ? -1 : lastElement);
            }
        }

        br.close();
    }
}