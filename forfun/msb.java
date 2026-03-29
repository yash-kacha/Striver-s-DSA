package forfun;

import java.util.stream.Collectors;

class msb {

    public static void main(String[] args) {
        int n = 10;

        System.out.println(
                Integer.toBinaryString(n)
                        .chars().map(a -> (char) a == '0' ? '1' : '0')
                        .collect(Collectors.joining()));

        String flipped
                = Integer.toBinaryString(n)
                        .chars()
                        .mapToObj(c -> c == '0' ? "1" : "0")
                        .collect(Collectors.joining());

    }
}
