class Solution {
    public int solution(int n) { 
        int answer = 0;
        boolean[] prime = new boolean [n + 1];
        for(int i = 2; i <= n; i ++) {
            // 2 ~ n 번째수를 true로 초기화
            prime[i] = true;
        }
        
        // 제곱근 구하기 
        int root = (int) Math.sqrt(n);
        for (int i = 2; i <= root; i ++) {
            // i 번째의 수가 소수일 때
            if (prime[i] == true) {
                //그 배수들을 다 false로 초기화(배수는 소수가 아니기 때문) 
                for (int j = i; i * j <= n; j ++)
                    prime[i * j] = false;
            }
        }
        
        for (int i = 2; i <= n; i ++) {
            if (prime[i] == true)
                answer++;
        }
        
        return answer; 
    }
}