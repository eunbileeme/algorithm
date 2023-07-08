import java.util.*;

class Solution {
    public int solution(int[] number) {
        int count = 0;
        
        // [-2, 3, 0, 2, -5]
        // -2
        for(int i = 0; i < number.length; i++) {
            // 3
            for(int j = i + 1; j < number.length; j++) {
                // 0
                for(int k = j + 1; k < number.length; k++) {
                    // -2 + 3 + 0 == 0?
                    if(number[i] + number[j] + number[k] == 0) {
                        count++;
                    }
                }
            }
        }
        return count;
    }
}