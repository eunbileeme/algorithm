import java.util.*;

class Solution {
    public String solution(int[] food) {
        String answer = "";
        
        for (int i = 1; i < food.length; i ++) {
            // 0 이전까지, result / 2만 반복하기 위해서는 2중 for문으로 순회해야 함
            int repeatTime = food[i] / 2;
            for (int j = 0; j < repeatTime; j ++) {
                // i (int) -> i (String)
                answer += Integer.toString(i);
            }
        }
        
        // 두 참조 변수가 동일한 객체를 가리키지 않도록 각각 StringBuilder 객체 생성
        StringBuilder sb1 = new StringBuilder(answer);
        StringBuilder sb2 = new StringBuilder(sb1.toString());
        
        sb2.reverse();
        sb1.append("0");
        sb1.append(sb2);
        
        return sb1.toString();
    }
}