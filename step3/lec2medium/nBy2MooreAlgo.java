package step3.lec2medium;

public class nBy2MooreAlgo {
    public static void main(String[] args) {
        int[] in = new int[] { 1, 2, 2 };
        System.out.println(greaterNby2(in));
    }

    public static int greaterNby2(int[] x) {
        int cnt = 0, el = x[0];

        for (int i = 0; i < x.length; i++) {
            if (cnt == 0) {
                el = x[i];
                cnt++;
            } else if (cnt > 0) {
                if (x[i] == el)
                    cnt++;
                else
                    cnt--;
            }
        }

        cnt = 0;
        for (int i : x) {
            if (i == el)
                cnt++;
        }
        if (cnt > x.length / 2)
            return el;
        else
            return -1;
    }
}
