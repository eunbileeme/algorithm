class Solution {
    public int solution(String s) {
        int answer = 1; // 분해할 문자열의 개수
        char x = s.charAt(0); // "banana" -> "b"
        int count = 1; // 첫 문자열의 개수와 다른 문자열의 개수의 차이
        
        for (int i = 1; i < s.length(); i++) {
            if (count == 0) {
                answer++;
                x = s.charAt(i);
            }
            if (x == s.charAt(i)) {
                count++;
            } else {
                count--;
            }
        }
        
        return answer;
    }
}