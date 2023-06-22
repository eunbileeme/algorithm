import java.util.Arrays;
import java.util.Collections;

class Solution {
    public String solution(String s) {
        Character[] arr = s.chars().mapToObj(c -> (char) c).toArray(Character[]::new);
        String answer = "";
        String upper = "";
        
        Arrays.sort(arr, Collections.reverseOrder());
        
        for (int i = 0; i < arr.length; i ++) {
            if (!Character.isUpperCase(arr[i])) {
                answer += arr[i];
            }
            else {
                upper += arr[i];
            }
        }
        
        return answer + upper;
    }
}