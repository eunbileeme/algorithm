// keymap을 통해 각 문자에 대해 최소한으로 키를 누를 횟수를 정의
// 이후, targets을 기준으로 hm에서 해당하는 문자를 읽어서 값을 반환

import java.util.HashMap;

class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        HashMap<Character, Integer> hm = new HashMap<>();
        int[] ret = new int[targets.length];
        
        // hm : 각 문자에 대해 최소한으로 키를 누를 횟수
        for (String key : keymap) {
            for (int i = 0; i < key.length(); i ++) { // "ABACD"
                char c = key.charAt(i); // "A"
                // i < hm.get(c) -> update
                // ex. "A"의 index가 "A"를 누를 횟수보다 작다면
                // = 기존에 등장한 "A"보다 더 적은 횟수로 "A"를 누를 수 있을 경우
                if (!hm.containsKey(c) || i < hm.get(c)) {
                    hm.put(c, i + 1); // i + 1번씩 키를 누름
                }
            }
        }
        for (int i = 0 ; i < targets.length; i ++) {
            int cnt = 0;
            for (int j = 0; j < targets[i].length(); j ++) {
                char c = targets[i].charAt(j);
                // c가 hm에 없다면
                if(!hm.containsKey(c)) {
                    cnt = 0;
                    break;
                } else {
                    cnt += hm.get(c);
                }
            }
            // -1을 반환
            ret[i] = cnt == 0 ? -1 : cnt;
        }
        
        return ret;
    }
}