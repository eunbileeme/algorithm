class Solution {
    public int solution(int left, int right) {
        int answer = 0;
        
        for (int i = left; i >= left && i <= right; i ++) {
            // 다음 수로 넘어가기 전에, 이전 수의 약수의 개수를 센
            // count 변수 초기화
            int count = 0;
            for (int j = 1; j <= i; j ++) {
                if (i % j == 0) {
                    count ++;
                }
                
            }
            
            if (count % 2 == 0) {
                answer += i;
            }
            else {
                answer -= i;
            }
        }
        
        return answer;
    }
}