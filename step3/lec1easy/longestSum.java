package step3.lec1easy;

public class longestSum {
    public static void main(String[] args) {
        int[] in = new int[] { 1, 1, 1, 0, 0, 1, 1, 2, 2, 3, 4, 5, 5, 8 };
        /*
         * 1 1 2 2 3 4 5 5 8
         * 0 1 2 4 6 9 13 18 23 31
         */
        // System.out.println(Arrays.toString(longest(in ,5)));
        System.out.println(longest(in, 5));
        System.out.println(longer(in, 5));
    }

    public static int longest(int[] x, int k) {
        int sum = x[0];
        int left = 0, right = 0;
        int maxLen = 0;
        int n = x.length;

        while (left < n && right < n) {
            while (sum > k) {
                sum -= x[left++];
            }
            if (sum == k) {
                maxLen = Math.max(right - left + 1, maxLen);
            }

            right++;
            if (right < n) {
                sum += x[right];
            }
        }
        return maxLen;
    }

    public static int longer(int[] y, int k) {
        int[] hash = new int[y.length + 1];
        hash[0] = 0;
        int tempSum = 0;
        for (int i = 1; i <= y.length; i++) {
            tempSum += y[i - 1];
            hash[i] = tempSum;
        }
        int max = -1, cnt = 0;
        for (int i = 1; i < hash.length; i++) {
            for (int j = i - 1 - max; j >= 0; j--) {
                cnt++;
                if (hash[i] - hash[j] == k)
                    max = Math.max(i - j, max);
                else if (hash[i] - hash[j] > k)
                    break;
            }
        }
        System.out.println("cnt : " + cnt);
        return max;
    }

}
