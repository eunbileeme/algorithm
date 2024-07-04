// 1. 빈칸에 놓는다.
// 2. 첫 번째 플레이어 A는 항상 'X' 문자를 배치하고 두 번째 플레이어 B는 항상 'O' 문자를 배치한다.
// 3. 'X'와 'O' 문자는 항상 빈 사각형에 배치된다. 이때, 채워진 사각형에는 배치되지 않는다.
// 4. 행, 열 또는 대각선을 채우고 있는 같은(비어 있지 않은) 문자가 세 개가 되면 게임이 종료된다.
// - ex. X X X 또는 O O O
// 5. 또는 모든 사각형에 배치되면 종료된다.
// 게임의 승자('A' 또는 'B')를 반환하며, 무승부일 경우 "Dram"를 반환한다.
// 아직 플레이할 움직임이 있으면 "보류 중"을 반환한다. --> moves.length == 9

class Solution {
    public String tictactoe(int[][] moves) {
        // 예외 처리 생략

        // 1. 주어진 입력값에 마킹된 위치 값을 순서대로 X(1), O(0)로 변환한다.
        char[][] marks = new char[3][3];

        // 초기화
        for (int i = 0; i < marks.length; i ++) {
            for (int j = 0; j < marks[0].length; j ++) {
                marks[i][j] = '.';
            }
        }

        for (int i = 0; i < moves.length; i ++) {
            int row = moves[i][0];
            int col = moves[i][1];

            if (i % 2 == 0) marks[row][col] = 'X';
            else marks[row][col] = 'O';
        }

        // 2. 2차원 배열을 순회하면서
        // 2-1. 열 단위로 순회하면서 X가 (연속적으로) 3개가 있는지, O가 3개가 있는지 확인한다.
        for (int i = 0; i < marks.length; i ++) {
            int xCnt = 0;
            int oCnt = 0;

            for (int j = 0; j < marks[0].length; j ++) {
                if (marks[i][j] == 'X') xCnt ++;
                if (marks[i][j] == 'O') oCnt ++;
            }

            if (xCnt == 3) return "A";
            if (oCnt == 3) return "B";
        }

        // 3. 행 단위 순회
        for (int i = 0; i < marks.length; i ++) {
            int xCnt = 0;
            int oCnt = 0;

            for (int j = 0; j < marks[0].length; j ++) {
                if (marks[j][i] == 'X') xCnt ++;
                if (marks[j][i] == 'O') oCnt ++;
            }

            if (xCnt == 3) return "A";
            if (oCnt == 3) return "B";
        }

        // 4. 대각선 순회
        // 4-1. 좌상 -> 우하
        if (marks[0][0] != '.' && marks[0][0] == marks[1][1] && marks[1][1] == marks[2][2]) {
            return marks[0][0] == 'X' ? "A" : "B";
        }
        // 4-2. 좌하 -> 우상
        if (marks[0][2] != '.' && marks[0][2] == marks[1][1] && marks[1][1] == marks[2][0]) {
            return marks[0][2] == 'X' ? "A" : "B";
        }

        // 5. 무승부 또는 보류
        int cnt = 0;
        for (int i = 0; i < marks.length; i ++) {
            for (int j = 0; j < marks[0].length; j ++) {
                if (marks[i][j] == 'X' || marks[i][j] == 'O') cnt ++;
            }
        }

        return (cnt != 9) ? "Pending" : "Draw";
    }
}