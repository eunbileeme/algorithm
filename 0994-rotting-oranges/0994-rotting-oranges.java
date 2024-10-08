import java.util.LinkedList;
import java.util.Queue;

class Solution {
    // BFS를 위한 4방향 탐색
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    public int orangesRotting(int[][] grid) {
        // 방문 배열
        boolean[][] visited = new boolean[grid.length][grid[0].length];

        // BFS 수행하여 모든 신선한 오렌지를 부패시킴
        int time = bfs(grid, visited);

        // grid를 전체 순회하여 신선한 오렌지가 남아 있는지 확인
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    // 신선한 오렌지가 남아 있으면 -1 반환
                    return -1;
                }
            }
        }

        return time;
    }

    private int bfs(int[][] grid, boolean[][] visited) {
        // 큐를 사용하여 썩은 오렌지의 위치를 저장
        Queue<int[]> queue = new LinkedList<>();
        // 신선한 오렌지 개수 추적
        int freshCount = 0;

        // 초기 썩은 오렌지를 큐에 추가하고 방문 처리
        // 또는 신선한 오렌지 개수 카운트
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 2) {
                    queue.add(new int[]{i, j});
                    visited[i][j] = true;
                } else if (grid[i][j] == 1) {
                     // 신선한 오렌지 개수 증가
                    freshCount++;
                }
            }
        }

        int time = 0;

        // 큐에 처리할 노드가 남아있지 않을 때까지
        while (!queue.isEmpty() && freshCount > 0) {
            int size = queue.size();

            // 현재 레벨의 모든 노드를 탐색
            for (int i = 0; i < size; i++) {
                int[] current = queue.poll();
                int row = current[0];
                int col = current[1];

                // 현재 좌표를 기준으로 4방향 탐색
                for (int j = 0; j < 4; j++) {
                    int nx = row + dx[j];
                    int ny = col + dy[j];

                    // 유효한 좌표 내에 있고, 신선한 오렌지일 때 부패 처리
                    if (nx >= 0 && nx < grid.length && ny >= 0 && ny < grid[0].length && grid[nx][ny] == 1 && !visited[nx][ny]) {
                        // 다음에 탐색할 노드로 큐에 저장
                        queue.add(new int[]{nx, ny});
                        // 다음 좌표에 대한 방문 처리
                        visited[nx][ny] = true;
                        // 다음 좌표에 대한 부패 처리
                        grid[nx][ny] = 2;
                        // 신선한 오렌지 개수 감소
                        freshCount--;
                    }
                }
            }

            time++;
        }

        return time;
    }
}