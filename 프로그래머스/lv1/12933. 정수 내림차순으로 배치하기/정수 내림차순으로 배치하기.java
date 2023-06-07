import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Stream;

class Solution {
    public long solution(long n) {
        Integer[] arr = Stream.of(String.valueOf(n).split(""))
            .map(Integer::valueOf)
            .toArray(Integer[]::new);
        
        Arrays.sort(arr, Collections.reverseOrder());
        
        StringBuilder sb = new StringBuilder();
        for (int num : arr) {
            sb.append(num);
        }
        
        long answer = Long.parseLong(sb.toString());
        return answer;
    }
}