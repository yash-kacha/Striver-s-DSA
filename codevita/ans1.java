package codevita;

import java.util.*;

public class ans1 {
    public static void main(String[] args) {

        List<String> potion = new ArrayList<>();
        List<List<String>> ingredient = new ArrayList<>();

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        sc.nextLine(); // consume newline

        for (int i = 0; i < n; i++) {

            String line = sc.nextLine().trim();
            String[] parts = line.split("=", 2);
            String potions = parts[0].trim();

            String[] ingArr = parts[1].trim().split("\\+");
            List<String> ingList = new ArrayList<>();
            for (String ing : ingArr) {
                ingList.add(ing.trim());
            }

            potion.add(potions);
            ingredient.add(ingList);
        }

        String target = sc.nextLine().trim();
        sc.close();

    }

}
