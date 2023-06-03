// int → String → char array → int array
// n의 각 자리 숫자를 하나씩 가져와야 하므로, String array가 아닌 char array로 변환을 수행

import java.util.*;

class Solution {
    public static int[] solution(long n) {
        String str = String.valueOf(n);
        // String → char array
        // "123" → {'1', '2', '3'}
        char[] arr = str.toCharArray();
        int[] answer = new int[arr.length];
        
        // for(initialization, termination, increment)
        // termination : 논리 연산자(&&, ||)를 사용하여 여러 조건을 결합
        for (int i = 0, j = arr.length - 1; i < arr.length && j >= 0; i ++, j --) {
            // arr[j]는 char 타입이므로 Integer.parseInt() 사용 불가
            // 따라서 Character.getNumericValue() 사용
            answer[i] = Character.getNumericValue(arr[j]);
            }
        return answer;
    }
}