package step4binarysearch.lec2;

public class nThRootOfNumber {
    public static void main(String[] args) {

        int n = 1024;

        System.out.println(nthRoot(10, n));
    }

    public static int nthRoot(int root, int n) {

        int low = 1, high = n;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            int compare = fuctPow(mid, root, n);

            if (compare == 0) {
                System.out.println("from first " + mid + "  " + root + "  " + n);
                return mid;
            }

            if (compare == 1) {
                high = mid - 1;

            } else {
                low = mid + 1;
            }
        }

        return -1;
    }

    public static int fuctPow(int mid, int root, int n) {
        int temp = 1;
        for (int i = 1; i <= root; i++) {
            temp *= mid;
            if (temp > n)
                return 1;

        }
        return ((temp == n) ? 0 : 2);
    }
}
