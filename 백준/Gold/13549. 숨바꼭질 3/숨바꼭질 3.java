import java.io.*;
import java.util.*;

// TODO 1. 갈을 경우 -> X-1 또는 X+1 (+ 1초)
// TODO 2. 순간이동할 경우 -> 2 * X (+ 0초)
// TODO Greedy? BFS?
// TODO (1) Greedy -> 해당 순간에 최적의 값을 선택 -> 걷거나 or 순간이동을 하거나
// TODO (2) BFS -> 일정한 규칙 아래에서 방향 전환이 이루어짐 -> 왼쪽 자식 노드 : 2 * x / 오른쪽 자식 노드 x - 1 또는 x + 1

// TODO 1. 왜 Greedy가 아닌 BFS일까? -> 최단 경로(= 가장 빠른 시간)를 찾아야 하니까 = 즉, Greedy가 최적해를 보장하진 않으니까?
// TODO 수빈이의 위치 : 배열의 인덱스, 수빈이가 해당 위치로 이동하는데 걸린 시간 : 배열의 값
class Node {
    int index;
    int value;

    public Node(int index, int value) {
        this.index = index;
        this.value = value;
    }
}

public class Main {
    // TODO 이 두 부분이 왜 필요할까?
    private static int min = Integer.MAX_VALUE; // min : 최소 비용, 즉 최소로 걸린 시간
    private static int max = 100_000; // max : 최댓값, 즉 입력에서 정해진 수빈이와 동생의 점의 위치
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        // TODO 왜 +1일까?
        boolean[] visited = new boolean[max + 1];

        bfs(n, k, visited);
        System.out.println(min);
        br.close();
    }

    private static void bfs(int n, int k, boolean[] visited) {
        // TODO A -> B와 같이 visited가 필요 없진 않고, 필요할듯
        Queue<Node> q = new LinkedList<>(); // 1. 큐 생성, 근데 항상 고민인 점이 무엇을 제네릭에 선언해야 할지가 난제
        q.offer(new Node(n, 0)); // 2. 원점을 큐에 삽입, 이때 offer()

        while(!q.isEmpty()) { // 3. 큐가 빌 때까지
            Node node = q.poll(); // 4. 큐에 들어간 node 객체를 빼내기
            visited[node.index] = true; // 5. 방문 처리

            if (node.index == k) { // 6. 탈출 조건 (현재 접근한 배열 값 = 주어진 도달해야 하는 값)
                min = Math.min(min, node.value);
            }

            if (node.index * 2 <= max && visited[node.index * 2] == false) {
                q.add(new Node(node.index * 2, node.value));
            }
            if (node.index + 1 <= max && visited[node.index + 1] == false) {
                q.add(new Node(node.index + 1, node.value + 1));
            }
            if (node.index - 1 >= 0 && visited[node.index - 1] == false) {
                q.add(new Node(node.index - 1, node.value + 1));
            }
        }
    }
}
