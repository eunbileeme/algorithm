import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int[] answer = new int[26];

        for (int i = 0; i < answer.length; i ++) {
            answer[i] = -1;
        }

        for (int i = 0; i < str.length(); i ++) {
            if (answer[str.charAt(i) - 'a'] == -1)
                // ※ answer[str.indexOf(str.charAt(i))]를 대입할 시, answer[0]의 값을 대입하게 됨
                answer[str.charAt(i) - 'a'] = str.indexOf(str.charAt(i)); // 혹은 i
        }

        for (int i = 0; i < answer.length; i ++) {
            System.out.print(answer[i] + " ");
        }

        br.close();
    }
}