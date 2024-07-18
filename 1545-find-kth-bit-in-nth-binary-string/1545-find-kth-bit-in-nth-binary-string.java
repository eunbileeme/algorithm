// + : 연결 연산
// reverse : 반전된 문자열 x를 반환
// invert(x) : x의 모든 비트를 반전(= 0은 1로 변경, 1은 0으로 변경)
// Sn의 k번째 비트를 반환

class Solution {
    public char findKthBit(int n, int k) {
        // 1. 조작할 문자열 x
        StringBuilder x = new StringBuilder();

        // 2. s1
        String s1 = "0";

        // 3. 초깃값 삽입
        x.append(s1);

        // 3. 문자열 조작
        for (int i = 1; i < n; i++) {
            // 4. 이전 문자열 추출
            StringBuilder tmp1 = new StringBuilder();
            tmp1.append(x);

            // 5. + "1"
            x.append("1");

            // 6. 추출한 이전 문자열의 비트를 반전
            int size = tmp1.length();
            StringBuilder tmp2 = new StringBuilder();

            for (int j = 0; j < size; j++) {
                if (tmp1.charAt(j) == '0') tmp2.append("1");
                else tmp2.append("0");
            }

            // 7. 뒤집어서 더하기
            x.append(tmp2.reverse());
        }

        // 7. 완성된 문자열 Sn
        String sN = x.toString();

        // 8. k번째 문자를 반환
        return sN.charAt(k - 1); // k는 1-based index이므로
    }
}
