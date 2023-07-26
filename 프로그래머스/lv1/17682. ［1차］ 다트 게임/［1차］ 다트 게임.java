class Solution {
    public int solution(String dartResult) {
        int answer = 0;
        int[] dart = new int[3];

        int n = 0, idx = 0;
        String numstr = "";
        
        for (int i = 0; i < dartResult.length(); i ++){
            char c = dartResult.charAt(i);
            
            // 숫자일 때
            if (c >= '0' && c <= '9'){
                // 10 -> "1" + "0"
                // 즉, 2자리 수 이상의 숫자는 문자열이 껴있지 않으므로 상관 없음
                 numstr += String.valueOf(c);
                
            }
            // 보너스일 때
            else if (c == 'S' || c == 'D' || c == 'T'){
                n = Integer.parseInt(numstr);
               if (c == 'S') {
                   dart[idx ++] = (int) Math.pow(n, 1);
                 }
                else if (c == 'D') {
                    dart[idx ++] = (int) Math.pow(n, 2);
                }
                else {
                    dart[idx ++] = (int) Math.pow(n, 3);
                } 
                numstr = "";
            }
            // 옵션일 때
            else {
                if (c == '*') {
                    dart[idx - 1] *= 2;
                    // *이 포함된 인덱스가 2 또는 3번째 인덱스일 때
                    // 즉, 전 인덱스에 값이 있다면
                    if (idx - 2 >= 0) dart[idx - 2] *= 2; 
                }
                // #일 경우
                else {
                dart[idx - 1] *= (-1);
                }
            }
        }
    
        answer = dart[0] + dart[1] + dart[2];
    
        return answer;
    }
}