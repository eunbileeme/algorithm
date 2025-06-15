import java.util.*;

class Solution {
    public String reverseVowels(String s) {
        // \U0001f4dd Set .contains() : O(1)
        Set<Character> vowels = Set.of(
            'a', 'e', 'i', 'o', 'u',
            'A', 'E', 'I', 'O', 'U'
        );

        char[] chars = s.toCharArray();
        int left = 0, right = chars.length - 1;

        while (left < right) {
            // 왼쪽 포인터가 모음이 아닌 동안 이동
            while (left < right && !vowels.contains(chars[left])) {
                left++;
            }
            // 오른쪽 포인터가 모음이 아닌 동안 이동
            while (left < right && !vowels.contains(chars[right])) {
                right--;
            }

            // 두 모음 swap
            char temp = chars[left];
            chars[left] = chars[right];
            chars[right] = temp;

            left++;
            right--;
        }

        return String.valueOf(chars);
    }
}