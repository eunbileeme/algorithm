// 핵심 1) "주어진 수가 1인 경우"
// 핵심 2) "작업을 500번 반복할 때까지"
// 위 조건들을 체크할 값을 0으로 초기화한 count 변수 생성이 핵심

class Solution {
    public int solution(long num) {
        int answer = 0;
        
        // 주어진 수가 1이 아닐 때까지 반복
        while(num != 1) {
            if(num % 2 == 0)
                num /= 2;
            else
                num = num * 3 + 1;
            answer++;
            
            if(answer >= 500) {
                answer = -1;
                break;
            }
        }
        
        return answer;
    }
}