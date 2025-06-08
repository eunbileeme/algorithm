class Solution {
    public boolean isSubsequence(String s, String t) {
        int sIndex = 0;
        int tIndex = 0;

        char[] sArr = s.toCharArray();
        char[] tArr = t.toCharArray();

        while (sIndex < sArr.length && tIndex < tArr.length) {
            if (sArr[sIndex] == tArr[tIndex]) {
                sIndex ++;
            }

            tIndex ++;
        }

        return sIndex == sArr.length ? true : false;
    }
}