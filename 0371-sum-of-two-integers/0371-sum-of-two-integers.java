class Solution {
    public int getSum(int a, int b) {
        while(b != 0) {
            // 1. 올림수 역할을 할 carry
            // 이때, 1 == 1일 경우 올림수가 발생하므로 AND 연산
            // ex. carry = 0010 & 0011 = 0010(2)
            int carry = a & b;

            // 2. 나머지 경우는 일반 비트 연산
            // ex. a = 2(0010), b = 3(0011)
            a ^= b;

            // 3. 올림수 처리
            // 이때, 현재 자릿수보다 윗자리수로 1을 올리면서 0을 붙여야하므로 왼쪽 Shift 연산(<<)
            b = carry << 1;
        }

        return a;
    }
}