import java.util.*;

class Solution {
    public String solution(String s) {
        String answer = "";
        
        if (s.length() % 2 == 0) {
            // 자바는 / 진행 시, 소수점까지 반환
            // 따라서 강제 형변환 수행
            int i = s.length() / 2;
            // char 타입은 유니코드 문자를 나타내므로
            // i - 1번째 문자와 i번째 문자의 정수값이 더해짐
            
            // (1) char을 String으로 바꾸기
            // 따라서 s.charAt(i - 1) + s.charAt(i);가 아니라
            answer += String.valueOf(s.charAt(i - 1));
            answer += String.valueOf(s.charAt(i));
        }
        else {
            int i = (int) Math.floor(s.length() / 2);
            // (2) char을 String으로 바꾸기
            answer = "" + s.charAt(i);
        }
        
        return answer;
    }
}