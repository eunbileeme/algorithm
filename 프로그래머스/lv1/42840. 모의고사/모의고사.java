// 배열에 끝에 도달한다면, 다시 처음부터 비교하도록
import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        int[] arr1 = {1, 2, 3, 4, 5};
        int[] arr2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] arr3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5, 3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        int a1 = 0;
        int a2 = 0;
        int a3 = 0;
        
        // 모든 수포자에 대해 답을 확인해야 함
        for (int i = 0; i < answers.length; i ++) {
            if (answers[i] == arr1[i % arr1.length])
                a1 ++;
            if (answers[i] == arr2[i % arr2.length])
                a2 ++;
            if (answers[i] == arr3[i % arr3.length])
                a3 ++;
        }
        
        List<Integer> list = new ArrayList<>();
        // 동점이 나타날 경우, 해당하는 모든 수포자를 찾아야 함
        int maxScore = Math.max(Math.max(a1, a2), a3);
        
        if(a1 == maxScore) list.add(1);
        if(a2 == maxScore) list.add(2);
        if(a3 == maxScore) list.add(3);

        Collections.sort(list);
        
        return list.stream().mapToInt(i -> i).toArray();
    }
}