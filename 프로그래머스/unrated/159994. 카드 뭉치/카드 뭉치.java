// cards1의 인덱스와 cards2의 인덱스를 유지하면서 goal의 element를 확인해야 함
// 즉, 각 카드 더미의 현재 인덱스를 따로 추적해야 함

class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        int idx1 = 0;
        int idx2 = 0;
        
        for (int i = 0; i < goal.length; i ++) {
            if (idx1 < cards1.length && goal[i].equals(cards1[idx1]))
                idx1 ++;
            else if (idx2 < cards2.length && goal[i].equals(cards2[idx2]))
                idx2 ++;
            else
                return "No";
        }
        
        return "Yes";
    }
}