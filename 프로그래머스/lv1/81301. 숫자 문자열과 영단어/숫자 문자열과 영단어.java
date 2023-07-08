import java.util.*;

class Solution {
    public int solution(String s) {
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        map.put("zero", 0);
        map.put("one", 1);
        map.put("two", 2);
        map.put("three", 3);
        map.put("four", 4);
        map.put("five", 5);
        map.put("six", 6);
        map.put("seven", 7);
        map.put("eight", 8);
        map.put("nine", 9);
        
        char[] word = s.toCharArray();
        String words = "";
        String answer = "";
        for (Character ch : word) {
            if(Character.isDigit(ch)) {
                answer += ch;
            } else {
                words += ch;
                if (map.containsKey(words)) {
                    answer += map.get(words);
                    words = "";
                }
            }
        }
        
        return Integer.parseInt(answer);
    }
}