package NQT.prev_2024;

import java.util.ArrayList;
import java.util.List;

public class tempPair {

    public static void main(String[] args) {
        int n = 5;
        String ss = "3 4,6 7,2 8,2 5,3 5";
        String sss[] = ss.split(",");
        List<node> nd = new ArrayList<>();

        for (String s : sss) {
            int i = Integer.parseInt(s.split(" ")[0]);
            int j = Integer.parseInt(s.split(" ")[1]);
            nd.add(new node(i, j));

        }
        nd.sort((a, b)
                -> {
            if (a.i == b.i) {
                return a.j - b.j;
            }
            return a.i - b.i;
        });
        for (node ndd : nd) {
            System.out.println(ndd.i + " " + ndd.j);
        }
    }
}

class node {

    int i, j;

    node(int i, int j) {
        this.i = i;
        this.j = j;
    }
}
