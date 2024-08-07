import java.util.HashSet;
import java.util.Set;

class Solution {
    public int solution(String numbers) {
        int cnt = 0;
        
        // 1. 문자열을 문자 배열로 변환
        char[] nums = numbers.toCharArray();
        
        // 2. 모든 순열을 저장할 Set (check)
        Set<Integer> uniqueNumbers = new HashSet<>();
        
        // 3. 순열 생성 및 소수 판별 (check)
        generatePermutations(nums, "", uniqueNumbers);

        // 4. Set에 있는 숫자들을 소수인지 확인
        for (int number : uniqueNumbers) {
            if (isPrime(number)) {
                cnt ++;
            }
        }

        // 5. Set에 있는 숫자들을 순회하면서, 해당 숫자가 소수라면 answer 증가
        return cnt;
    }

    // 모든 순열을 생성하는 함수
    private void generatePermutations(char[] nums, String current, Set<Integer> uniqueNumbers) {
        if (!current.isEmpty()) {
            int num = Integer.parseInt(current);
            uniqueNumbers.add(num);
        }
        
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == '-') continue; 
            char temp = nums[i];
            nums[i] = '-';
            generatePermutations(nums, current + temp, uniqueNumbers);
            nums[i] = temp;
        }
    }

    // 소수 판별 함수
    private boolean isPrime(int num) {
        if (num <= 1) return false;
        
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) return false;
        }
        
        return true;
    }
}