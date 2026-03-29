package codevita;

import java.util.*;

public class ans2 {
    public static void main(String[] args) {
        Map<List<Integer>, List<Integer>> linesKey;
        Map<List<Integer>, List<Integer>> linesInv;
        Set<List<Integer>> visited;
        try (Scanner sc = new Scanner(System.in)) {
            int n = sc.nextInt();
            linesKey = new HashMap<>();
            linesInv = new HashMap<>();
            visited = new HashSet<>();
            for (int i = 0; i < n; i++) {
                List<Integer> temp1 = Arrays.asList(sc.nextInt(), sc.nextInt());
                List<Integer> temp2 = Arrays.asList(sc.nextInt(), sc.nextInt());

                if (linesKey.containsKey(temp1)) {
                    linesKey.put(temp2, temp1);
                    linesInv.put(temp1, temp2);
                } else {
                    linesKey.put(temp1, temp2);
                    linesInv.put(temp2, temp1);
                }
            }
        }

        int ans = 0;

        for (Map.Entry<List<Integer>, List<Integer>> e : linesKey.entrySet()) {

            List<Integer> mainStarter = e.getKey();
            if (visited.contains(mainStarter))
                continue;

            List<Integer> starter = mainStarter;

            int cntTemp = 0;
            while (linesKey.containsKey(starter) || linesInv.containsKey(starter)) {

                if (visited.contains(starter))
                    break;
                visited.add(starter);

                if (linesKey.containsKey(starter)) {
                    starter = linesKey.get(starter);

                } else {
                    starter = linesInv.get(starter);
                }
                cntTemp++;

            }
            if (starter.equals(mainStarter) && cntTemp >= 3)
                ans++;
        }

        System.out.println(ans);

    }

}
