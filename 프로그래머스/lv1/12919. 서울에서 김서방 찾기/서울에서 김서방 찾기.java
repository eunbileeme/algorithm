import java.util.*;

class Solution {
    public String solution(String[] seoul) {
        String answer = "";
        // indexOf() : ArrayList 자료구조에서만 지원
        int index = Arrays.asList(seoul).indexOf("Kim");
        
        for (String str : seoul) {
            if (str.equals("Kim")) {
                answer += "김서방은 " + index + "에 있다";
            }
        }
        
        return answer;
    }
}