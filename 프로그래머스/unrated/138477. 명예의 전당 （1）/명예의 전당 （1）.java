// 1. score 배열만큼 반복문을 돌면서, 명예의 전당 점수를 저장할 리스트를 한 개 선언한다.
// 2. 리스트 사이즈가 k보다 작다면, 리스트에 값을 넣고 그 중 최솟값을 answer에 넣는다.
// 3. 리스트 사이즈가 k라면, 최솟값을 가져와서 score보다 크면 최솟값을 삭제하고 리스트에 점수를 넣는다.

import java.util.*;


class Solution {
    public int[] solution(int k, int[] score) {
        int[] answer = new int[score.length];
        ArrayList<Integer> temp = new ArrayList<>();
        
        for (int i = 0; i < score.length; i ++) {
            if (temp.size() < k) {
                temp.add(score[i]);
                Collections.sort(temp);
                answer[i] = temp.get(0);
                continue;
            }
            
            if (temp.size() == k) {
                int minNum = temp.get(0);
                if (minNum < score[i]) {
                    temp.remove(0);
                    temp.add(score[i]);
                    Collections.sort(temp);
                }
                answer[i] = temp.get(0);
            }
        }
        
        return answer;
    }
}
