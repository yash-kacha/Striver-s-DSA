package step4binarysearch.lec3;

public class rowWithHighest1 {

    public static void main(String[] args) {
        // int[][] in = new int[][]{{1, 1, 1}, {0, 0, 1}, {0, 0, 0}};
        int[][] in = new int[][]{{0, 0}, {0, 0}};
        System.out.println(find(in));
    }

    private static int find(int[][] in) {
        int inx = -1;
        int max = 0;
        for (int i = 0; i < in.length; i++) {
            int cnt = getNum1(in[i]);
            if (cnt > max) {
                inx = i;
                max = cnt;
            }
        }
        return inx;
    }

    private static int getNum1(int[] in) {

        int low = 0, high = in.length;

        while (low < high) {
            int mid = low + (high - low) / 2;
            if (in[mid] == 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return in.length - high;
    }
}
