class Solution {
    public String reverseWords(String s) {
        // 1. 문자열 조작을 위한 StringBuilder
        StringBuilder sb = new StringBuilder();

        // 2. 공백을 기준으로 분리
        String[] str = s.split(" ");

        // 3. 문자열 배열을 거꾸로 순회하면서
        for (int i = str.length - 1; i >= 0; i --) {
            if (str[i].equals("")) {
                continue;
            } else {
                sb.append(str[i]).append(" ");
            }
        }

        return sb.toString().trim();
    }
}
