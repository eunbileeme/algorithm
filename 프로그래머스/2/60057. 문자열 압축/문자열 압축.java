import java.util.*;

// TODO 문자열을 압축 -> 가장 짧은 문자열의 길이 구하기

// TODO Q. 문자열을 n개 단위로 잘라 압축했을 때, 가장 짧은지를 알려면
//  -> 적어도 문자열의 절반 길이 이내로 n, n - 1, .. 개 단위로 잘라 압축해봐야 아는데 이를 어떻게 구현하지?
class Solution { // Q. Solution -> 클래스 이름 자동 완성 단축키가 뭐였지?
    public int solution (String s) {
        int answer = s.length();
        int count = 1;

        for (int i = 1; i <= s.length() / 2; i ++) {
            StringBuilder sb = new StringBuilder();
            String base = s.substring(0, i); // .
            // System.out.println("base = " + base);

            for (int j = i; j <= s.length(); j += i) {
                int endIdx = Math.min(j + i, s.length());
                String compare = s.substring(j, endIdx);
                // System.out.println("compare = " + compare);

                if (base.equals(compare)) {
                    count ++;
                } else {
                    if (count >= 2) {
                        sb.append(count);
                    }

                    sb.append(base);
                    base = compare;
                    count = 1;
                }
            }

            sb.append(base);
            answer = Math.min(answer, sb.length());
        }

        return answer;
    }
}
