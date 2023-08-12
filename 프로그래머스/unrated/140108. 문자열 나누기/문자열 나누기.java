class Solution {
    public int solution(String s) {
        int answer = 1;
        int f = 1; // 첫 문자가 나온 횟수
        int l = 0; // 뒤의 문자들이 나온 횟수
        int left = 0; // charAt를 수행할 시작점
        int right = 1; // 비교할 문자의 인덱스
        
        // "banana" -> s.length() : 6
        while (right < s.length()) {
            // f = 1 != l = 0
            // f = 1 == l = 1
            // f = 1 != l = 0
            // f = 1 == l = 1
            if (f == l) {
                // left = 2
                // left = 3
                left = right;
                // right = 3
                // right = 4
                right += 1;
                f = 1;
                l = 0;
                // answer = 2
                // answer = 3
                answer ++;
            } else {
                // "b" != "a"
                // "n" != "a"
                if (s.charAt(left) == s.charAt(right)) {
                    f ++;
                }
                else {
                    // l = 1
                    // l = 1
                    l ++;
                }
                // right = 2
                // right = 4
                right ++;
            }
        }
        
        return answer;
    }
}