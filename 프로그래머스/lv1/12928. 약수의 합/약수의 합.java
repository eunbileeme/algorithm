import java.util.*;

class Solution {
    public static int solution(int n) {
        int answer = 0;
        
        // i가 0일 경우, ArithmeticException 에러가 발생하므로, i는 1부터 시작해야
        for(int i = 1; i <= n; i ++) {
            if (n % i == 0) {
                answer = answer + i;
            }
        }
        return answer;
    }
    
    public static void main(String [] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        System.out.println(solution(n));
    }
}