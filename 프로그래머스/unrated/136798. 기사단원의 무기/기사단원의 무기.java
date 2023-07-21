class Solution {
    public int solution(int number, int limit, int power) {
        int sum = 0;
        
        for (int i = 1; i <= number; i ++) {
            int cnt = 0;
            for (int j = 1; j * j <= i; j ++) {
                if (i % j == 0) {
                    cnt ++;
                    if (i / j != j)
                        cnt ++;
                }
            }
            sum += (cnt > limit) ? power : cnt;
        }
        
        return sum;
    }
}