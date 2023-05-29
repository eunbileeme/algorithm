import java.util.*;

public class Solution {
    // 자바에서 메소드의 리턴 타입은 일치해야 한다.
    public static int solution(int n) {
        int answer = 0;
        ArrayList<Integer> arr = new ArrayList<>();
        
        while (n > 0) {
            arr.add(n % 10);
            // n의 값이 바뀌기 전, 나머지 값을 저장해야 한다.
            answer = answer + n % 10;
            n = n / 10;
        }
        return answer;
    }
    
    public static void main(String [] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        
        System.out.println(solution(n));
    }
}