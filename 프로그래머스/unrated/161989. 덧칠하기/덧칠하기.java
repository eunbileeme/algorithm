// 페인트를 칠하기로 정한 구역 사이에 페인트를 칠하지 않아도 되는 구역이 존재하는 경우를 고려
// 즉, 페인트를 칠해야 하는 구역을 그룹화

import java.util.*;

class Solution {
    public int solution(int n, int m, int[] section) {
        int answer = 0;
        int i = 0;
        
        while (i < section.length) {
            int end = section[i] + m - 1;
            
            while (i < section.length && section[i] <= end)
                i++;
            
            answer++;
        }
        
        return answer;
    }
}
