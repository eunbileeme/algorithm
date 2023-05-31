class Solution {
    public int solution(int n) {
        int answer = 0;
        
        for (int i = n; i > 0; i --) {
            if (n % i == 1) {
                answer = i;
            }
            else {
                continue;
            }
        }
        return answer;
    }
}