class Solution {
    public void moveZeroes(int[] nums) {
        int insertPos = 0; // next position to place a non-zero element

        // Step 1: move all non-zero elements to the front
        for (int num : nums) {
            if (num != 0) {
                nums[insertPos++] = num;
            }
        }

        // Step 2: fill the rest with zeroes
        while (insertPos < nums.length) {
            nums[insertPos++] = 0;
        }
    }
}
