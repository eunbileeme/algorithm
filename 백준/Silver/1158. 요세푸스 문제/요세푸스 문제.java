import java.io.*;
import java.util.*;

public class Main {
    // TODO 요세푸스 문제
    // TODO 1. 남아있는 값들을 대상으로 k만큼 순회해야함 -> ex. [3, 6, 2]에서 7을 선택할 때 (4 -> 5 -> 7)
    // TODO 2. n에 도달해도 끝나지 않고, 원형 사이클처럼 1과 이어져 있다고 생각하고 카운트해야함 -> ex. [3, 6]에서 2를 선택할 때 (7 -> 1 -> 2)

    // 이전에 풀었던 적이 있는 문제와 비슷 (요세푸스 0)
    // 큐인가? -> 그런데, 큐는 FIFO니까 아니지 않을까? ex. 7 -> 1 -> 2 -> 그런데, 1 ~ 7까지 순서대로 넣었다가 해당 차례의 값을 다시 넣는다면?
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        sb.append("<");

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        Queue<Integer> queue = new LinkedList<>();
        // 1. 큐에 값 입력
        for (int i = 1; i <= n; i++) {
            queue.add(i);
        }

//        for (Integer i : queue) {
//            System.out.println(i);
//        }

        // 2. 큐 순회
        // 3. (이미 있는 값이자) 해당 차례의 값을 다시 꺼냈다가 넣는다면? -> 아니지 큐 자체를 출력하면? -> 큐 = [3, 6, 2, 7, 5, 1, 4]
        // (1) 큐 = 요세푸스 문제 -> 불가. 그냥 for문을 통해서 큐를 순회시킬 수는 없음.
        
        // (2) 큐에서 요세푸스 순으로 꺼내기
        while (!queue.isEmpty()) { // 큐가 비어있을 때까지
            for (int i = 1; i <= k; i++) { // 1 -> 2 -> 3 / 4 -> 5 -> 6 / ..
                if (i == k) sb.append(queue.remove()).append(", ");
                else queue.add(queue.remove());
            }
        }

        sb.replace(sb.length() - 2, sb.length() - 1, ">");
        System.out.println(sb);
        br.close();
    }
}
