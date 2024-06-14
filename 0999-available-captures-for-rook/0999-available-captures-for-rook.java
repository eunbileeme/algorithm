// 8 x 8 보드
// 'R' : 하나의 루크, 'B' : 여러 개의 비숍, 'P' : 여러 개의 폰, '.' : 비어있는 공간
// 보드의 끝에 다다르거나 / 폰을 잡거나 / 비숍에 막히면 --> 멈춤 
// 루크가 공격 가능한 폰의 수를 리턴

class Solution {
    public int numRookCaptures(char[][] board) {
        // 1. 출력용
        int cnt = 0;

        // 2. 루크의 위치 따오기
        int rookRow = 0, rookCol = 0;
        for (int i = 0; i < board.length; i ++) {
            for (int j = 0; j < board[0].length; j ++) {
                if (board[i][j] == 'R') {
                    rookRow = i;
                    rookCol = j;
                    break;
                }
            }
        }

        // 3. 순회하면서, 폰 카운트하기 (이때, 당연히 루크의 위치에서부터 탐색 시작)
        // 3-1. 동쪽 탐색
        // 이때, 루크의 해당 행은 고정된 채 열만 증가하며 이동
        // (1) 반복문을 통해 탐색할 때, 끝에 다다르면 탈출
        for (int i = rookCol; i < 8; i ++) {
            // (2) 비숍이라면 탈출
            if (board[rookRow][i] == 'B') {
                break;
            } else if (board[rookRow][i] == 'p') {
                cnt ++;
                break;
            }
        }

        // 3-2. 서쪽 탐색
        // 이때, 루크의 해당 행은 고정된 채 열만 감소하며 이동
        for (int i = rookCol; i >= 0; i --) {
            if (board[rookRow][i] == 'B') {
                break;
            } else if (board[rookRow][i] == 'p') {
                cnt ++;
                break;
            }
        }

        // 3-3. 남쪽 탐색
        // 이때, 루크의 해당 열은 고정된채 행만 증가하며 이동
        for (int i = rookRow; i < 8; i ++) {
            if (board[i][rookCol] == 'B') {
                break;
            } else if (board[i][rookCol] == 'p') {
                cnt ++;
                break;
            }
        }

        // 3-4. 북쪽 탐색
        // 이때, 루크의 해당 열은 고정된 채 행만 감소하며 이동
        for (int i = rookRow; i >= 0; i --) {
            if (board[i][rookCol] == 'B') {
                break;
            } else if (board[i][rookCol] == 'p') {
                cnt ++;
                break;
            }
        }
        
        return cnt;
    }
}