class Solution {
    public int divide(int dividend, int divisor) {
        // Edge case: overflow when dividing MIN_VALUE by -1
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }

        // Determine sign of result
        boolean negative = (dividend < 0) ^ (divisor < 0);

        // Use long to safely handle Math.abs(Integer.MIN_VALUE)
        long dvd = Math.abs((long) dividend);
        long dvs = Math.abs((long) divisor);

        long result = 0;

        while (dvd >= dvs) {
            long temp = dvs;
            long multiple = 1;

            // Double the divisor until it's just under or equal to dvd
            while (dvd >= (temp << 1)) {
                temp <<= 1;
                multiple <<= 1;
            }

            dvd -= temp;
            result += multiple;
        }

        return negative ? (int) -result : (int) result;
    }
}
