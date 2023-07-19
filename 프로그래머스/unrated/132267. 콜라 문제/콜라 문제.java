class Solution {
    public int solution(int a, int b, int n) {
        int answer = 0;
        
        while (n >= a) {
            int quot = n / a; // 마트에서 받을 빈 병의 개수
            answer += quot * b;
            int remain = n % a; // 마트에게 주지 못한 빈 병의 개수
            n = (quot * b) + remain; // 콜라를 마신 후 마트에서 얻은 빈 병 * 남은 빈 병
        }
        
        return answer;
    }
}