import java.util.HashMap;
import java.util.Map;

class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        Map<Integer, Boolean> map = new HashMap<Integer, Boolean>();
        int zeroCount = 0;

        for(int lotto : lottos) {
            if(lotto == 0) {
                zeroCount++;
                continue;
            }
            map.put(lotto, true); // 0이 아닌 lottos의 element들은 true로 표기
        }


        int sameCount = 0;
        for(int winNum : win_nums) {
            if(map.containsKey(winNum)) sameCount++; // win_nums의 element가 map에 있다면, sameCount ++
        }

        int maxRank = 7 - (sameCount + zeroCount); // 7(등) - (동일한 번호 + 맞을 가능성이 있는 번호)
        int minRank = 7 - sameCount; // 7등 - 동일한 번호
        if(maxRank > 6) maxRank = 6; // 하나도 맞지 않았거나, 하나만 맞았을 경우 -> 6등(그 외)
        if(minRank > 6) minRank = 6;

        return new int[] {maxRank, minRank};
    }
}
