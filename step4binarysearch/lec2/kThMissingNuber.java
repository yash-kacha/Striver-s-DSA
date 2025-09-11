package step4binarysearch.lec2;

public class kThMissingNuber {
    public static void main(String[] args) {
        int[] in = { 1, 2, 3, 11, 12 };
        // 0 0 0 7
        int k = 1;

        System.out.println(kTh(in, k));
    }

    public static int kTh(int[] in, int k) {
        int low = 0, high = in.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if ((in[mid] - mid - 1) < k) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }

        }

        return k + high + 1;
    }

}
