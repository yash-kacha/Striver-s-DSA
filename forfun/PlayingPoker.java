package forfun;

import java.util.*;

public class PlayingPoker {
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

        shuffle(deck);

        List<List<String>> hands = deeler(deck);
        System.out.println("all hands : " + hands);

        System.out.println("Comunity card : " + hands.getLast());

        int ranki = 1;

        System.out.println(" Rank |  Hand  ");
        for (Map.Entry<List<String>, byte[]> op : rank(hands).entrySet()) {
            System.out.printf("%6d|", ranki++);
            System.out.println(op.getKey());
        }

    }

    public static Map<List<String>, byte[]> rank(List<List<String>> hands) {
        Map<List<String>, byte[]> ans = eval(hands);

        Map<List<String>, byte[]> sortedAns = ans.entrySet().stream()
                .sorted((e1, e2) -> {
                    byte[] a = e1.getValue();
                    byte[] b = e2.getValue();
                    for (int i = 0; i < Math.min(a.length, b.length); i++) {
                        int cmp = Byte.compare(b[i], a[i]); // Descending
                        // Ascending
                        if (cmp != 0)
                            return cmp;
                    }
                    return Integer.compare(a.length, b.length); // Tie-breaker
                })
                .collect(
                        LinkedHashMap::new,
                        (map, entry) -> map.put(entry.getKey(), entry.getValue()),
                        Map::putAll);

        return sortedAns;

    }

    public static Map<List<String>, byte[]> eval(List<List<String>> hands) {
        int[] ranks = new int[7];
        char[] suits = new char[7];

        Map<List<String>, byte[]> ans = new HashMap<>();

        for (int i = 0; i < hands.size() - 1; i++) {

            for (int ii = 0; ii <= 4; ii++) {
                ranks[ii] = getCardValue(hands.getLast().get(ii).charAt(0));
                suits[ii] = hands.getLast().get(ii).charAt(1);
            }

            ranks[5] = getCardValue(hands.get(i).get(0).charAt(0));
            suits[5] = hands.get(i).get(0).charAt(1);

            ranks[6] = getCardValue(hands.get(i).get(1).charAt(0));
            suits[6] = hands.get(i).get(1).charAt(1);

            Arrays.sort(ranks);

            if (isStraitFlush(suits, ranks)) {
                ans.put(hands.get(i), isStraitFlushEval(suits, ranks));
            } else if (isQuad(ranks)) {
                ans.put(hands.get(i), isQuadEval(ranks));
            } else if (isFullHouse(ranks)) {
                ans.put(hands.get(i), isFullHouseEval(ranks));
            } else if (isFlush(suits)) {
                ans.put(hands.get(i), isFlushEval(suits, ranks));
            } else if (isStraight(ranks)) {
                ans.put(hands.get(i), isStraitEval(ranks));
            } else if (isTrio(ranks)) {
                ans.put(hands.get(i), isTrioEval(ranks));
            } else if (isTwoPair(ranks)) {
                ans.put(hands.get(i), isTwoPairEval(ranks));
            } else if (isPair(ranks)) {
                ans.put(hands.get(i), isPairEval(ranks));
            } else {
                ans.put(hands.get(i), highCard(ranks));
            }
        }

        return ans;
    }

    private static boolean isStraitFlush(char[] suits, int[] ranks) {
        Map<Character, Integer> suitCount = new HashMap<>();

        boolean flush = false;
        char ch = 'c';
        for (char suit : suits) {
            suitCount.put(suit, suitCount.getOrDefault(suit, 0) + 1);
            if (suitCount.get(suit) >= 5) {
                flush = true;
                ch = suit;
            }
        }

        int[] nr = new int[7];
        for (int i = 0, index = 0; i < suits.length; i++) {
            if (suits[i] == ch)
                nr[index++] = ranks[i];
        }

        Arrays.sort(nr);
        return flush && isStraight(nr);
    }

    public static byte[] isStraitFlushEval(char[] suits, int[] ranks) {
        byte[] hand = new byte[2];
        Map<Character, Integer> suitCount = new HashMap<>();

        boolean flush = false;
        char ch = 'c';
        for (char suit : suits) {
            suitCount.put(suit, suitCount.getOrDefault(suit, 0) + 1);
            if (suitCount.get(suit) >= 5) {
                flush = true;
                ch = suit;
            }
        }

        int[] nr = new int[7];
        for (int i = 0, index = 0; i < suits.length; i++) {
            if (suits[i] == ch)
                nr[index++] = ranks[i];
        }

        Arrays.sort(nr);

        hand = isStraitEval(nr);
        hand[0] = 8;
        return hand;

    }

    private static boolean isQuad(int[] ranks) {

        Map<Integer, Integer> suitCount = new HashMap<>();

        for (int i : ranks) {
            suitCount.put(i, suitCount.getOrDefault(i, 0) + 1);
        }

        for (Map.Entry<Integer, Integer> op : suitCount.entrySet()) {
            if (op.getValue() >= 4)
                return true;
        }
        return false;
    }

    public static byte[] isQuadEval(int[] ranks) {
        byte[] hand = new byte[2];

        hand[0] = 7;

        Map<Integer, Integer> suitCount = new HashMap<>();

        for (int i : ranks) {
            suitCount.put(i, suitCount.getOrDefault(i, 0) + 1);
        }

        for (Map.Entry<Integer, Integer> op : suitCount.entrySet()) {
            if (op.getValue() >= 4)
                hand[1] = (byte) (int) op.getKey();
        }
        return hand;
    }

    private static boolean isFullHouse(int[] ranks) {

        boolean three = false, two = false;

        Map<Integer, Integer> suitCount = new HashMap<>();

        for (int i : ranks) {
            suitCount.put(i, suitCount.getOrDefault(i, 0) + 1);
        }

        for (Map.Entry<Integer, Integer> op : suitCount.entrySet()) {
            if (op.getValue() >= 3)
                three = true;
            else if (op.getValue() >= 2)
                two = true;

        }

        return three && two;
    }

    public static byte[] isFullHouseEval(int[] ranks) {
        byte[] hand = new byte[3];

        hand[0] = 6;

        Map<Integer, Integer> suitCount = new HashMap<>();

        for (int i : ranks) {
            suitCount.put(i, suitCount.getOrDefault(i, 0) + 1);
        }

        for (Map.Entry<Integer, Integer> op : suitCount.entrySet()) {
            if (op.getValue() >= 3)
                hand[1] = (byte) (int) op.getKey();
            else if (op.getValue() >= 2)
                hand[2] = (byte) (int) op.getKey();

        }
        return hand;
    }

    private static boolean isFlush(char[] suits) {
        Map<Character, Integer> suitCount = new HashMap<>();

        for (char suit : suits) {
            suitCount.put(suit, suitCount.getOrDefault(suit, 0) + 1);
            if (suitCount.get(suit) >= 5)
                return true;
        }

        return false;
    }

    public static byte[] isFlushEval(char[] suits, int[] ranks) {
        byte[] hand = new byte[6];
        hand[0] = 5;
        char op = 'c';

        Map<Character, Integer> suitCount = new HashMap<>();

        for (char suit : suits) {
            suitCount.put(suit, suitCount.getOrDefault(suit, 0) + 1);
            if (suitCount.get(suit) >= 5)
                op = suit;

        }

        for (int index = ranks.length - 1, cnt = 1; index >= 0 && cnt <= 5; index--) {
            if (suits[index] == op)
                hand[cnt++] = (byte) ranks[index];

        }

        return hand;

    }

    // 0 1 2 3 4 5 6
    private static boolean isStraight(int[] ranks) {
        Set<Integer> set = new HashSet<>();

        for (int rank : ranks) {
            set.add(rank);
            if (rank == 14)
                set.add(1);
        }

        int[] unique = new int[set.size()];
        int idx = 0;
        for (int num : set) {
            unique[idx++] = num;
        }

        Arrays.sort(unique);

        int count = 1;
        for (int i = 1; i < unique.length; i++) {
            if (unique[i] == unique[i - 1] + 1) {
                count++;
                if (count >= 5)
                    return true;
            } else {
                count = 1;
            }
        }

        return false;
    }

    public static byte[] isStraitEval(int[] ranks) {
        byte[] hand = new byte[2];
        hand[0] = (byte) 4;

        Set<Integer> set = new HashSet<>();

        for (int rank : ranks) {
            set.add(rank);
            if (rank == 14)
                set.add(1);
        }

        int[] unique = new int[set.size()];
        int idx = 0;
        for (int num : set) {
            unique[idx++] = num;
        }

        Arrays.sort(unique);

        int tempo = 0;
        ;
        int count = 1;
        for (int i = 1; i < unique.length; i++) {
            if (unique[i] == unique[i - 1] + 1) {
                count++;
                if (count >= 5)
                    hand[1] = (byte) unique[i];

            } else {
                count = 1;
                tempo = unique[i];
            }
        }

        return hand;

    }

    private static boolean isTrio(int[] ranks) {
        for (int i = 0; i < ranks.length - 2; i++) {
            if (ranks[i] == ranks[i + 1] && ranks[i + 1] == ranks[i + 2])
                return true;
        }
        return false;
    }

    private static byte[] isTrioEval(int[] ranks) {
        byte[] hand = new byte[4];
        int index = 0;
        hand[index++] = 3;

        for (int i = 0; i < ranks.length - 2; i++) {
            if (ranks[i] == ranks[i + 1] && ranks[i + 1] == ranks[i + 2]) {
                hand[index++] = (byte) ranks[i];

                for (int j = ranks.length - 1; index < 4 && j >= 0; j--) {
                    if (j == i || j == i + 1 || j == i + 2) {
                    } else {
                        hand[index++] = (byte) ranks[j];
                    }
                }
            }
        }
        return hand;
    }

    private static boolean isTwoPair(int[] ranks) {
        int cnt = 0;

        for (int i = 0; i < ranks.length - 1; i++) {
            if (ranks[i] == ranks[i + 1])
                cnt++;
        }
        return cnt == 2;
    }

    public static byte[] isTwoPairEval(int[] ranks) {
        byte[] hand = new byte[4];
        int index = 0, cnt = 0, i1 = 0;
        hand[index++] = 2;
        for (int i = 0; i < ranks.length - 1; i++) {
            if (ranks[i] == ranks[i + 1]) {
                if (cnt == 0) {
                    cnt++;
                    i1 = i;
                } else if (cnt == 1) {
                    hand[index++] = (byte) ranks[i];
                    hand[index++] = (byte) ranks[i1];

                    for (int j = ranks.length - 1; index < 4 && j >= 0; j--) {
                        if (j == i || j == i + 1 || j == i1 || j == i1 + 1) {
                        } else {
                            hand[index++] = (byte) ranks[j];
                        }
                    }
                }
            }
        }

        return hand;
    }

    private static boolean isPair(int[] ranks) {
        for (int i = 0; i < ranks.length - 1; i++) {
            if (ranks[i] == ranks[i + 1])
                return true;
        }
        return false;
    }

    private static byte[] isPairEval(int[] ranks) {
        byte[] hand = new byte[5];
        hand[0] = 1;
        for (int i = 0; i < ranks.length - 1; i++) {
            if (ranks[i] == ranks[i + 1]) {
                hand[1] = (byte) ranks[i];

                for (int j = ranks.length - 1, cnt = 2; cnt <= 4; j--) {
                    if (j == i || j == i + 1) {
                    } else {
                        hand[cnt] = (byte) ranks[j];
                        cnt++;
                    }
                }
                break;
            }
        }
        return hand;
    }

    private static byte[] highCard(int[] ranks) {
        byte[] hand = new byte[6];
        hand[0] = 0;

        for (int j = ranks.length - 1, cnt = 1; j >= 0 && cnt <= 5; j--, cnt++) {
            hand[cnt] = (byte) ranks[j];
        }
        return hand;
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

    public static List<List<String>> deeler(List<String> deck) {
        List<List<String>> ans = new ArrayList<>();

        int playerCnt = 5;
        for (int i = 0; i < playerCnt + 1; i++) {
            ans.add(new ArrayList<>());
        }

        // give or each player 2 card adding in ans
        for (int card = 0; card < 2; card++) {
            for (int player = 0; player < playerCnt; player++) {
                ans.get(player).add(deck.get(0));
                deck.remove(0);
            }
        }

        // giving community card;
        deck.remove(0);
        ans.get(playerCnt).add(deck.get(0));
        ans.get(playerCnt).add(deck.get(1));
        ans.get(playerCnt).add(deck.get(2));
        ans.get(playerCnt).add(deck.get(4));
        ans.get(playerCnt).add(deck.get(6));

        return ans;
    }

    public static void shuffle(List<String> deck) {

        Collections.shuffle(deck);

    }
}
