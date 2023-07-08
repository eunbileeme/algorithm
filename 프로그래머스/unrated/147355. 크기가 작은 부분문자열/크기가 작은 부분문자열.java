import java.util.*;

class Solution {
    public int solution(String t, String p) {
        int answer = 0;
        List<String> list = new LinkedList<>();
        
        for (int i = 0; i <= t.length() - p.length(); i ++) {
            list.add(t.substring(i, i + p.length()));
        }
        
        for (int i = 0; i < list.size(); i ++) {
            // 문자열(t, p)의 길이가 10,000 -> int의 범위 초과
            // int의 범위를 넘어가면 데이터 값이 변경됨
            // 따라서 long으로 변환 수행
            if (Long.parseLong(list.get(i)) <= Long.parseLong(p)) {
                answer ++;
            }
        }
        
        return answer;
    }
} 