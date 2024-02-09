import java.io.*;
import java.util.*;

// TODO 방향성이 없는 그래프 ->
// TODO 임의로 주어진 두 정점은 반드시 통과 ->
// TODO 한 번 이동했던 정점뿐만 아니라 이동했던 간선도 다시 이동할 수 있음 ->
// TODO 최단 경로 -> BFS(방향이 있는 / 없는), 플로이드 와샬(모든 정점 -> 모든 정점), 다익스트라(한 정점 -> 모든 정점)

// TODO 1. (중요, 최단 경로 문제 - 접근법에서 난항을 겪는 경우가 많은듯) 왜 다익스트라일까?
// TODO 2. 간선의 최대 개수는 200,000이고 가중치의 최댓값은 1,000이기 때문에 INF = 200,000,000?
class Node implements Comparable<Node> {
    int end;
    int weight;

    Node(int end, int weight) {
        this.end = end;
        this.weight = weight;
    }

    // TODO other의 값을 확인해야 함.
    @Override
    public int compareTo(Node other) {
        return weight - other.weight;
    }
}

public class Main {
    private static ArrayList<ArrayList<Node>> adjacencyList;
    // private static boolean[] visited; 필요 없는 거 맞는듯
    private static int[] dist;
    private static int INF = 100_000_000; // 상수 변수명이니까 상수로 빼는게 나을듯
    private static int n, e;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());

        // 근데 주어진 두 개의 정점(예제 입력 1 기준, 2와 3)을 꼭 지나야만 한다면..
        // 1 -> 2 는 없는거 아냐? 반드시 1 -> 2 -> 3까지는 가야할 것 같은데..
        // 1 -> 2 -> 3
        // 1 -> 3 -> 2
        // ..

        // TODO 러프하게 생각해보자면, 두 노드를 모두 거쳐야 하므로 1 -> n까지 최소 경로를 탐색하는 과정에 두 노드를 모두 탐색
        // TODO 이때, 첫 번째 예시를 기준으로 1 -> v1, v1 -> v2, v2 -> n으로 다익스트라를 수행하면 됨
        // TODO 1 -> v1 -> v2 -> n
        // TODO 1 -> v2 -> v1 -> n
        adjacencyList = new ArrayList<>();
        // visited = new boolean[n + 1];
        dist = new int[n + 1]; // n으로도 해봐야 함

        // TODO ajacencyList, visited, dist 초기화 시 값 출력.
        // TODO 초기화를 어디에서 하냐도 차이가 있는지 확인해봐야 함.
        Arrays.fill(dist, INF);

        for (int i = 0; i <= n; i ++) {
            adjacencyList.add(new ArrayList<>());
        }

        for (int i = 0; i < e; i ++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            adjacencyList.get(start).add(new Node(end, weight));
            adjacencyList.get(end).add(new Node(start, weight));
        }

        st = new StringTokenizer(br.readLine());
        int v1 = Integer.parseInt(st.nextToken());
        int v2 = Integer.parseInt(st.nextToken());

        // 1 -> v1 -> v2 -> n
        int firstV1Result = 0;
        firstV1Result += dijkstra(1, v1);
        firstV1Result += dijkstra(v1, v2);
        firstV1Result += dijkstra(v2, n);

        // 1 -> v2 -> v1 -> n
        int firstV2Result = 0;
        firstV2Result += dijkstra(1, v2);
        firstV2Result += dijkstra(v2, v1);
        firstV2Result += dijkstra(v1, n);

        // 두 경우의 최단 경로 비용값이 INF보다 크면 정상적인 경로로는 갈 수 없다는 뜻이므로 -1
        int result = (firstV1Result >= INF && firstV2Result >= INF) ? -1 : Math.min(firstV1Result, firstV2Result);

        System.out.println(result);
        br.close();
    }

    private static int dijkstra(int start, int end) {
        Arrays.fill(dist, INF);
        // Arrays.fill(visited, false);

        PriorityQueue<Node> pq = new PriorityQueue<>();
        // TODO 다익스트라를 수행할 때마다 탐색 주체 노드가 달라지므로 새로운 방문 배열인 visited를 만들어줘야 함
        boolean[] visited = new boolean[n + 1];

        pq.offer(new Node(start, 0)); // 외곽
        dist[start] = 0;

        while(!pq.isEmpty()) {
            // TODO currentNode의 내부구조 확인 요망.
            Node currentNode = pq.poll();
            int current = currentNode.end;

            if (!visited[current]) {
                visited[current] = true;

                for (Node node : adjacencyList.get(current)) {
                    if (!visited[node.end] && dist[node.end] > dist[current] + node.weight) {
                        dist[node.end] = dist[current] + node.weight;
                        pq.add(new Node(node.end, dist[node.end])); // 내부
                    }
                }
            }
        }

        return dist[end];
    }
}
