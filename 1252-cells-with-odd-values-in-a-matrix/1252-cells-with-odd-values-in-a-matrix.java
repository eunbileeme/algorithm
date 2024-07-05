class Solution {
    public int oddCells(int m, int n, int[][] indices) {
        // 1. 2차원 배열
        int[][] arr = new int[m][n];

        // 2. indices 순회
        for (int i = 0 ; i < indices.length; i ++) {
            // 원소는 2개로 고정이되, 모든 1차원 집합을 순회해야하므로
            int row = indices[i][0];
            int col = indices[i][1];

            // arr[row][i]의 값을 증가
            for (int j = 0; j < arr[0].length; j ++) {
                arr[row][j] ++;
            }

            // arr[i][col]의 값을 증가
            for (int k = 0; k < arr.length; k ++) {
                arr[k][col] ++;
                System.out.println("k = " + k);
                System.out.println(arr[k][col]);
            }
        }

        // 3. 홀수 찾기
        int cnt = 0;
        for (int i = 0; i < arr.length; i ++) {
            for (int j = 0; j < arr[0].length; j ++) {
                if (arr[i][j] % 2 == 1) cnt ++;
            }
        }

        return cnt;
    }
}