class Solution {
    public long[] solution(int x, int n) {
        // answer 배열의 크기를 인덱스 1 이상에 접근할 수 있도록, 아래의 for문과 맞춰 n으로 초기화
        long[] answer = new long[n];
        long y = 0;
        
        for(int i = 0; i < n; i ++) {
            y = y + x;
            // long 타입의 answer 이름을 가진 배열
            answer[i] = y; 
        }
        
        return answer;
    }
}