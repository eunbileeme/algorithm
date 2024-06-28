// 첫 번째 사람에게 1개, 두 번째 사람에게 2개, ... n번째 사람에게 n개
// 첫 번째 사람에게 n + 1 사탕을, 두 번째 사람에게 n + 2 사탕을 주는 식으로 마지막 사람에게 2 * n 사탕을 줄 때까지 계속 진행
// 매번 사탕을 하나씩 더 주고, 끝에 도달하면 줄의 시작 부분으로 이동, 마지막 사람이 남은 사탕을 모두 받게 됩니다(반드시 이전 선물보다 하나 더 받을 필요는 없음).
// 사탕의 최종 분포를 나타내는 배열(길이 num_people과 sum candies)을 반환

class Solution {
    public int[] distributeCandies(int candies, int num_people) {
        // 1.
        int[] ans = new int[num_people];

        // 2. 
        int idx = 0;

        // 3.
        while (candies > 0) {
            ans[idx ++ % num_people] += Math.min(idx, candies);
            candies = Math.max(candies - idx, 0);
        }

        return ans;
    }
}