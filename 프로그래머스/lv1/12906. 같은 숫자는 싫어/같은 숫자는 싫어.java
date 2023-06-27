import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        Stack<Integer> stack = new Stack<>();
        stack.push(arr[0]);
        
        for (int i = 0; i < arr.length; i ++) {
            if (stack.peek() != arr[i]) {
                stack.push(arr[i]);
            }
        }
        
        // Stack → Integer[]
        Integer[] array = stack.toArray(new Integer[0]);
        
        // Integer[] → int[]
        int[] answer = Arrays.stream(array).mapToInt(Integer::intValue).toArray();
        
        return answer;
    }
}