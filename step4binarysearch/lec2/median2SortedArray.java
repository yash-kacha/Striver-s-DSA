package step4binarysearch.lec2;

public class median2SortedArray {

    public static void main(String[] args) {
        int[] arr1 = {2, 4, 6,};
        int[] arr2 = {1, 3, 5,};
        // 1 2 3 4 5 6 7 8 9 10

        if (arr1.length > arr2.length) {
            System.out.println(findMedianOpt(arr2, arr1));
        } else {
            System.out.println(findMedianOpt(arr1, arr2));
        }

        System.out.println(findMedian(arr1, arr2));

    }

    private static double findMedianOpt(int[] arr1, int[] arr2) {

        int n1 = arr1.length;
        int n2 = arr2.length;
        int n = (n1 + n2) / 2;
        int low = 0, high = n1 - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            int l1 = 0, l2 = 0, r1 = 0, r2 = 0;

            // 2        4 6 7
            // 1 3 5 8  9 10
            r1 = arr1[mid];
            l1 = arr1[mid - 1];
            r2 = arr2[n - mid];
            l2 = arr2[n - mid - 1];
            // l1 = arr1[mid];
            // if (mid < n1 - 1) {
            //     r1 = arr1[mid + 1];
            // }
            // if (mid > 0) {
            //     l2 = arr2[n2 - mid];
            // }
            // if (mid > 1) {
            //     r2 = arr2[(n2 - mid) + 1];
            // }

            // 2        4 6 7
            // 1 3 5 8  9 10
            int check = 0;
            if (l1 > r2 && l2 < r1) {
                check = 1;
            } else if (l1 < r2 && l2 > r1) {
                check = -1;
            }
            System.out.println(mid);
            // System.out.println(check);
            if (check == 0) {
                return ((double) Math.max(l1, l2) + Math.min(r1, r2)) / 2.0;
            } else if (check == -1) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }

    private static double findMedian(int[] arr1, int[] arr2) {

        int n1 = arr1.length, n2 = arr2.length;
        int p1 = 0, p2 = 0;

        int n = n1 + n2;

        int el1 = -1, el2 = -1;

        while (p1 < n1 && p2 < n2) {
            if (arr1[p1] <= arr2[p2]) {
                if (p1 + p2 == n / 2) {
                    el1 = arr1[p1];
                }
                if (p1 + p2 == (n / 2) - 1) {
                    el2 = arr1[p1];
                }
                p1++;
            } else {
                if (p1 + p2 == n / 2) {
                    el1 = arr2[p2];
                }
                if (p1 + p2 == (n / 2) - 1) {
                    el2 = arr2[p2];
                }
                p2++;
            }
        }

        while (p1 < n1 && (el1 == -1 || el2 == -1)) {
            if (p1 + p2 == n / 2) {
                el1 = arr1[p1];
            }
            if (p1 + p2 == (n / 2) - 1) {
                el2 = arr1[p1];
            }
            p1++;
        }

        while (p2 < n2 && (el1 == -1 || el2 == -1)) {
            if (p1 + p2 == n / 2) {
                el1 = arr2[p2];
            }
            if (p1 + p2 == (n / 2) - 1) {
                el2 = arr2[p2];
            }
            p2++;
        }
        System.out.println(el1 + " ::: " + el2);
        if (n % 2 == 0) {
            return ((double) el1 + el2) / 2.0;
        } else {
            return el2;
        }
    }
}
