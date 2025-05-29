import java.util.*;

// 1. n번째 아이는 one-base (즉, 1부터 카운트)
// 2. n번째 아이가 가진 n번째 캔디 + 엑스트라 캔디
// 3. 2의 값이 현재 n번째 아이들 중 가장 많이 가지고 있다면 true, 아니라면 false

class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int size = candies.length;
        List<Boolean> result = new ArrayList<>();
        List<Integer> candyCounts = new ArrayList<>();
        int maxCandy = Arrays.stream(candies).max().getAsInt();

        for (int i = 0; i < size; i ++) {
            int currentCandyCount = candies[i] + extraCandies;
            candyCounts.add(currentCandyCount);

            if (currentCandyCount >= maxCandy) {
                result.add(true);
                continue;
            }
            result.add(false);
        }

        return result;
    }
}