// TODO 1. 채팅방에 들어왔을 경우 -> key(아이디) : value(이름) 저장 -> 출력
// TODO 2. 채팅방을 나갔을 경우 -> 다시 들어올 것이므로 저장 x -> 출력
// TODO 3. 채팅방에서 이름을 변경했을 경우 -> map에 다시 저장 -> 출력 x

import java.util.*;

class Solution {
    public String[] solution(String[] record) {
        Map<String, String> map = new HashMap<>();
        int changeCount = 0;
        
        for (int i = 0; i < record.length; i ++) {
            String[] tmp = record[i].split(" ");
            // 닉네임 변경하는 로직
            if (tmp[0].equals("Leave")) { // (1) 나간 후, 새로운 닉네임으로 다시 들어올 경우이기 때문에 저장 x
                continue;
            } else if (tmp[0].equals("Enter")) {
                map.put(tmp[1], tmp[2]);
            } else { // (2) 닉네임을 변경한다. (이때, 동일한 id를 가지고 있다면 map의 value가 업데이트 될 것)
                map.put(tmp[1], tmp[2]);
                changeCount ++;
            }
        }
        
        String[] answer = new String[record.length - changeCount];
        int answerIdx = 0;
        
        for (int recordIdx = 0; recordIdx < record.length; recordIdx ++) {
            String[] tmp = record[recordIdx].split(" ");
            String name = map.get(tmp[1]);
            
            if (tmp[0].equals("Enter")) {
                // System.out.println("answerIdx 전 : " + answerIdx);
                answer[answerIdx++] = name + "님이 들어왔습니다."; // 후위 연산자인 'answerIdx'는 해당 행의 연산이 모두 끝난 후, 값이 증가
                // System.out.println("answerIdx 후 : " + answerIdx);
            } else if (tmp[0].equals("Leave")) {
                answer[answerIdx++] = name + "님이 나갔습니다.";
            }
        }
        
        return answer;
    }
}