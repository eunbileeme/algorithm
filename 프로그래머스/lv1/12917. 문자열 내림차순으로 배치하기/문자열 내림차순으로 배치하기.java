// 문자열을 내림차순에 따라 정렬하면
// 대문자 + 소문자 순으로 정렬됨
// ASCII 기준, 대문자가 소문자보다 값이 작기 때문

import java.util.Arrays;
import java.util.Collections;

class Solution {
    public String solution(String s) {
        // s.chars() = IntStream(primitive Stream) = int
        // 따라서 Character 객체로 만들기 위해 (char) 강제 형변환 수행
        Character[] arr = s.chars().mapToObj(c -> (char) c).toArray(Character[]::new);
        String answer = "";
        String upper = "";

        // <-> StringBuilder.reverse() : 단순히 역순으로 뒤집음
        Arrays.sort(arr, Collections.reverseOrder());
        
        for (int i = 0; i < arr.length; i ++) {
            if (!Character.isUpperCase(arr[i])) {
                answer += arr[i];
            }
            else {
                upper += arr[i];
            }
        }
        
        return answer + upper;
    }
}
