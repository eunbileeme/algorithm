// 1. 로봇은 처음에 북쪽을 향함
// 2. 북쪽 방향은 Y축의 양의 방향입니다.
// 3. 남쪽 방향은 y축의 음의 방향입니다.
// 4. 동쪽 방향은 x축의 양의 방향입니다.
// 5. 서쪽 방향은 x축의 음의 방향입니다.
// 6. 로봇은 세 가지 명령 중 하나를 받을 수 있습니다.
// 7. "G": 1단위로 직진합니다.
// 8. "L": 왼쪽으로 90도 돌립니다(즉, 시계 반대 방향).
// 9. "R": 오른쪽으로 90도 돌립니다(즉, 시계 방향).
// 10. 로봇이 원을 벗어나지 않는 원이 평면에 존재할 경우에만 참을 반환합니다. --> 예제를 통해 이해

// (예제 1)
// 입력 : "GGLLGG"
// 결과 : (0, 0) --> (0, 1) --> (0, 2) --> (0, 1) --> (0, 0) 주기 --> 참
// (예제 2)
// 입력 : "GG"
// 결과 : 북쪽으로만 계속 진행 --> 거짓
// (예제 3)
// 입력 : "GL"
// 결과 : (0, 0) --> (0, 1) --> (-1, 1) --> (-1, 0) --> (0, 0) 주기 --> 참

class Solution {
    public boolean isRobotBounded(String instructions) {
        // 1. 예외
        if (instructions.length() == 0) return false;

        // 2. row, col, direction (flag)
        int row = 0;
        int col = 0;
        String direction = "N";

        // 3. for (int i = 0; i < instructions.length(); i ++)
        for (int i = 0; i < instructions.length(); i ++) {
            char ch = instructions.charAt(i);

            if (ch == 'G') { // 좌표 이동 과정
                if (direction.equals("N")) col += 1; // 누적값으로 진행 --> 이거 체킹
                else if (direction.equals("S")) col -= 1;
                else if (direction.equals("E")) row += 1;
                else row -= 1;
            } else if (ch == 'L') { // 시계 반대 방향 전환
                if (direction.equals("N")) direction = "W";
                else if (direction.equals("W")) direction = "S";
                else if (direction.equals("S")) direction = "E";
                else direction = "N";
            } else if (ch == 'R') { // 시계 방향 전환
                if (direction.equals("N")) direction = "E";
                else if (direction.equals("E")) direction = "S";
                else if (direction.equals("S")) direction = "W";
                else direction = "N";
            }
        }

        if (row == 0 && col == 0) return true;
        if (direction.equals("N")) return false;

        return true;
    }
}

// 오답노트
// 1. dircetion type은 String
// 2. board라는 2차원 배열이 필요 없이, row / col만으로도 값을 누적시켜서 원점인지 아닌지 확인 가능
// 2. direction이 북쪽이 아닌 다른 방향을 향하고 있는 경우를 찾는 것보다, 북쪽인 경우 == false가 더 쉬움
// 3. 그 외의 모든 경우는 true
// 4. instructions.length() == 0이라는 예외 체킹