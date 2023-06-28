import java.util.Arrays;
import java.util.Collections;

class Solution {
    public String solution(String s) {
        // 문자(char) 배열로 변환했어도 동작했을까?
        // 1) .chars() : 문자열의 각 문자를 표현하는 unicode 값(정수)을 Stream으로 생성
        // 2) .mapToObj(c -> (char) c) : 각 unicode 값을 char(이때도 Stream)로 변환
        // 3) .toArray(Character[]::new) : 각 char을 Character[] 배열에 담음
        Character[] arr = s.chars().mapToObj(c -> (char) c).toArray(Character[]::new);
        String answer = "";
        
        Arrays.sort(arr, Collections.reverseOrder());
        
        for (int i = 0; i < arr.length; i ++) {
            answer += arr[i];
        }
        
        return answer;
    }
}