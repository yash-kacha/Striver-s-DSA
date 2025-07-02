package step3.lec1easy;

public class checkSorted {

    public static void main(String[] args) {
        int[] in = new int[] { 1, 2, 3, 4, 5, 7, 6, 7, 8, 8 };
        // int[] in = new int[] { 1, 2, 5, 2, 9, 4, 5, 3, 3, 0, 5 };
        System.out.println(checkSort(in));
    }

    public static boolean checkSort(int[] x) {
        for (int i = 0; i < x.length - 1; i++) {
            if (x[i] > x[i + 1])
                return false;
        }
        return true;
    }

}
