package step3.lec3Hard;

public class nBy3MoorePlus {
    public static void main(String[] args) {
        int[] in = new int[] { 1, 2,1,1,3,4,2 ,2 };
        int[] ans = greaterNby2(in)
        System.out.println(ans.toString());
    }

    public static int greaterNby2(int[] x) {
        int cnt1 = 0, el1 = x[0];
        int cnt2 = 0, el2 = x[0];

        for (int i = 0; i < x.length; i++) {
            if (cnt1 == 0) {
                el1 = x[i];
                cnt1 = 1;

            } else if (cnt2 == 0) {
                el2 = x[i];
                cnt2 = 1;
            } else if (el1 == x[i]) {
                cnt1++;
            } else if (el2 == x[i]) {
                cnt2++;
            } else {
                cnt1--;
                cnt2--;
            }
        }

    }
}
