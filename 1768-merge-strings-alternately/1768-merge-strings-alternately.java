// 1. 단어1부터 시작하여 문자를 번갈아 가며 추가하여 문자열을 병합합니다.
// 2. 한 문자열이 다른 문자열보다 긴 경우 병합된 문자열의 끝에 추가 문자를 추가합니다.

class Solution {
    public String mergeAlternately(String word1, String word2) {
        // 1. merge할 문자열 보관용 StringBuilder
        StringBuilder sb = new StringBuilder();

        // 2. 문자를 합쳤는지 기록할 boolean 배열
        boolean[] w1 = new boolean[word1.length()];
        boolean[] w2 = new boolean[word2.length()];

        // 3. idx
        int word1Idx = 0;
        int word2Idx = 0;

        // 4. idx가 범위를 초과하지 않을 때까지
        while (word1Idx < word1.length() && word2Idx < word2.length()) {
            sb.append(word1.charAt(word1Idx));
            sb.append(word2.charAt(word2Idx));

            w1[word1Idx] = true;
            w2[word2Idx] = true;

            word1Idx ++;
            word2Idx ++;
        }

        // 5. w1 순회, 이때 false라면 sb에 추가
        for (int i = 0; i < w1.length; i ++) {
            if (!w1[i]) sb.append(word1.charAt(i));
        }

        // 6. w2 순회, 이때 false라면 sb에 추가
        for (int i = 0; i < w2.length; i ++) {
            if (!w2[i]) sb.append(word2.charAt(i));
        }

        return sb.toString();
    }
}