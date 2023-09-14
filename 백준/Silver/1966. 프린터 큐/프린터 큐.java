import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int testNum = Integer.parseInt(br.readLine());

        for (int t = 0; t < testNum; t ++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int docsNum = Integer.parseInt(st.nextToken());
            int targetIdx = Integer.parseInt(st.nextToken());

            /*
             * Queue:
             * - [1, 0] (중요도 1, 인덱스 0)
             * - [2, 1] (중요도 2, 인덱스 1)
             * - [3, 2] (중요도 3, 인덱스 2)
             * - [4, 3] (중요도 4, 인덱스 3)
             */

            st = new StringTokenizer(br.readLine(), " ");
            Queue<int[]> queue = new LinkedList<>();
            for (int i = 0; i < docsNum; i++) {
                queue.add(new int[]{Integer.parseInt(st.nextToken()), i});
            }

            int printCount = 0;

            while (!queue.isEmpty()) {
                int[] frontDoc = queue.poll(); // ※ 가장 앞에 위치한 문서(위치, 중요도)
                boolean maxPriority = true;

                // ※ 중요도 비교
                for (int[] doc : queue) {
                    if (doc[0] > frontDoc[0]) { // ※ 그 다음에 위치한 문서 > 가장 앞에 있는 문서
                        maxPriority = false; // ※ 가장 크지 않다는 것
                        break;
                    }
                }

                // ※ 인덱스(= 위치) 비교
                if (maxPriority) {
                    printCount++;
                    if (frontDoc[1] == targetIdx) {
                        sb.append(printCount).append('\n');
                        break;
                    }
                } else {
                    queue.add(frontDoc);
                }
            }
        }

        System.out.println(sb);

        br.close();
    }
}