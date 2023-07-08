import java.util.*;

class Solution {
    public int solution(String t, String p) {
        int count = 0;
        List<String> list = new LinkedList<>();
        
        for (int i = 0; i <= t.length() - p.length(); i ++) {
            list.add(t.substring(i, i + p.length()));
            
            if (Long.parseLong(list.get(i)) <= Long.parseLong(p)) {
                count ++;
            }
        }
        
        return count;
    }
} 