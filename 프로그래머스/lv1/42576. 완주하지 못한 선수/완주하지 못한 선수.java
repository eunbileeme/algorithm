// 1중 loop에서 끝날 수 있으므로
// sort/loop로 해결 가능

import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        
        // ["ana", "mislav", "mislav", "stanko"]
        Arrays.sort(participant);
        // ["ana", "mislav", "stanko"]
        Arrays.sort(completion);
        
        String answer = "";
        
        for (int i = 0; i < completion.length; i ++) {
            // String 값 비교 시, ==가 아닌 equals() 메서드 사용할 것
            if (!participant[i].equals(completion[i])) {
                return participant[i];
            }
        }
        
        // participant의 모든 element를 확인한 후에도 완주하지 못한 선수를 찾지 못한 경우
        // participant의 마지막 element가 완주하지 못한 선수
        return participant[participant.length - 1];
    }
}