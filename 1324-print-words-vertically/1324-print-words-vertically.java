// 후행 공백은 허용되지 않는다.
// 각 단어는 하나의 열에만 표시되며 한 열에는 하나의 단어만 표시됩니다.

// TO BE OR NOT TO BE
// 3(한 문자의 최대 길이)행 6(음절의 수)열

// CONTEST IS COMING
// "CIC"
// "OSO"
// "N M"
// "T I"
// "E N"
// "S G"
// "T"  <-- 후행 공백은 허용되지 않음
// 3(한 문자의 최대 길이)행 7(음절의 수)열

class Solution {
    public List<String> printVertically(String s) {
        // 1. 음절 단위로 쪼개기
        String[] str = s.split(" ");

        // 2. 한 단어의 최대 길이 구하기
        int cnt = 0;
        for (int i = 0; i < str.length; i ++) {
            cnt = Math.max(cnt, str[i].length());
        }

        // 3. 2차원 문자열 배열
        String[][] str2D = new String[cnt][str.length];

        // 4. 채우기
        // str[0] = "HOW"
        // charAt(0) = "H", charAt(1) = "O", charAt(2) = "W"
        for (int i = 0; i < str2D.length; i ++) {
            for (int j = 0; j < str2D[0].length; j ++) {
                if (j < str.length && i < str[j].length()) {
                    str2D[i][j] = String.valueOf(str[j].charAt(i));
                } else {
                    str2D[i][j] = " ";
                }
            }
        }

        // 5. 리스트로 변환
        List<String> ans = new ArrayList<>();
        for (int i = 0; i < cnt; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < str.length; j++) {
                sb.append(str2D[i][j]);
            }
            // 끝의 공백 제거
            ans.add(sb.toString().stripTrailing());
        }

        return ans;
    }
}