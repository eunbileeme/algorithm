class Solution {
    public int solution(int n) {
        String str = "";
        
        while (n != 0) {
            // n = n / 3을 먼저 수행하면, 주어진 n에 대한 첫 번째 나머지를 저장 못함
            // 진법 계산 중, 마지막 값은 몫
            str += (n % 3);
            n = n / 3;
        }
        
        int answer = 0;
        for (int i = str.length() - 1, j = 0; i >= 0; i --, j ++) {
            answer += Integer.parseInt(Character.toString(str.charAt(i))) * Math.pow(3, j);
        }
        
        return answer;
    }
}