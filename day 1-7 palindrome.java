class Solution {
    public boolean isPalindrome(int x) {
        // Negative numbers are never palindromes
        // Numbers ending in 0 (except 0 itself) can't be palindromes
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }
        
        int reversedHalf = 0;
        while (x > reversedHalf) {
            reversedHalf = reversedHalf * 10 + x % 10;
            x /= 10;
        }
        
        // For even digit count: x == reversedHalf
        // For odd digit count: x == reversedHalf / 10 (middle digit ignored)
        return x == reversedHalf || x == reversedHalf / 10;
    }
}
