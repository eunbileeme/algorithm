// players : 선수, callings : 추월한 선수
// "kai" -> "mumu", "soe", "kai", "poe", "mine"
// "kai" -> "mumu", "kai", "soe", "poe", "mine"
// "mine" -> "mumu", "kai", "soe", "mine", "poe"
// "mine" -> "mumu", "kai", "mine", "soe", "poe"
// ["mumu", "kai", "mine", "soe", "poe"]
// ※ 원소의 자리를 바꾸는 과정을 최적화해야

import java.util.Map;
import java.util.HashMap;

class Solution {
    public String[] solution(String[] players, String[] callings) {
        Map<String, Integer> map = new HashMap<String, Integer>();
        
        // 현재 player들에 따른 등수 저장
        for (int i = 1; i < players.length; i ++) {
            map.put(players[i], i);
        }
        
        for (String call : callings) {
            // 첫 번째로 호명된 선수
            int rank = map.get(call);
            // 그 선수 앞에 있는 선수
            String prePlayer = players[rank - 1];
            
            // 호명된 선수와 앞에 있는 선수의 등수 바꾸기
            players[rank - 1] = call;
            players[rank] = prePlayer;
            
            // 갱신
            map.put(call, rank - 1);
            map.put(prePlayer, rank);
        }
        
        return players;
    }
}