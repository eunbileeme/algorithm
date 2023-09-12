import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        Deque<Integer> deque = new ArrayDeque<>();

        for (int i = 0; i < n; i ++) {
            String[] str = br.readLine().split(" ");

            if (str[0].equals("push_front")) {
                deque.addFirst(Integer.parseInt(str[1]));
            } else if (str[0].equals("push_back")) {
                deque.addLast(Integer.parseInt(str[1]));
            } else if (str[0].equals("pop_front")) {
                if (deque.size() == 0) {
                    System.out.println(-1);
                } else {
                    System.out.println(deque.peekFirst());
                    deque.pollFirst();
                }
            } else if (str[0].equals("pop_back")) {
                if (deque.size() == 0) {
                    System.out.println(-1);
                } else {
                    System.out.println(deque.peekLast());
                    deque.pollLast();
                }
            } else if (str[0].equals("size")) {
                System.out.println(deque.size());
            } else if (str[0].equals("empty")) {
                if (deque.isEmpty() == true) {
                    System.out.println(1);
                } else {
                    System.out.println(0);
                }
            } else if (str[0].equals("front")) {
                if (deque.size() == 0) {
                    System.out.println(-1);
                } else {
                    System.out.println(deque.peekFirst());
                }
            } else {
                if (deque.size() == 0) {
                    System.out.println(-1);
                } else {
                    System.out.println(deque.peekLast());
                }
            }
        }

        br.close();
    }
}