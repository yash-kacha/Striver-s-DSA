package step3.lec1easy;

public class linearSearch {
    public static void main(String[] args) {

        int[] in = new int[] { 1, 2, 5, 2, 9, 4, 5, 3, 3, 0, 5 };
        System.out.println(max(in, 5));
    }

    public static boolean max(int[] z, int y) {
        for (int i : z) {
            if (i == y)
                return true;
        }
        return false;
    }

}
