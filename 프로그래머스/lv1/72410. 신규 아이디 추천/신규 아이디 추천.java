class Solution {
    public String solution(String new_id) {
        // 1. 모든 대문자 -> 소문자
        String com_id = new_id.toLowerCase();
        // 2. 소문자, 숫자, -, _, .를 제외한 모든 문자 제거
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < com_id.length(); i ++) {
            if (Character.isLowerCase(com_id.charAt(i)) || Character.isDigit(com_id.charAt(i)) || com_id.charAt(i) == '-' || com_id.charAt(i) == '_' || com_id.charAt(i) == '.')
                sb.append(com_id.charAt(i));
        }
        // ※ 3. 연속된 마침표 -> 하나의 마침표
        int i = 0;
        while (i < sb.length() - 1) {
            if (sb.charAt(i) == '.' && sb.charAt(i + 1) == '.') {
                sb.deleteCharAt(i + 1);
            } else {
                i ++;
            }
        }
        String answer = sb.toString();
        // ※ 4. 마침표가 처음이나 끝에 위치한다면 제거
        if (answer.startsWith("."))
            answer = answer.substring(1);
        if (answer.endsWith("."))
            answer = answer.substring(0, answer.length() - 1);
        // 5. 빈 문자열이라면 "a"를 대입
        if (answer.length() == 0)
            answer += "a";
        // ※ 6. new_id의 길이가 16자 이상이면, 첫 15개의 문자를 제외한 나머지 문자들을 모두 제거
        if (answer.length() >= 16)
            answer = answer.substring(0, 15);
        if (answer.endsWith("."))
            answer = answer.substring(0, answer.length() - 1);
        // ※ 7. 길이가 2자 이하라면, 마지막 문자를 길이가 3이 될 때까지 반복해서 끝에 붙임
        if (answer.length() <= 2) {
            while(answer.length() < 3) {
                answer += answer.charAt(answer.length() - 1);
            }
        }

        return answer;
    }
}