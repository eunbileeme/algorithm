import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        // 중복되는 값을 저장하지 않기 위해 HashSet을 사용
        HashSet<Integer> set = new HashSet<>();
        
        // 모든 숫자 쌍을 고려하여 두 숫자의 합을 계산하기 위해 2중 for문 사용
        
        // numbers.length - 1을 통해 i가 마지막 요소를 가리키는 경우를 방지
        // 즉, ArrayIndexOutOfBoundsException을 방지
        for (int i = 0; i < numbers.length - 1; i ++) {
            // j = i + 1, numbers.length를 통해 i의 다음 요소부터 배열의 끝까지 반복
            // 즉, j는 배열의 마지막 요소를 포함
            for (int j = i + 1; j < numbers.length; j ++) {
                set.add(numbers[i] + numbers[j]);
            }
        }
        
        int[] answer = set.stream().mapToInt(Integer::intValue).toArray();
        
        Arrays.sort(answer);
        
        return answer;
    }
}