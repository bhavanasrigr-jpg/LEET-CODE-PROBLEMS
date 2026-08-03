import java.util.*;

class Solution {
    public int[] findEvenNumbers(int[] digits) {

        TreeSet<Integer> set = new TreeSet<>();

        int n = digits.length;

        for (int i = 0; i < n; i++) {
            if (digits[i] == 0)
                continue; // Hundreds place cannot be 0

            for (int j = 0; j < n; j++) {
                if (j == i)
                    continue;

                for (int k = 0; k < n; k++) {
                    if (k == i || k == j)
                        continue;

                    if (digits[k] % 2 != 0)
                        continue; // Last digit must be even

                    int num = digits[i] * 100 + digits[j] * 10 + digits[k];
                    set.add(num);
                }
            }
        }

        int[] result = new int[set.size()];
        int index = 0;

        for (int num : set) {
            result[index++] = num;
        }

        return result;
    }
}
