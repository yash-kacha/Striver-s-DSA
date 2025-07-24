package forfun;

import java.lang.classfile.instruction.ArrayStoreInstruction;
import java.util.*;

public class PlayingCard {

    public static boolean trioB = true;
    public static boolean straitFlushB = true;

    public static void main(String[] args) {

        List<String> deck = new ArrayList<>();
        // spades (♠), hearts (♥), diamonds (♦), and clubs (♣)
        char[] suits = { 'S', 'H', 'D', 'C' };
        char[] rank = { '2', '3', '4', '5', '6', '7', '8', '9', '1', 'J', 'Q', 'K', 'A' };

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 13; j++) {
                deck.add("" + rank[j] + suits[i]);
            }
        }

        // List<String> playerName = Arrays.asList(new String[] { "yash", "malay",
        // "mihir" });
        shuffle(deck);

        // System.out.println(deck.toString());

        // for (List<String> s : teen(deck)) {
        // System.out.println(s);
        // }

        List<List<String>> hands = teen(deck);

        rank(hands);
        Collections.reverse(hands);

        int ranking = 1;
        for (List<String> s : hands) {
            System.out.println(ranking++ + " : " + s.toString());
        }

        // findTrio(deck);
        // findStraightFlush(deck);

        // testTrioFrequency(deck, 100000); // Test with 10,000 rounds
        // testRareHandsFrequency(deck, 100000); // Test with 20,000 rounds
    }

    // public static void testStraightFlushFrequency(List<String> deck, int rounds)
    // {
    // int straightFlushCount = 0;
    // int totalHands = 0;

    // for (int round = 0; round < rounds; round++) {
    // shuffle(deck);
    // List<List<String>> hands = teen(deck);

    // for (List<String> hand : hands) {
    // totalHands++;
    // int score = eval(hand);
    // if (score >= 5000 && score < 6000) { // Straight flush range
    // straightFlushCount++;
    // System.out.println("Straight flush found: " + hand + " in round " + round);
    // }
    // }
    // }

    // double percentage = (double) straightFlushCount / totalHands * 100;
    // System.out.println("Straight flushes found: " + straightFlushCount + " out of
    // " + totalHands + " hands");
    // System.out.println("Actual percentage: " + percentage + "%");
    // System.out.println("Expected percentage: ~0.217%");
    // }

    // public static void testTrioFrequency(List<String> deck, int rounds) {
    // int trioCount = 0;
    // int totalHands = 0;

    // for (int round = 0; round < rounds; round++) {
    // shuffle(deck);
    // List<List<String>> hands = teen(deck);

    // for (List<String> hand : hands) {
    // totalHands++;
    // int score = eval(hand);
    // if (score >= 6000) {
    // trioCount++;
    // System.out.println("Trio found: " + hand + " in round " + round);
    // }
    // }
    // }

    // double percentage = (double) trioCount / totalHands * 100;
    // System.out.println("Trios found: " + trioCount + " out of " + totalHands + "
    // hands");
    // System.out.println("Actual percentage: " + percentage + "%");
    // System.out.println("Expected percentage: ~0.235%");
    // }

    public static void testRareHandsFrequency(List<String> deck, int rounds) {
        int trioCount = 0;
        int straightFlushCount = 0;
        int totalHands = 0;

        for (int round = 0; round < rounds; round++) {
            shuffle(deck);
            List<List<String>> hands = teen(deck);

            for (List<String> hand : hands) {
                totalHands++;
                int score = eval(hand);

                if (score >= 6000) { // Trio
                    trioCount++;
                    System.out.println("Trio found: " + hand + " (Round " + round + ")");
                } else if (score >= 5000 && score < 6000) { // Straight flush
                    straightFlushCount++;
                    System.out.println("Straight flush found: " + hand + " (Round " + round + ")");
                }
            }
        }

        double trioPercentage = (double) trioCount / totalHands * 100;
        double sfPercentage = (double) straightFlushCount / totalHands * 100;

        System.out.println("\n=== RESULTS ===");
        System.out.println("Total hands tested: " + totalHands);
        System.out.println("Trios: " + trioCount + " (" + trioPercentage + "%)");
        System.out.println("Straight flushes: " + straightFlushCount + " (" + sfPercentage + "%)");
        System.out.println("Expected trio: ~0.235%");
        System.out.println("Expected straight flush: ~0.217%");
        System.out.println(
                "Trio is " + (trioPercentage > sfPercentage ? "more" : "less") + " common than straight flush");
    }

    public static void findTrio(List<String> deck) {
        int count = 0;

        while (true) {
            shuffle(deck);
            List<List<String>> hands = teen(deck);
            count++;

            for (List<String> hand : hands) {
                int score = eval(hand);
                if (score >= 6000) { // Trio found
                    System.out.println("TRIO FOUND!");
                    System.out.println("Attempts: " + count);
                    System.out.println("Trio Hand: " + hand);
                    System.out.println("Score: " + score);
                    return;
                }
            }

            // Optional: Print progress every 1000 attempts
            if (count % 1000 == 0) {
                System.out.println("Searched " + count + " deals for trio...");
            }
        }
    }

    public static void findStraightFlush(List<String> deck) {
        int count = 0;

        while (true) {
            shuffle(deck);
            List<List<String>> hands = teen(deck);
            count++;

            for (List<String> hand : hands) {
                int score = eval(hand);
                if (score >= 5000 && score < 6000) { // Straight flush found
                    System.out.println("STRAIGHT FLUSH FOUND!");
                    System.out.println("Attempts: " + count);
                    System.out.println("Straight Flush Hand: " + hand);
                    System.out.println("Score: " + score);
                    return;
                }
            }

            // Optional: Print progress every 1000 attempts
            if (count % 1000 == 0) {
                System.out.println("Searched " + count + " deals for straight flush...");
            }
        }
    }

    public static void rank(List<List<String>> hands) {
        Map<List<String>, Integer> temp = new HashMap<>();

        for (List<String> hand : hands) {
            temp.put(hand, eval(hand));
        }

        List<Map.Entry<List<String>, Integer>> list = new ArrayList<>(temp.entrySet());
        list.sort(Map.Entry.comparingByValue());

        // Step 2: Put into LinkedHashMap to preserve order
        Map<List<String>, Integer> sortedMap = new LinkedHashMap<>();
        for (Map.Entry<List<String>, Integer> entry : list) {
            sortedMap.put(entry.getKey(), entry.getValue());
        }

        int po = 0;
        for (Map.Entry<List<String>, Integer> i : sortedMap.entrySet()) {
            hands.set(po, i.getKey());
            po++;
        }
    }

    public static int eval(List<String> hand) {
        int[] ranks = new int[3];
        char[] suits = new char[3];

        for (int i = 0; i < 3; i++) {
            String card = hand.get(i);
            ranks[i] = getCardValue(card.charAt(0));
            suits[i] = card.charAt(1);
        }

        Arrays.sort(ranks);

        if (isTrio(ranks)) {
            return 9000 + ranks[0];
        }

        else if (isStrait(ranks) && isFlush(suits)) {
            if (ranks[2] == 14 && ranks[0] == 2)
                return 8100;
            else
                return 8000 + ranks[2];
        }

        else if (isStrait(ranks)) {
            if (ranks[2] == 14 && ranks[0] == 2)
                return 6100;
            else
                return 6000 + ranks[2];
        }

        else if (isFlush(suits)) {
            return 4000 + ranks[2] * 100 + ranks[1] * 10 + ranks[0];
        }

        else if (isPair(ranks)) {
            int pair = (ranks[0] == ranks[1] ? ranks[0] : ranks[1] == ranks[2] ? ranks[1] : 2);
            int extra = ranks[0] + ranks[1] + ranks[2] - pair * 2;

            return 2000 + pair * 100 + extra * 10;
        }

        return ranks[2] * 100 + ranks[1] * 10 + ranks[0];
    }

    private static boolean isFlush(char[] suits) {
        return suits[0] == suits[1] && suits[1] == suits[2];
    }

    private static boolean isTrio(int[] ranks) {

        return ranks[0] == ranks[1] && ranks[1] == ranks[2];
    }

    private static boolean isStrait(int[] ranks) {
        if (ranks[0] + 1 == ranks[1] && ranks[1] + 1 == ranks[2])
            return true;
        else if (ranks[0] == 2 && ranks[1] == 3 && ranks[2] == 14)
            return true;
        return false;
    }

    private static boolean isPair(int[] ranks) {
        if (ranks[0] == ranks[1] || ranks[1] == ranks[2] || ranks[0] == ranks[2])
            return true;
        return false;
    }

    public static int getCardValue(char card) {
        return switch (card) {
            case '2' -> 2;
            case '3' -> 3;
            case '4' -> 4;
            case '5' -> 5;
            case '6' -> 6;
            case '7' -> 7;
            case '8' -> 8;
            case '9' -> 9;
            case '1' -> 10;
            case 'J' -> 11;
            case 'Q' -> 12;
            case 'K' -> 13;
            case 'A' -> 14;
            default -> 0;
        };
    }

    public static List<List<String>> teen(List<String> deck) {
        List<List<String>> ans = new ArrayList<>();

        int playerCnt = 2;
        for (int i = 0; i < playerCnt; i++) {
            ans.add(new ArrayList<>());
        }

        int index = 0;
        for (int card = 0; card < 3; card++) {
            for (int player = 0; player < playerCnt; player++) {
                ans.get(player).add(deck.get(index++));
            }
        }
        return ans;
    }

    public static void shuffle(List<String> deck) {

        Collections.shuffle(deck);
        // Map<String, Double> temp = new HashMap<>();

        // Random rd = new Random();

        // for (String s : deck) {
        // temp.put(s, rd.nextDouble(52.00));
        // }

        // List<Map.Entry<String, Double>> list = new ArrayList<>(temp.entrySet());
        // list.sort(Map.Entry.comparingByValue());

        // // Step 2: Put into LinkedHashMap to preserve order
        // Map<String, Double> sortedMap = new LinkedHashMap<>();
        // for (Map.Entry<String, Double> entry : list) {
        // sortedMap.put(entry.getKey(), entry.getValue());
        // }

        // int po = 0;
        // for (Map.Entry<String, Double> i : sortedMap.entrySet()) {
        // deck.set(po, i.getKey());
        // po++;
        // }
    }
}
