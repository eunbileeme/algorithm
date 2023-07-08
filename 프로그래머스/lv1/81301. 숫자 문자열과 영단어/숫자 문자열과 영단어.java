import java.util.*;

class Solution {
    public int solution(String s) {
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        // HashMap에 초깃값 선언
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
        // "one" -> 1을 위한 변수
        String words = "";
        // "1478" -> 1478을 위한 변수
        String answer = "";
        for (Character ch : word) {
            // Character.isDigit() : 해당 문자가 숫자인지 판별
            if(Character.isDigit(ch)) {
                answer += ch;
            } else {
                words += ch;
                if (map.containsKey(words)) {
                    answer += map.get(words);
                    // 다음 변환을 위한 초기화 수행
                    words = "";
                }
            }
        }
        
        return Integer.parseInt(answer);
    }
}