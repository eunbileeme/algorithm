//package silver.class4;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.ArrayList;
//import java.util.Arrays;
//
//// TODO 모든 정점 -> 모든 정점까지의 최소 비용 -> 플로이드
//// TODO 단, 출발점의 도시번호 -> 도착점의 도시번호인 경우만 카운트 -> ?
//
//// TODO 다익스트라는 아닌데.. 한 노드에서 다른 모든 노드까지의 최단 거리니까.. -> 맞나?
//// TODO 플로이드는 왜 인접 행렬로 구현했을까?
//// TODO 다익스트라나 플로이드나 노드를 얼마나 경유하는지는 상관 없이, 그냥 최소 비용 자체에 집중하는듯

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// TODO 다익스트라를 인접 리스트로만 풀 수 있는 것은 아니다?
class Node implements Comparable<Node> {
    int end;
    int weight;

    Node(int end, int weight) {
        this.end = end;
        this.weight = weight;
    }

    @Override
    public int compareTo(Node o) {
        return weight - o.weight;
    }
}

// TODO 주석 추가 예정
public class Main {
    static int N, M;
    static ArrayList<ArrayList<Node>> a; // 인접리스트.
    static int[] dist; // 시작점에서 각 정점으로 가는 최단거리.
    static boolean[] check; // 방문 확인.

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        a = new ArrayList<>();
        dist = new int[N + 1];
        check = new boolean[N + 1];

        Arrays.fill(dist, Integer.MAX_VALUE);

        for (int i = 0; i <= N; i++) {
            a.add(new ArrayList<>());
        }

        // 단방향 인접 리스트 구현.
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            // start에서 end로 가는 weight (가중치)
            a.get(start).add(new Node(end, weight));
        }

        st = new StringTokenizer(br.readLine());
        int startPos = Integer.parseInt(st.nextToken());
        int endPos = Integer.parseInt(st.nextToken());

        bw.write(dijkstra(startPos, endPos) + "\n");
        // System.out.println(Arrays.toString(dist));
        bw.flush();
        bw.close();
        br.close();
    }

    // 다익스트라 알고리즘
    public static int dijkstra(int start, int end) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        boolean[] check = new boolean[N + 1];
        pq.offer(new Node(start, 0));
        dist[start] = 0;

        while (!pq.isEmpty()) {
            Node curNode = pq.poll();
            int cur = curNode.end;

            if (!check[cur]) {
                check[cur] = true;

                for (Node node : a.get(cur)) {
                    if (!check[node.end] && dist[node.end] > dist[cur] + node.weight) {
                        dist[node.end] = dist[cur] + node.weight;
                        pq.add(new Node(node.end, dist[node.end]));
                    }
                }
            }
        }
        
        return dist[end];
    }
}
