// [0][0](2)   [0][1](4)    [0][2](-1)
// [1][0](-10) [1][1](5)    [1][2](11)
// [2][0](18)  [2][1](-7)   [2][2](6)

// [0][0](2)
// [1][0](4)
// [2][0](-1)

class Solution {
    public int[][] transpose(int[][] matrix) {
        
        // 1. 반환할 2차원 배열
        int row = matrix.length;
        int col = matrix[0].length;
        int[][] reverseMatrix = new int[col][row];

        // 2. 단, 항상 행 != 열이며
        // 순회하고자 하는 2중 for문의 주체는 reverseMatrix.
        // 즉, reverseMatrix의 값을 새로 채워 넣기 위해
        // i = matrix[0].length;
        // 이때, ..
        for (int i = 0; i < col; i ++) {
            for (int j = 0; j < row; j ++) {
                reverseMatrix[i][j] = matrix[j][i];
            }
        }

        return reverseMatrix;
    }
}