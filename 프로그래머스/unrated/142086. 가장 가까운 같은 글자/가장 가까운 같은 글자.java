// 가장 최근의 값과 현재 값을 비교해서 차 구하기

import java.util.*;

class Solution {
    public int[] solution(String s) {
        String[] arr = s.split("");
        List<Integer> list = new ArrayList<>();
        Map<String, Integer> lastPositionMap = new HashMap<>();
        
        for (int i = 0; i < arr.length; i ++) {
            if (!lastPositionMap.containsKey(arr[i])) {
                list.add(-1);
            } else {
                list.add(i - lastPositionMap.get(arr[i])); 
            }
            // 각 문자열(arr[i])의 마지막 위치를 현재 위치(i)로 업데이트
            lastPositionMap.put(arr[i], i);
        }
        
        return list.stream().mapToInt(i -> i).toArray();
    }
}