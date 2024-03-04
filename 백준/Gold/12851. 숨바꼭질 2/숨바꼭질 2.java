import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// TODO 동생을 찾는다. -> 동생이 목적지, 목적지에 도달한다.
// TODO "목적지에 도달하는 가장 빠른 시간" + "빠른 시간의 경우의 수" 출력.

// n (수빈이의 위치)
// N-1                 N+1              2*N       (큐에 들어갈 1초 후에 이동한 수빈이의 위치)
// N-1 N+1 2*N     N-1 N+1 2*N      N-1 N+1 2*N
// ..
public class Main {
    static int n, k;
    static int[] time = new int[100001]; // visited
    static int minTime = Integer.MAX_VALUE; // 987654321;
    static int count = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        if (n >= k) {
            System.out.println((n - k) + "\n1"); // TODO 체크 요망.
            return;
        }

        bfs();

        System.out.println(minTime);
        System.out.println(count);
        br.close();
    }

    private static void bfs() {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(n);
        time[n] = 1;

        while (!queue.isEmpty()) {
            int current = queue.poll();

            if (minTime < time[current]) {
                return;
            }

            int moveAbleCase = 3;
            for (int i = 0; i < moveAbleCase; i++) {
                int next;

                if (i == 0) { // X+1 == 0일 때,
                    next = current + 1;
                } else if (i == 1) {
                    next = current - 1;
                } else {
                    next = current * 2;
                }

                if (next == k) {
                    minTime = time[current]; // <-> time[current] + 1
                    // minTime = time[next];
                    count++;
                }

                if (next < 0 || next > 100000) {
                    continue;
                }

                if (time[next] == 0 || time[next] == time[current] + 1) {
                    queue.offer(next);
                    time[next] = time[current] + 1;
                }
            }
        }

//        sb.append(minTime).append("\n");
//        sb.append(count);
    }
}
