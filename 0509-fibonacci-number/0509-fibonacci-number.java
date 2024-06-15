// 피보나치 수열 : 0과 1에서 시작하여 각 수열이 앞의 두 수열의 합이 되는 수열로, 일반적으로 F(n)으로 표시
// F(n) = F(n - 2) + F(n - 1)

// (예제 1)
// n = 2
// F(2) = F(1) + F(0) = 1 + 0 = 1

// (예제 2)
// n = 3
// F(3) = F(2) + F(1) = 1 + 1 = 2

// (예제 3)
// n = 4
// F(4) = F(3) + F(2) = 2 + 1 = 3

class Solution {
    public int fib(int n) {
        // 1. 피보나치 수열
        int[] dp = new int[31];

        // 2. F(0) 및 F(1) 선언
        dp[0] = 0;
        dp[1] = 1;

        // 3. 예외
        if (n == 0) return dp[0];
        else if (n == 1) return dp[1];

        // 4. 2부터 30까지 피보나치 수열의 값 계산
        int ans = 0;
        for (int i = 2; i <= dp.length - 1; i ++) {
            dp[i] = dp[i - 2] + dp[i - 1];

            if (i == n) {
                ans = dp[i];
                break;
            }
        }

        return ans;
    }
}