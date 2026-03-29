package NQT.prev_2024;

public class printePrime {

    public static void main(String[] args) {
        int n = 20;
        pp(n);
    }

    private static void pp(int n) {
        // TODO Auto-generated method stub

        boolean seive[] = new boolean[n + 1];

        int i = 2;
        while (i * i <= n) {
            if (!seive[i]) {
                for (int j = i * i; j <= n; j += i) {
                    seive[j] = true;
                }
            }
            i++;
        }

        for (int ii = 2; ii <= n; ii++) {
            if (!seive[ii]) {
                System.out.print(ii + " ");
            }
        }
    }
}
