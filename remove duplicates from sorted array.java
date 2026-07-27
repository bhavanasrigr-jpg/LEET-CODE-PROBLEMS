class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;

        int insertPos = 1; // next position to place a unique element

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) {
                nums[insertPos] = nums[i];
                insertPos++;
            }
        }

        return insertPos; // length of the array with duplicates removed
    }
}
