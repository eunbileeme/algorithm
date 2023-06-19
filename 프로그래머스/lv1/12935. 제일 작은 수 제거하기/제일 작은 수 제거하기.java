// Object[]는 정적인 배열이므로 값을 삭제할 수 없음
// 따라서 array -> arrayList -> 삭제 작업 수행

import java.util.*;

class Solution {
    public int[] solution(int[] arr) {
        int[] array = arr;
        // Integer -> int: o,
        // int -> Integer: x
        List<Integer> list = new ArrayList<>();
        // int[] -> ArrayList
        for (Integer num : array) {
            list.add(num);
        }
        
        if (list.size() == 1) {
            list.remove(0);
            list.add(-1);
        }
        else {
            // Collections.min(): ArrayList 최솟값 구하기
            list.remove(Collections.min(list));
        }
        
        // ArrayList -> int[]
        int[] answer = list.stream().mapToInt(i->i).toArray();
        
        return answer;
    }
}