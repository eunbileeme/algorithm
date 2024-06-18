// (예제 3)
// nums = [2, 1, 5, 0, 4, 6]
// idxs = [0, 1, 2, 3, 4, 5]
// idx = 0;
// for (int i = 1; i < nums.length; i ++) {
//    if (nums[i] > nums[i - 1]) cnt ++;
//    cnt ++;
// }

class Solution {
    public boolean increasingTriplet(int[] nums) {
        // 1. i < j < k && nums[i] < nums[j] < nums[k]
        int i = Integer.MAX_VALUE;
        int j = Integer.MAX_VALUE;

        // 2. k가 가장 최근의 인덱스의 값
        for (int k : nums) {
            if (k <= i) i = k;
            else if (k <= j) j = k;
            else return true;
        }

        return false;
    }
}

// if (a == b && b == c) --> if (a != b || b != c || a != c) ??