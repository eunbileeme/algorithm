class Solution {
    public boolean solution(int x) {
        // 주어진 양의 정수 x를 number에 복사
        int number = x;
        int sum = 0;
        
        // number가 0이 아닐 때까지 반복
        while (number != 0) {
            // 위 과정을 반복하여 sum에는 각 자릿수의 합이 저장
            sum += number % 10;
            number /= 10;
        }
        
        // 이때, x를 복사한 number가 아닌 x와 비교함으로써
        // 주어진 양의 정수 x가 각 자릿수의 합으로 나눠지는지 판단
        if (x % sum == 0) {
            return true;
        } return false;
    }
}