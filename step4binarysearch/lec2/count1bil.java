package step4binarysearch.lec2;

public class count1bil {

    public static void main(String[] args) {
        // Record start time
        long startTime = System.currentTimeMillis();
        System.out.println("Program started at: " + startTime + " ms");

        // Your loop
        int temp = 0;
        for (int i = 0; i < 1_000_000_000; i++) {
            temp++;
        }
        System.out.println(temp);

        // Record end time
        long endTime = System.currentTimeMillis();
        System.out.println("Program ended at: " + endTime + " ms");

        // Calculate total time
        long totalTime = endTime - startTime;
        System.out.println("Total time taken: " + totalTime + " ms");
        System.out.println("Which is about: " + (totalTime / 1000.0) + " seconds");
    }
}