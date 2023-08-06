// [0, 1, 3, 4] -> (0,1) / (3,4)
// 가로 - (1) 가장 값이 작은 열, (2) 가장 값이 큰 열
// 세로 - (1) 가장 값이 작은 행, (2) 가장 값이 큰 행
// 예제 1. 가로 -> (1) 1, (2) 4, 세로 -> (1) 0, (2) 3 -> 세로(1), 가로(1), 세로(2), 가로(2)
// 예제 3. 가로 -> (1) 0, (2) 9, 세로 -> (1) 0, (2) 7 -> 세로(1), 가로(1), 세로(2), 가로(2)

class Solution {
    public int[] solution(String[] wallpaper) {
        int minRow, minCol;
        int maxRow, maxCol;
        
        minRow = minCol = Integer.MAX_VALUE;
        maxRow = maxCol = Integer.MIN_VALUE;

        int row = wallpaper.length;
        int col = wallpaper[0].length();

        for (int r = 0; r < row; r++) {
            for (int c = 0; c < col; c++) {
                if (wallpaper[r].charAt(c) == '#') {
                    minRow = Math.min(minRow, r);
                    minCol = Math.min(minCol, c);
                    maxRow = Math.max(maxRow, r);
                    maxCol = Math.max(maxCol, c);
                }
            }
        }

        // max 값에 + 1을 하는 이유는 드래그를 하려면 끝점을 선택해야 함
        return new int[]{minRow, minCol, maxRow + 1, maxCol + 1};
    }
}