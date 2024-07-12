// 여러 아이가 가장 많은 사탕을 가질 수 있다는 점에 유의하세요.
// 각 어린이에 대해 캔디[i] + 추가 캔디가 캔디[i]의 최대값을 초과하는지 확인

class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        // 1. boolean 결과용 배열
        List<Boolean> ans = new ArrayList<>();

        // 2. if (candies[i] + extraCandies >= Maximum in Candies[i])
        int maxCandy = candies[0];
        for (int i = 0; i < candies.length; i ++) {
            maxCandy = Math.max(maxCandy, candies[i]);
            candies[i] += extraCandies;
        }

        // 3.
        for (int i = 0; i < candies.length; i ++) {
            if (candies[i] >= maxCandy) ans.add(true);
            else ans.add(false);
        }

        return ans;
    }
}
