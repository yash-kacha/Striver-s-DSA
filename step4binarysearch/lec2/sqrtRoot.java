package step4binarysearch.lec2;

public class sqrtRoot {
    public static void main(String[] args) {
        int n = 8;

        System.out.println(findSqrt(n));
    }

    public static int findSqrt(int n) {
        int low = 0, high = n;
        int ans = 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (mid * mid == n)
                return mid;

            if (mid * mid > n)
                high = mid - 1;
            else {
                ans = mid;
                low = mid + 1;
            }
        }
        return ans;

    }
}
