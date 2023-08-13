import java.util.Map;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Arrays;

// ※ 한 사람이 동일한 사람을 여러 번 신고했는지를 어떻게 판단하지? --> HashMap<key, <HashSet>> (map)
// ※ 신고를 당한 사람이 id_list에 몇 번째 있는지 + 신고를 한 사람이 id_list에 몇 번째 있는지를 찾는거를 동시에 어떻게 하지? --> HashMap (idx)

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        Map<String, HashSet<String>> map = new HashMap<>(); // key : 유저, value : 해당 유저를 신고한 유저들의 목록
        Map<String, Integer> idxMap = new HashMap<>(); // 유저 이름과 인덱스 저장
        
        for (int i = 0; i < id_list.length; i ++) {
            String name = id_list[i];
            map.put(name, new HashSet<>()); // HashSet : 신고한 유저들의 정보를 저장
            idxMap.put(name, i);
        }
        
        for (String s : report) {
            String[] str = s.split(" ");
            String from = str[0]; // 신고 유저
            String to = str[1]; // 신고 당한 유저
            // map.get(to) : to를 신고한 유저들의 이름이 저장된 HashSet 반환
            // .add(from) : HashSet에 from을 추가
            map.get(to).add(from);
        }
        
        for (int i = 0; i < id_list.length; i ++) {
            HashSet<String> send = map.get(id_list[i]); // 각 유저에 대해 신고한 유저들을 확인
            if (send.size() >= k) { // 특정 유저가 k번 이상 신고당했다면(= 신고 횟수가 k번 이상이라면)
                for (String name : send) { // 그 유저를 신고한 모든 유저들에게 알림을 보내야하므로
                    answer[idxMap.get(name)] ++; // 신고 유저들의 answer 값 증가
                }
            }
        }
        
        return answer;
    }
}