import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public String solution(int[] numbers) {
        // 1. 문자열 조합을 위한 List
        List<String> nums = Arrays.stream(numbers).mapToObj(String::valueOf).collect(Collectors.toList());
        
        // 2. 사전순으로 오름차순 정렬
        // 이때, 사전순은 문자의 유니코드 값으로 대소비교
        // ex. "909" vs "990" --> 두 번째 문자인 '0' vs '9' -> '9'가 더 큼
        Collections.sort(nums, (a, b) -> {
            String order1 = a + b;
            String order2 = b + a;
            
            return order2.compareTo(order1);
        });
        
        // 3. 가장 큰 수를 문자열로
        String ans = String.join("", nums);
        
        // 4. 모든 원소가 0일 경우, "00"이 아닌 "0"으로 반환
        if (ans.startsWith("0")) {
            ans = "0";
        }
        
        return ans;
    }
}