import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// TODO 1. 2를 곱한다.
// TODO 2. 1을 수의 가장 오른쪽에 추가한다. (단, 1을 수치적으로 더하는 것이 아니라 str + str 개념으로 붙이는 것)
// TODO 이전 값을 활용해서 새로운 값을 만들어낸다는 점에서 DP 같음 -> Greedy / BFS 중 하나로 풀이
// TODO 1 <= A < B <= 10^9 -> 1,000,000,000 -> 1 ~ 1,000,000,000을 다 안 돈다는 점에서 괜찮지 않을까? 그러니까 O(n)이 안 나올 것 같은데..
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        int minResult = -1; // 연산의 최솟값 구하기
        int cnt = 1;

        // TODO 왜 A -> B가 아닌 B -> A로 접근해야 할까?
        while(true) {
            if (b == a) {
                minResult = cnt;
                break;
            }

            if (b % 10 == 1) { // ex. 101 % 10 = 1
                b /= 10; // 101 / 10 = 10
                cnt ++;

                //System.out.println("b % 10 == 1, cnt = " + cnt);
            } else if (b % 2 == 0) {
                if (b == 0) {
                    break;
                }
                b /= 2;
                cnt ++;

                //System.out.println("b % 2 == 0, cnt = " + cnt);
            } else {

                //System.out.println("minResult = -1");
                break;
            }
        }

        System.out.println(minResult);
        br.close();
    }
}
