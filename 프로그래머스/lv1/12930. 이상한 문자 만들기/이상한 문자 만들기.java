import java.util.*;

class Solution {
    public String solution(String s) {
        // 공백이 연속으로 2개 이상 있을 경우, 배열의 element로 취급
        // ex. "try  hello world"
        // ["try", "", "hello", "world"]
        String[] arr = s.split(" ", -1);
        
        for (int i = 0; i < arr.length; i ++) {
            // string → char Array
            char[] word = arr[i].toCharArray();
            for (int j = 0; j < word.length; j ++) {
                if(j % 2 == 0) {
                    // Character.toUpperCase(): 대문자로 변환
                    word[j] = Character.toUpperCase(word[j]);
                }
                else {
                    word[j] = Character.toLowerCase(word[j]);
                }
            }
            // char Array → String
            // arr[i] = new String(word);
            arr[i] = String.valueOf(word);
        }
        
        return String.join(" ", arr);
    }                             
}
