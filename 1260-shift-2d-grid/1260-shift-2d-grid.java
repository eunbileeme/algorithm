// 00 01 02
// 10 11 12
// 20 21 22

// 00 01 02 10 11 12 20 21 22

class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        // 1. 출력용
        List<List<Integer>> ans = new ArrayList<>();

        // 2. 2차원 -> 1차원
        int[] arr = new int[grid.length * grid[0].length];
        // 3. arr 배열을 조작할 인덱스
        int idx = 0;

        for (int i = 0; i < grid.length; i ++) {
            for (int j = 0; j < grid[0].length; j ++) {
                arr[idx] = grid[i][j];
                idx ++;
            }
        }

        // 4. k가 length보다 클 수 있으므로
        k = k % arr.length;

        // 5. 투포인터로 1차원 배열의 값 교체
        change(arr, 0, arr.length - 1);
        change(arr, 0, k - 1);
        change(arr, k, arr.length - 1);

        // 6. 리스트에 삽입
        int rows = grid.length;
        int cols = grid[0].length;

        for (int i = 0; i < rows; i ++) {
            List<Integer> row = new ArrayList<>();
            for (int j = 0; j < cols; j++) {
                row.add(arr[i * cols + j]);
            }

            ans.add(row);
        }

        return ans;
    }

    private void change (int[] arr, int start, int end) {
        // 7. start가 end보다 작을 때까지 (true)
        while (start < end) {
            int tmp = arr[start];
            arr[start] = arr[end];
            arr[end] = tmp;

            start ++;
            end --;
        }
    }
}