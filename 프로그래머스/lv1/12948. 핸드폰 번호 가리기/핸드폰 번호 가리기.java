import java.util.*;

class Solution {
    public String solution(String phone_number) {
        char[] arr = phone_number.toCharArray();
        int answer = phone_number.length() - 4;
        
        for (int i = 0; i < answer; i ++) {
            arr[i] = '*';
        }
        return String.valueOf(arr);
    }
}