import java.util.*;

class Solution {
    public int solution(int k, int m, int[] score) {
        int answer = 0;
        Integer[] arr = Arrays.stream(score).boxed().toArray(Integer[]::new);
        
        Arrays.sort(arr, Collections.reverseOrder());
        
        for (int i = 0; i < arr.length; i += m) {
            if (arr.length < i + m) {
                break;
            }
            // int[]가 아닌 Integer[]이어야 함
            Integer[] array = Arrays.copyOfRange(arr, i, Math.min(arr.length, i + m));
            Arrays.sort(array);
            answer += array[0] * m;
        }
        
        return answer;
    }
}