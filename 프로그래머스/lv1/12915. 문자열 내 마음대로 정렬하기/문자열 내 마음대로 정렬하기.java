import java.util.*;

class Solution {
    public String[] solution(String[] strings, int n) {
        Arrays.sort(strings);
        // Comparator.comparing(s -> s.charAt(n)) : 문자열 s의 n번째 문자를 기준으로 비교하는 Comparator를 생성
        Arrays.sort(strings, Comparator.comparing(s -> s.charAt(n)));
        return strings;
    }
}
