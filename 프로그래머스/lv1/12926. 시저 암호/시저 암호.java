class Solution {
    public String solution(String s, int n) {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            // 문자를 하나씩 가져와서 처리
            char ch = s.charAt(i);

            // 해당 문자가 소문자일 경우
            if (Character.isLowerCase(ch)) {
                // ex. ch = 'z', n = 1
                
                // 1) (ch - 'a' + n) : 문자를 n만큼 이동 -> 25 - 0 = 25 -> 25 + 1 = 26
                // 'z'는 알파벳에서 26번째에 위치
                
                // 2) (ch - 'a' + n) % 26 : 알파벳이 대소문자 합쳐서 26개 = 'z'를 넘어가면 'a'로 돌아오는 것 -> 26 % 26 = 0
                // 즉, 'z' 다음에 오는 문자를 처리하는 로직이며 0번째에 위치한 알파벳은 'a'
                
                // 3) ((ch - 'a' + n) % 26 + 'a') : 'a'를 뺀만큼 더함 -> 0 + 'a의 ASCII 값(97)'
                // 'a'의 ASCII 값에 0을 더함
                // 즉, 암호화된 문자의 알파벳 상의 위치를 실제 문자로 변환하는 과정이며 값은 그대로 'a'의 ASCII 값(97)
                char c = (char) ((ch - 'a' + n) % 26 + 'a');
                result.append(c);
            // 해당 문자가 대문자일 경우
            } else if (Character.isUpperCase(ch)) {
                char c = (char) ((ch - 'A' + n) % 26 + 'A');
                result.append(c);
            // 해당 문자가 공백일 경우
            } else {
                result.append(ch);
            }
        }

        return result.toString();
    }
}