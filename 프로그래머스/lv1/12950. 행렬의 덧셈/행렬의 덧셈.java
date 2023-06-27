class Solution {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        // arr1.length : 행의 수, arr1[0].length : 열의 수(= 첫 번째 행의 열의 수)
        int[][] answer = new int[arr1.length][arr1[0].length];
        
        // 2차원 배열 덧셈
        for (int i = 0; i < answer.length; i ++) {
            for (int j = 0; j < answer[0].length; j ++) {
                // answer[0][0] = arr1[0][0] + arr2[0][0] → 1 + 3 = 4
                // answer[0][1] = arr1[0][1] + arr2[0][1] → 2 + 4 = 6
                // asnwer[1][0] = arr1[1][0] + arr2[1][0] → 2 + 5 = 7
                // answer[1][1] = arr1[1][1] + arr2[1][1] → 3 + 6 = 9
                answer[i][j] = arr1[i][j] + arr2[i][j];
            }
        }
        
        return answer;
    }
}