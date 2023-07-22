// 로또와 당첨 번호가 다 다를 경우를 고려해야 함

import java.util.*;

class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int cnt = 0;
        int zerocnt = 0;
        List<Integer> lotto = new ArrayList<>();
        List<Integer> winlotto = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<Integer,Integer>() {{
            put(6, 1);
            put(5, 2);
            put(4, 3);
            put(3, 4);
            put(2, 5);
            put(1, 6);
        }};
        
        for (int i = 0; i < win_nums.length; i ++) {
            lotto.add(lottos[i]);
            winlotto.add(win_nums[i]);
        }
        
        for (int i = 0; i < win_nums.length; i ++) {
            if (lotto.contains(winlotto.get(i))) {
                cnt ++;
            }
            if (lottos[i] == 0) {
                zerocnt ++;
            }
        }
        
        int[] answer = new int[2];
        if (map.containsKey(cnt + zerocnt))
            answer[0] = map.get(cnt + zerocnt);
        else
            answer[0] = 6;
        if (map.containsKey(cnt))
            answer[answer.length - 1] = map.get(cnt);
        else
            answer[answer.length - 1] = 6;
        
        return answer;
    }
}