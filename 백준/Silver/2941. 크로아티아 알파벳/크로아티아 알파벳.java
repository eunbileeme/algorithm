import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// TODO "몇 개의 크로아티아 알파벳"으로 이루어져 있는지 출력

// TODO case 1 : 문자를 순차적으로 검사 -> 크로아티아 알파벳일 경우(단, i < str.length() - 1 또는 i < str.length() - 2, cnt ++ 및 단어 개수만큼 인덱스 건너뛰기)
// TODO case 2 : 크로아티아 알파벳 String 배열 선언 -> 배열을 순회하며 알파벳이 포함되어 있을 경우, replace("0")으로 대치 후 str.length() 출력

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String changedAlphabet = br.readLine();

        // case 2
        // 1. for-each 사용에 따라 배열을 순회할 용도인 idx 생성
        int idx = 0;
        // 2. 크로아티아 알파벳 배열 생성
        String[] alphabets = {"c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="};

        // 3. 알파벳 배열을 순회
        for (String alpha : alphabets) {
            // 4. 크로아티아 알파벳이 있다면
            if (changedAlphabet.contains(alpha)) {
                // 5. 크로아티아 알파벳을 0으로 대체한 후, "입력 문자열에 반영"
                // TODO 입력 문자열에 반영을 안할 경우, 대체한 뒤 값이 휘발됨.
                changedAlphabet = changedAlphabet.replace(alpha, "0");
            }

            // 6. 다음 반복을 위한 idx 증가
            idx++;
        }

        // 7. 크로아티아 알파벳을 "0"으로 치환한 결과가 반영된 문자열의 개수를 출력
        // TODO ex. "c=" -> "0". 즉, 2개 or 3개의 크로아티아 알파벳을 모두 하나의 문자로 치환.
//        for (int i = 0; i < changedAlphabet.length(); i ++) {
//            System.out.println("changedAlphabet = " + changedAlphabet.charAt(i));
//        }

        System.out.println(changedAlphabet.length());
        br.close();
    }
}
