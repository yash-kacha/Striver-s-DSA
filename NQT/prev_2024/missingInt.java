package NQT.prev_2024;

public class missingInt {

    public static void main(String[] args) {
        int arr[] = {1, 2, 4};
        System.out.println(missing(arr));
    }

    private static int missing(int[] arr) {
        int n = arr.length;
        int sum = 0;
        for (int i : arr) {
            sum += i;
        }
        int shoud = (n + 1) * (n + 2) / 2;
        return shoud - sum;
    }
}
