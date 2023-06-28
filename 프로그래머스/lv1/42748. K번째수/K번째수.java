import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        
        for (int i = 0; i < commands.length; i ++) {
            // Arrays.copyOfRange(array, from, to) : from ~ to -1 "인덱스" 범위의 값을 가져옴
            
            // i = 0, commands[0][0] = 2, commands[0][1] = 5
            // commands[0][0] - 1 = 1, commands[0][1] = 5
            // 1번째부터 4번째까지 --> [1번째 : 5, 2번째 : 2, 3번째 : 6, 4번째: 3]
            // 즉, 문제에서 설명하는 "번째"는 위치를 의미하고 Arrays.copyOfRange()의 "번째"는 인덱스를 의미함
            // 따라서 -1을 수행
           int[] arr = Arrays.copyOfRange(array, commands[i][0] - 1, commands[i][1]);
            Arrays.sort(arr);
            answer[i] = arr[commands[i][2] - 1];
        }
        
        return answer;
    }
}