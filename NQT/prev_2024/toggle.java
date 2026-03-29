package NQT.prev_2024;

public class toggle {

    public static void main(String[] args) {
        int[] arr = {1, 0, 1, 1, 0, 1, 0, 0, 0, 1};

        System.out.println(solve(arr));
    }

    private static int solve(int[] arr) {
        int step = 0;
        for (int b : arr) {
            if (b == 0 && step % 2 == 0) {
                step++;
            } else if (b == 1 && step % 2 == 1) {
                step++;
            }
        }
        return step;
    }
}
