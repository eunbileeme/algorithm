// Object 배열은 동적으로 크기를 변환할 수 없으므로
// ArrayList를 통해 오름차순으로 정렬할 배열의 토대를 생성

import java.util.*;

class Solution {
    public int[] solution(int[] arr, int divisor) {
        ArrayList<Integer> answer = new ArrayList<>();
        
        for (int i = 0; i < arr.length; i ++) {
            if (arr[i] % divisor == 0) {
                answer.add(arr[i]);
            }
        }
        
        Collections.sort(answer);
        
        // _.toArray()는 Object 배열을 반환하므로
        // int 배열로 반환할 수 없음
        // 따라서, 명시적으로 element를 하나씩 언박싱 수행
        if (answer.size() >= 1) {
            int[] asr = new int[answer.size()];
            
            for (int i = 0; i < answer.size(); i ++) {
                asr[i] = answer.get(i);
            }
        return asr;
        }
        else {
            // 특정값을 가지는 배열 반환
            return new int[]{-1};
        }
    }
}