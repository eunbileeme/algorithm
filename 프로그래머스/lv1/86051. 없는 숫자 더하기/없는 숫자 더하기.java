class Solution {
    public int solution(int[] numbers) {
        int answer = 0;
        boolean[] existNumbers = new boolean[10];
        
        // 배열을 순회하면서 0-9 사이에 있는 숫자들을
        // boolean 배열에 true로 기록
        for (int num : numbers) {
            if (num >= 0 && num <= 9) {
                existNumbers[num] = true;
            }
        }
        
        for (int i =0; i <= 9; i ++) {
            // boolean 배열에 기록되어 있지 않다면
            if (!existNumbers[i]) {
                // 해당 인덱스를 모두 더함
                answer += i;
            }
        }
        
        return answer;
    }
}