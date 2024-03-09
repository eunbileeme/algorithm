import java.io.*;
import java.util.*;

// TODO 서강 그라운드 : "필드에서 예은이가 얻을 수 있는 아이템의 최대 개수 구하기"

// TODO 1. 수색 범위(ex. 4)에 따라 방문할 수 있는 지점이 한정되어 있음 -> 최단 거리(dist[])를 구해서 수색할 수 있는 범위 내, 아이템 개수를 파악해야
// TODO 2. 수색 범위 내의 "모든" 노드들은 방문할 수 있음
// TODO 3. 최단 거리 내 + 모든 노드들을 방문 -> 다익스트라

// TODO Q. 아이템 수를 Node 클래스 내의 필드로 받을 수는 없나
//  -> 깊게 생각해보지 않았음, 단지 그래프를 구현할 때 노드 번호(ex. index) / 간선 정보(ex. weight)와 같은 정보는 저장했으니
//  -> 노드가 "가지고 있는" 아이템의 개수도 가능하지 않을까? 싶었음
// TODO Q. 그래프에 "가중치가 없다"가 무슨 뜻일까?
//  -> 그래프에 길의 길이가 존재 + 해당 길의 길이는 주어진 수색 범위에 영향을 미치는데?
// Q. (진혁) from, to, l -- from 및 to를 인덱스로 넘긴다면 저장할 정보가 한 개뿐이므로 -> data[from][to] = l과 같이 구현

public class Main {
    static class Position implements Comparable<Position> {
        int regionNum;
        int weight;

        Position(int regionNum, int weight) {
            this.regionNum = regionNum;
            this.weight = weight;
        }

        @Override
        public int compareTo(Position o) {
            return weight - o.weight;
        }
    }

    static int n, scanScope, m;
    static ArrayList<ArrayList<Position>> graph; // final 유무?
    // TODO (복기) 그래프는 방문 탐색을 진행.
    static boolean[] visited;
    static int[] items;
    static int[] dist;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        // 1. 첫 번째 줄 입력 : 지역의 개수(n), 예은이의 수색범위(scanScope), 길의 개수(road)
        n = Integer.parseInt(st.nextToken());
        scanScope = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        // 2. 두 번째 줄 입력 : 아이템의 수
        // TODO 그래프의 추가 정보로 받기 vs int[]로 받기
        items = new int[n + 1];
        st = new StringTokenizer(br.readLine(), " ");
        // (중요) 그래프는 1부터 n번까지의 정점만 존재
        for (int i = 1; i <= n; i++) {
            items[i] = Integer.parseInt(st.nextToken());
        }

        // 3. 세 번째 ~ 줄 입력 : 출발 노드(a), 도착 노드(b), 간선(l)
        // (1) 그래프 틀 구현
        graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) { // TODO 출력 해보기.
            graph.add(new ArrayList<>());
        }

        for (int i = 1; i <= m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            graph.get(start).add(new Position(end, weight));
            graph.get(end).add(new Position(start, weight));
        }

        // 4. 최단 거리 및 방문 처리 초기화
        dist = new int[n + 1];
        visited = new boolean[n + 1];

        int maxItemNum = 0;
        for (int i = 1; i <= n; i++) {
            maxItemNum = Math.max(maxItemNum, dijkstra(i));
        }

        System.out.println(maxItemNum);
        br.close();
    }

    private static int dijkstra(int start) {
        Arrays.fill(dist, Integer.MAX_VALUE);
        Arrays.fill(visited, false);

        PriorityQueue<Position> pq = new PriorityQueue<>();
        pq.offer(new Position(start, 0));
        dist[start] = 0;

        while (!pq.isEmpty()) {
            Position currentRegion = pq.poll();
            int region = currentRegion.regionNum;

            if (!visited[region]) {
                visited[region] = true;

                for (Position position : graph.get(region)) {
                    if (!visited[position.regionNum] && dist[position.regionNum] > dist[region] + position.weight) {
                        dist[position.regionNum] = dist[region] + position.weight;
                        pq.add(new Position(position.regionNum, dist[position.regionNum]));
                    }
                }
            }
        }

        int result = 0;
        for (int i = 1; i <= n; i++) { // TODO 복기 요망.
            if (dist[i] <= scanScope) {
                result += items[i];
            }
        }

        return result;
    }
}
