// String -> char array -> String

import java.util.*;

class Solution {
    public String solution(String phone_number) {
        // .toCharArray() : String -> char array
        char[] arr = phone_number.toCharArray();
        int answer = phone_number.length() - 4;
        
        for (int i = 0; i < answer; i ++) {
            arr[i] = '*';
        }
        // String.valueOf() : element를 합쳐서 String으로 반환
        return String.valueOf(arr);
    }
}