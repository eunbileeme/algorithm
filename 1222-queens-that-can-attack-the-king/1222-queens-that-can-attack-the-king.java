// 여러 개의 검은색 여왕과 한 개의 흰색 왕
// 2차원 배열 : 여왕의 위치, 1차원 배열 : 왕의 위치
// 왕을 공격할 수 있는 검은색 여왕의 위치 반환하기

// 1. 퀸은 8방향으로 이동이 가능하다.
// 2. 이때, 장애물이 없어야 한다.
// 3. 따라서 (0, 1) / (1, 0) / (3, 3) 위치의 퀸만 공격 가능

class Solution {
    public List<List<Integer>> queensAttacktheKing(int[][] queens, int[] king) {
        // 1. 출력용 배열
        List<List<Integer>> ans = new ArrayList<>();

        // 2. 퀸이 위치할 보드
        // 0, 1, 2, 3, 4, 5, 6, 7
        boolean[][] check = new boolean[8][8];

        // 3. 퀸 위치 마킹
        // i = 0, 1, 2, 3, 4, 5, 6, 7
        for (int i = 0; i < queens.length; i ++) {
            int row = queens[i][0];
            int col = queens[i][1];

            check[row][col] = true;
        }

        // 4. 8방향으로 움직일 좌표
        // 동 / 서 / 남 / 북 / 우상 / 우하 / 좌상 / 좌하
        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}, {-1, 1}, {1, 1}, {-1, -1}, {1, -1}};

        // 5. 8방향으로 차례대로 전진
        for (int[] dir : directions) {
            // 6. 킹의 현재 위치
            int row = king[0];
            int col = king[1];

            System.out.println("kingRow = " + row + ", kingCol = " + col);

            // 7. 좌표를 벗어날 때까지
            while (row >= 0 && row < 8 && col >= 0 && col < 8) {
                // 8. 킹의 다음 위치
                row += dir[0];
                col += dir[1];

                System.out.println("nextRow = " + row + ", nextCol = " + col);

                // 9. 킹의 다음 위치가 좌표를 벗어나지 않고
                if (row >= 0 && row < 8 && col >= 0 && col < 8) {
                    // 10. 퀸이 있다면
                    if (check[row][col]) {
                        ans.add(Arrays.asList(row, col));
                        break;
                    }
                } 
            }
        }

        return ans;
    }
}
