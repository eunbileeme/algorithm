class Solution {
    public String decodeString(String s) {
        // char[] c = s.toCharArray();

        // 2. 숫자를 저장할 스택
        Stack<Integer> stack = new Stack<>();
        // 3. 결과값
        Stack<StringBuilder> ans = new Stack<>();
        // 4. 임시 문자 보관소
        StringBuilder sb = new StringBuilder();
        // 5.
        int n = 0;

        // 6. 순회
        for (char c : s.toCharArray()) {
            // 6-1. 숫자라면
            if (Character.isDigit(c)) {
                n = n * 10 + (c - '0'); // 왜 10을 곱해주는걸까?
            } else if (c == '[') {
                stack.push(n);
                n = 0;
                ans.push(sb);
                sb = new StringBuilder();
            } else if (c == ']') {
                int iteration = stack.pop();
                StringBuilder tmp = sb;
                sb = ans.pop();
                while (iteration -- > 0) {
                    sb.append(tmp);
                }
            } else {
                sb.append(c);
            }
        }

        return sb.toString();
    }
}

 // 3. 숫자라면 
// 4. 문자라면
// (1) "["라면 
// (2) 알파벳이라면
// (3) "]"라면