// ※ 주어진 입력값을 무작정 다 받으려고 하지 말고 넣을 필요가 있는지에 대해서 생각
// ※ queue : x_n의 값이 계속해서 변경 <-> stack : x_n = x_n-1
// ※ 따라서 0일 경우 queue에 추가할 상황 + queue 및 stack에서 삭제할 상황 => deque
// ※ 또한, 인덱스 0 or 1에 대해서 한 번 더 생각하고 사용할 것

/*
 * x_0 = 2
 * (1) q -> FIFO -> x_1 = 1
 * (2) s -> LIFO -> x_2 = 1
 * (3) s -> LIFO -> x_3 = 1
 * (4) q -> FIFO -> x_4 = 4
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 1. 입력 변수 초기화
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st1 = new StringTokenizer(br.readLine(), " ");
        Deque<Integer> deque = new ArrayDeque<>();
        StringTokenizer st2 = new StringTokenizer(br.readLine(), " ");
        StringBuilder sb = new StringBuilder();

        // 2. 수열 A
        for (int i = 0; i < n; i++) {
            int queueStack = Integer.parseInt(st1.nextToken());
            int element = Integer.parseInt(st2.nextToken());

            if (queueStack == 0) {
                // Q. (예제 1 기준) 왜 이 곳에다가 element를 초기화한 후 deque에 추가하면 4가 아닌 2가 저장될까요?
                deque.addFirst(element);
            }
        }

        // 3. 수열 B
        int m = Integer.parseInt(br.readLine());
        ArrayList<Integer> arrayList = new ArrayList<>();
        st1 = new StringTokenizer(br.readLine(), " ");

        for (int i = 0; i < m; i++) {
            arrayList.add(Integer.parseInt(st1.nextToken()));
        }

        // 4. 로직
        for (int i = 0; i < m; i++) {
            // ※ 어차피 queue에만 값이 있으므로, 뒤(= 데크에서는 앞)에 값을 넣고 맨 앞(= 맨 뒤)의 값을 삭제 ?
            deque.addLast(arrayList.get(i));
            sb.append(deque.pollFirst()).append(" ");
        }

        // 4. 출력
        System.out.println(sb);
        br.close();
    }
}
