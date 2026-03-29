package NQT.prev_2024;

public class bigSum {

    public static void main(String[] args) {
        int arr1[] = {60, 60, 60};
        int arr2[] = {40, 90, 30};

        System.out.println(findMax(arr1, arr2));

    }

    private static int findMax(int[] arr1, int[] arr2) {
        int pre1 = 0, pre2 = 0;
        for (int i = 0; i < arr1.length; i++) {
            pre1 += arr1[i];
            pre2 += arr2[i];
        }

        int g1 = findGain(arr1, arr2);
        int g2 = findGain(arr2, arr1);

        return Math.max(g2 + pre1, g1 + pre2);
    }

    private static int findGain(int[] arr1, int[] arr2) {
        int curr = 0, max = 0;

        for (int i = 0; i < arr1.length; i++) {
            int diff = arr1[i] - arr2[i];
            curr = Math.max(curr, curr + diff);
            max = Math.max(max, curr);
        }
        return max;
    }

}
