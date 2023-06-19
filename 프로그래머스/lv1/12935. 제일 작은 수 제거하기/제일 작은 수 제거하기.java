// ※ Object[]는 정적인 배열이므로 값을 삭제할 수 없음
// 따라서 array -> arrayList -> 삭제 작업 수행

import java.util.*;

class Solution {
    public int[] solution(int[] arr) {
        int[] array = arr;
        List<Integer> list = new ArrayList<>();
        
        for (Integer num : array) {
            list.add(num);
        }
        
        if (list.size() == 1) {
            list.remove(0);
            list.add(-1);
        }
        else {
            list.remove(Collections.min(list));
        }
        
        int[] answer = list.stream().mapToInt(i->i).toArray();
        
        return answer;
    }
}