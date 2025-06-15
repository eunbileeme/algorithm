import java.util.*;

class Solution {
    public String gcdOfStrings(String str1, String str2) {
        if (!(str1 + str2).equals(str2 + str1)) {
            return "";
        }

        int gcdLength = gcd(str1.length(), str2.length());
        return str1.substring(0, gcdLength);
    }

    // ex. a = 6, b = 4
    // (1) 4 != 0 --> gcd(4, 6%4) (a = 4, b = 2) 
    // (2) 2 != 0 --> gcd(4, 4%2) (a = 4, b = 0)
    // (3) 0 == 0 --> 4
    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b); // \U0001f4dd
    }
}