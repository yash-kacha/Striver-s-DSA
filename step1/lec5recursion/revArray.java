package step1.lec5recursion;

public class revArray {
    public static void main(String[] args) {

        int[] in = new int[] { 1, 2, 3, 4, 5, 6 };

        rev(in, 0);

        for (int i : in) {
            System.out.print(i + " ");
        }
    }

    public static void rev(int[] arr, int i) {
        if (i >= arr.length / 2)
            return;
        int temp = arr[i];
        arr[i] = arr[arr.length - i - 1];
        arr[arr.length - i - 1] = temp;
        rev(arr, ++i);
    }
}
