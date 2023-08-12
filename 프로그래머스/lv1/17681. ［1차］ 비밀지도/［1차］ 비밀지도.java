class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        
        for (int i = 0; i < n; i ++) {
            // str1 = "1001"
            String str1 = Integer.toBinaryString(arr1[i]);
            // str2 = "11110"
            String str2 = Integer.toBinaryString(arr2[i]);
            
            // ※ str1의 크기가 n보다 작다면, n 크기의 새로운 문자열을 생성한 후 str1을 넣어 공백 -> 0으로 변경
            // str1 = "1001" < n = 5 -> "%" + 5 + "s", str1 -> " 1001" -> "01001"
            str1 = String.format("%" + n + "s", str1).replace(' ', '0');
            // str2 = "11110" == 5 -> "11110"
            str2 = String.format("%" + n + "s", str2).replace(' ', '0');
            
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < n; j ++) {
                // str1 = "01001", str2 = "11110"
                // str1.charAt(0) = 0 != '1', str2.charAt(0) = 1 == '1'
                // str1.charAt(1) = 1 == '1', str2.charAt(1) = 1 == '1'
                // str1.charAt(2) = 0 != '1', str2.charAt(2) = 1 == '1'
                // str1.charAt(3) = 0 != '1', str2.charAt(3) = 1 == '1'
                // str1.charAt(4) = 1 == '1', str2.charAt(4) = 0 != '1'
                if (str1.charAt(j) == '1' || str2.charAt(j) == '1') {
                    // "#"
                    // "##"
                    // "###"
                    // "####"
                    // "#####"
                    sb.append("#");
                } else {
                    sb.append(" ");
                }
            }
            // answer[0] = "#####"
            answer[i] = sb.toString();
        }
        
        return answer;
    }
}