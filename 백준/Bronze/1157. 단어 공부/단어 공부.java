import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine().toUpperCase();
        int count[] = new int[26];

        for (int i = 0; i < str.length(); i ++) {
            // ※ 문자열에서 문자를 하나씩 가져온 후, - 'A'를 통해 'A'로부터 차이나는 값을 인덱스로 설정
            int num = str.charAt(i) - 'A';
            count[num] ++;
        }

        int max = - 1;
        char answer = '?';
        for (int i = 0; i < count.length; i ++) {
            // ※ 배열을 순회하면서 각 알파벳의 빈도수를 비교 후, 가장 큰 빈도수를 max에 저장
            if (max < count[i]) {
                max = count[i];
                // ※ 각 알파벳이 'A'로부터 차이나는 값이 인덱스(i)이므로, 알파벳을 출력하기 위해서는 i + 'A'를 수행
                // ※ 해당 알파벳을 문자로 출력하기 위해 int + char -> int -> char
                answer = (char) (i + 'A');
            } else if (max == count[i]) {
                answer = '?';
            }
        }

        System.out.println(answer);
        br.close();
    }
}