import java.io.*;

// ※ m의 분해합 = n
// ※ n의 생성자 = m
// 생성자가 더 작은 개념 --> 입력 시 제공되는 (n) : 분해합, 구해야할 출력값 (m) : 생성자
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int result = 0;

        for(int i = 1; i < n; i++) {
            int number = i;
            int sum = 0;	// 각 자릿수 합 변수

            while(number != 0) {
                sum += number % 10;	// 각 자릿수 더하기(+ 일의 자릿수 -> + 십의 자릿수 -> + 백의 자릿수 -> ..)
                number /= 10; // 각 자릿수 제거(- 일의 자릿수 -> - 십의 자릿수 -> - 백의 자릿수 -> ..)
            }

            // i 값과 각 자릿수 누적합이 같을 경우 (= 생성자)
            // ex. 1 + 9 + 8(sum) + 198(i)
            if(sum + i == n) {
                result = i;
                break;
            }
        }

        System.out.println(result);

        br.close();
    }
}