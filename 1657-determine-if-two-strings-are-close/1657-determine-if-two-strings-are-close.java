class Solution {
    public boolean closeStrings(String word1, String word2) {
        // 1. 두 문자열을 담을 알파벳 배열
        int[] freq1 = new int[26];
        int[] freq2 = new int[26];

        // 2. word1의 각 문자에 대한 빈도 카운트
        // ex. [2, 3, 1, 0, ... ,0]
        for (char ch : word1.toCharArray()) {
            freq1[ch - 'a'] ++;
        }

        // ex. [1, 2, 3, 0, ... ,0]
        for (char ch : word2.toCharArray()) {
            freq2[ch - 'a'] ++;
        }

        // 3. word1에는 있는 문자지만, word2에는 없는 경우 false
        // operation 1, 2 중 없는 문자를 처리하는 연산은 없기 때문
        for (int i = 0; i < 26; i ++) {
            if ((freq1[i] == 0 && freq2[i] != 0) || (freq1[i] != 0 && freq2[i] == 0)) return false;
        }

        // 4. 정렬
        // [1, 2, 3, 0, ... , 0]
        Arrays.sort(freq1);
        // [1, 2, 3, 0, ... , 0]
        Arrays.sort(freq2);

        // 5. 문자의 빈도수가 동일하다면
        // (1) operation 1을 통해 한 문자와 다른 문자의 자리를 바꿈
        // (2) operation 2를 통해 한 문자를 다른 문자로 전부 바꿀 수 있음
        for (int i = 0; i < 26; i ++) {
            if (freq1[i] != freq2[i]) return false;
        }

        return true;
    }
}
