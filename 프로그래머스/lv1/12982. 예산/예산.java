import java.util.*;

class Solution {
    public int solution(int[] d, int budget) {
        int sum = 0;
        int count = 0;
        
        // [1,2,3,4,5]
        Arrays.sort(d);
        
        for (int i = 0; i < d.length; i ++) {
            // 0 + 1 <= 9 -> sum = 0 + 1 = 1, count = 1
            // 1 + 2 <= 9 -> sum = 1 + 2 = 3, count = 2
            // 3 + 3 <= 9 -> sum = 3 + 3 = 6, count = 3
            // 6 + 4 <= 10
            if (sum + d[i] <= budget) {
                sum += d[i];
                count ++;
            }
        }
        
        return count;
    }
}