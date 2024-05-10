import java.util.*;

class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        // 0. 출력용 변수
        List<Integer> answer = new ArrayList<>();

        // 1. 순회용 행 / 열 정의
        // [matirx.length][matrix[0].length]
        int row = 0;
        int col = 0;
        
        // 2. 방문을 위한 boolean 2차원 배열 정의
        boolean[][] visited = new boolean[matrix.length][matrix[0].length];
        // 2-1. 첫 번째 방문 초기화
        answer.add(matrix[0][0]);
        visited[0][0] = true;
        
        // TODO 순회를 위한 카운트용 변수 정의
        int iteration = matrix.length * matrix[0].length;
        
        // 3. 순회, 이때 if() 탈출 조건은 "total -- > 0"로 대체
        while(iteration -- > 0) {
            // 3-1. 왼 -> 오
            // ex. [0][0] [0][1]
            while(col + 1 < matrix[0].length && !visited[row][col + 1]) {
                // 3-2. 열 한 칸 이동
                col ++;
                // 3-3. 출력용 변수에 추가
                answer.add(matrix[row][col]);
                // 3-4. 방문 처리
                visited[row][col] = true;
            }

            // 4-1. 위 -> 아래
            while(row + 1 < matrix.length && !visited[row + 1][col]) {
                // 4-2. 행 한 칸 이동
                row ++;
                // 4-3. 출력용 변수에 추가
                answer.add(matrix[row][col]);
                // 4-4. 방문 처리
                visited[row][col] = true;
            }

            // 5-1. 오 -> 왼, 이때 [0]까지 도달해야하므로 >= 0
            while(col - 1 >= 0 && !visited[row][col - 1]) {
                // 5-2. 열 한 칸 이동
                col --;
                // 5-3. 출력용 변수에 추가
                answer.add(matrix[row][col]);
                // 5-4. 방문 처리
                visited[row][col] = true;
            }

            // 6-1. 아래 -> 위
            while(row - 1 >= 0 && !visited[row - 1][col]) {
                // 6-2. 행 한 칸 이동
                row --;
                // 6-3. 출력용 변수에 추가
                answer.add(matrix[row][col]);
                // 6-4. 방문 처리
                visited[row][col] = true;
            }
        }

        return answer;
    }
}