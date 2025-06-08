class Solution {
    public int[] moveZeroes(int[] nums) {
        // exception handling
        if (nums.length == 1) {
            return nums;
        }
        
        int leftIndex = 0;
        int temp = 0;
        for (int rightIndex = 0; rightIndex < nums.length; rightIndex ++) {
            if (nums[rightIndex] != 0) {
                temp = nums[rightIndex];
                nums[rightIndex] = nums[leftIndex];
                nums[leftIndex] = temp;

                leftIndex ++;
                temp = 0;
            }
        }

        return nums;
    }
}