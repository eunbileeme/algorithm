class Solution {

    public int solution(int number, int limit, int power) {
        int[] count = new int[number + 1];    
        for (int i = 1; i <= number; i++) {
          // i의 약수가 되기 위해 필요한 j의 범위는 1부터 number / i까지
            for (int j = 1; j <= number / i; j++) {
              // 3 * 1
              // 3 * 2
              // 3 * 3
                count[i * j]++; // i * j = j는 i의 약수
            }
        }
        int answer = 0;
        for (int i = 1; i <= number; i++) {
            if (count[i] > limit) {
                answer += power;
            } else {
                answer += count[i];
            }
        }
        return answer;
    }
}
