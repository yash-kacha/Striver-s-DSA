package step3.lec1easy;

public class leftRotateArray {
    public static void main(String[] args) {

        int[] in = new int[] { 0, 1, 2, 3, 4, 5, 6, 7 };
        // 6 7 5 4 3 2 1 8 8 7
        // 7 8 8
        leftRotate(in, 3);
        // System.out.println(Arrays.toString(in));
    }

    public static void leftRotate(int[] arr, int k) {
        int point = arr.length - k - 1;

        rev(arr, 0, point);
        rev(arr, point + 1, arr.length - 1);
        rev(arr, 0, arr.length - 1);

    }

    // 0 1 2 3 4
    // 5 6 7
    // 8 9 10 11
    public static void rev(int[] x, int b, int e) {
        int temp;

        // for (int i = b; i <= b + (e - b) / 2; i++) {
        // temp = x[i];
        // x[i] = x[e + b - i];
        // x[e + b - i] = temp;
        // }

        while (b < e) {
            temp = x[b];
            x[b] = x[e];
            x[e] = temp;
            b++;
            e--;
        }

    }
}
