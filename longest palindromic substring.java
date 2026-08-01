class Solution {

    int start = 0;
    int maxLength = 0;

    public String longestPalindrome(String s) {

        if (s == null || s.length() < 2)
            return s;

        for (int i = 0; i < s.length(); i++) {

            expand(s, i, i);       // Odd-length palindrome
            expand(s, i, i + 1);   // Even-length palindrome
        }

        return s.substring(start, start + maxLength);
    }

    private void expand(String s, int left, int right) {

        while (left >= 0 &&
               right < s.length() &&
               s.charAt(left) == s.charAt(right)) {

            left--;
            right++;
        }

        int length = right - left - 1;

        if (length > maxLength) {
            maxLength = length;
            start = left + 1;
        }
    }
}
