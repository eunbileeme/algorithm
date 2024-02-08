import java.io.*;
import java.util.*;

// TODO 학생 : n명(= 각 마을에 한 명씩 사므로 마을도 n개), 파티 마을 : x번째, 도로 : x번째 마을의 m개, 시간 : Ti(m개 중 i번째 도로를 지날 때)
// TODO (1) 단방향 -> 양방향이 아닐 수도 있다는 점
// TODO (2) 최단 거리 -> BFS, 플로이드 와샬, 다익스트라
// TODO 하지만, 플로이드 와샬 알고리즘은 O(n^3)이므로 N이 최대 1,000일 경우는 1,000,000,000(10억)이 되므로 불가
// TODO 따라서 모든 정점에서 모든 정점에 대한 최단거리가 아닌, 모든 정점에 대해서 x까지의 거리만 알면 됨

// TODO 1. 왜 플로이드 와샬이 안 될까? -> o
// TODO 2. 왜 모든 정점에 대해서 x까지의 거리만 알면 될까? -> ..
// TODO 3. 왜 다익스트라일까? -> o
class Town implements Comparable<Town> {
    int end;
    int weight;

    Town(int end, int weight) {
        this.end = end;
        this.weight = weight;
    }

    @Override
    public int compareTo(Town other) {
        return weight - other.weight;
    }
}

public class Main {
    private static ArrayList<ArrayList<Town>> adjacencyList, reverseAdjacencyList; // 양방향일 수도, 아닐 수도 있는 경우를 위한 각각의 단방향 리스트

    //    private static int[] dist;
//    private static int[] reverseDist;
//    private static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // n 학생의 수, m x번째 마을의 도로의 수, x x번째 마을
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());

        // TODO (질문) 아니면 방향이 없는 BFS? 그럼 다익스트라랑 차이가 뭐지?
        // BFS : 어느 노드로 가든 공통 규칙이 정해짐
        // <-> 다익스트라 : 입력 때부터 규칙이 정해짐, 전체 노드가 아닌 인접 노드에 대해서만 거리가 정해짐
        // <-> 플로이드 와샬 : x라는 도착지점이 정해져 있으므로 모든 노드에 대해 도착하는 것이 아님 + 시작 복잡도

        // TODO x를 시작점으로 잡은 후, n -> x와 x -> n의 거리를 각각 구해서 다익스트라를 진행

        adjacencyList = new ArrayList<>();
        reverseAdjacencyList = new ArrayList<>();

//        dist = new int[n + 1];
//        reverseDist = new int[n + 1];
//        visited = new boolean[n + 1];
//
//        Arrays.fill(dist, Integer.MAX_VALUE);
//        Arrays.fill(reverseDist, Integer.MAX_VALUE);

        for (int i = 0; i <= n; i++) {
            adjacencyList.add(new ArrayList<>());
            reverseAdjacencyList.add(new ArrayList<>());
        }

        // 단방향 인접 리스트 구현
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken()); // 시작점
            int end = Integer.parseInt(st.nextToken()); // 끝점
            int weight = Integer.parseInt(st.nextToken()); // 걸리는 시간

            adjacencyList.get(start).add(new Town(end, weight));
            reverseAdjacencyList.get(end).add(new Town(start, weight));
        }

        int[] dist = dijkstra(n, x, adjacencyList);
        int[] reverseDist = dijkstra(n, x, reverseAdjacencyList);

        int maxTime = 0;
        for (int i = 1; i <= n; i++) {
            maxTime = Math.max(maxTime, dist[i] + reverseDist[i]);
        }

        System.out.println(maxTime);
        br.close();
    }

    private static int[] dijkstra(int n, int x, ArrayList<ArrayList<Town>> list) {
        PriorityQueue<Town> pq = new PriorityQueue<>();
        pq.offer(new Town(x, 0));

        boolean[] visited = new boolean[n + 1];
        int[] dist = new int[n + 1];

        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[x] = 0;

        while (!pq.isEmpty()) {
            Town currentTown = pq.poll();
            int current = currentTown.end;
            // System.out.println("current = " + current);

            if (!visited[current]) {
                visited[current] = true;

                for (Town town : list.get(current)) {
                    if (!visited[town.end] && dist[town.end] > dist[current] + town.weight) {
                        dist[town.end] = dist[current] + town.weight;
                        pq.add(new Town(town.end, dist[town.end]));
                    }
                }
            }
        }

        return dist;
    }
}
