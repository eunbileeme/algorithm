import java.io.*;

public class Main {
    // TODO 셀프 넘버가 아닌 수 : "양의 정수 n에 대해서 d(n) = n + n의 자릿수1 + n의 자릿수2 + .."
    // ex. 39 = 33 + 3 + 3 -> 33 (n) + 33 / 10 + 33 % 10
    // ex. 101 = 100 + 0 + 0 + 1 / 101 = 91 + 9 + 1
    // TODO "셀프 넘버" 구하기
    // ex. 1 + (1 / 10) + (1 % 10) = 2
    // ex. 2 + (2 / 10) + (2 % 10) = 4
    public static void main(String[] args) throws IOException {
        int n = 1;
        boolean[] selfNumbers = new boolean[10001];
        StringBuilder sb = new StringBuilder();

//        while (n <= 10000) {
//            int selfNumber = n + (n / 10) + (n % 10);
//
//            selfNumbers[selfNumber] = true;
//            n = selfNumber;
//        }

        // TODO (1) 모든 수에 대해서 셀프 넘버인지 아닌지를 판별해야 함.
        // TODO 즉, 셀프 넘버로 확인된 수에 대해서만 셀프 넘버 확인을 진행하면 안됨
        for (int i = 1; i < 10001; i++) {
            int selfNumber = check(i);

            // TODO (2, 중요) selfNumber가 10000보다 작을 때에만 배열을 true로 업데이트 해야함
            // TODO 그렇지 않으면, 10000을 넘긴 selfNumber를 인덱스로 기록하려고 했을 때..
            // TODO 해당 수는 10000의 크기를 가진 배열의 범위를 넘어버리므로 "인덱스 범위 오류"가 터짐
            if (selfNumber <= 10000) {
                selfNumbers[selfNumber] = true;
            }
        }

        for (int i = 1; i < selfNumbers.length; i++) {
            if (!selfNumbers[i]) {
                sb.append(i).append("\n");
            }
        }

        System.out.println(sb);
    }

    // ex. 1100 = 1100 + 1 + 1 + 0 + 0 = 1102
    // ex. 1100 = 1100 + 110 + 0 = 1210
    private static int check(int number) {
        int sum = number; // ex. sum = 111 = number

        // TODO ex.
        while (number != 0) {
            // 111 % 10 = 1
            // 11 % 10 = 1
            sum += number % 10;
            // 111 / 10 = 11
            number /= 10;
        }
        return sum;
    }
}
