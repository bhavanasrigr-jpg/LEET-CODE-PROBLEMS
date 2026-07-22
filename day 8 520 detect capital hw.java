class Solution {
    public boolean detectCapitalUse(String word) {
        int upperCount = 0;
        for (char c : word.toCharArray()) {
            if (Character.isUpperCase(c)) {
                upperCount++;
            }
        }

        // Case 1: All letters are uppercase (e.g., "USA")
        if (upperCount == word.length()) {
            return true;
        }
        // Case 2: No letters are uppercase (e.g., "leetcode")
        if (upperCount == 0) {
            return true;
        }
        // Case 3: Only the first letter is uppercase (e.g., "Google")
        if (upperCount == 1 && Character.isUpperCase(word.charAt(0))) {
            return true;
        }

        return false;
    }
}
