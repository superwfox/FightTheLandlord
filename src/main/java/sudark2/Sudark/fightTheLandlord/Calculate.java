package sudark2.Sudark.fightTheLandlord;

import java.util.*;

public class Calculate {

    public static double calculate(List<String> cards) {

        double result = 0;
        Map<String, Integer> freq = countFreq(cards);
        result += Bomb(freq);
        result += Flight(freq);
        result += TotalThreeWithOne(freq);
        result += TotalThreeWithPai(freq);
        result += TotalSingle(cards);
        return result;

    }

    public static int getRank(String f) {
        return switch (f) {
            case "3" -> 1;
            case "4" -> 2;
            case "5" -> 3;
            case "6" -> 4;
            case "7" -> 5;
            case "8" -> 6;
            case "9" -> 7;
            case "10" -> 8;
            case "J" -> 9;
            case "Q" -> 10;
            case "K" -> 11;
            case "1" -> 12;
            case "2" -> 15;
            case "W" -> 18;
            case "w" -> 20;
            default -> 0;
        };
    }

    public static Map<String, Integer> countFreq(List<String> combo) {
        Map<String, Integer> freq = new HashMap<>();
        for (String card : combo) {
            freq.merge(card, 1, Integer::sum);
        }
        return freq;
    }

    public static int Bomb(Map<String, Integer> freq) {
        int sum = 0;
        for (Map.Entry<String, Integer> entry : freq.entrySet()) {
            if (entry.getValue() >= 4) {
                sum += getRank(entry.getKey()) * 4 + 20;
            }
        }
        return sum;
    }

    public static int Flight(Map<String, Integer> freq) {
        List<Integer> tripRanks = new ArrayList<>();

        for (Map.Entry<String, Integer> entry : freq.entrySet()) {
            int count = entry.getValue();
            int rank = getRank(entry.getKey());
            if (count == 3 && rank >= 1 && rank < getRank("2")) {
                tripRanks.add(rank);
            }
        }

        if (tripRanks.size() < 2) return 0;
        Collections.sort(tripRanks);

        int maxSum = 0;
        for (int i = 0; i < tripRanks.size(); i++) {
            int sum = tripRanks.get(i);
            int consec = 1;
            for (int j = i + 1; j < tripRanks.size(); j++) {
                if (tripRanks.get(j) == tripRanks.get(j - 1) + 1) {
                    sum += tripRanks.get(j) * 3 + 10;
                    consec++;
                    if (consec >= 2) maxSum = Math.max(maxSum, sum);
                } else {
                    break;
                }
            }
        }

        return maxSum;
    }

    public static double TotalThreeWithOne(Map<String, Integer> freq) {
        List<String> triples = new ArrayList<>();
        List<String> singles = new ArrayList<>();

        for (Map.Entry<String, Integer> e : freq.entrySet()) {
            String face = e.getKey();
            int count = e.getValue();
            if (count >= 3 && getRank(face) < getRank("2")) {
                triples.add(face);
            } else if (count >= 1) {
                singles.add(face);
            }
        }

        double total = 0;
        for (String t : triples) {
            for (String s : singles) {
                if (!s.equals(t)) {
                    total += getRank(t) + getRank(s) / 3.0 + 20;
                    break;  // 每个三张只带一个单张
                }
            }
        }
        return total;
    }

    public static double TotalThreeWithPai(Map<String, Integer> freq) {
        List<String> triples = new ArrayList<>();
        List<String> pairs = new ArrayList<>();

        for (Map.Entry<String, Integer> e : freq.entrySet()) {
            String face = e.getKey();
            int count = e.getValue();
            if (count >= 3 && getRank(face) < getRank("2")) {
                triples.add(face);
            } else if (count >= 2) {
                pairs.add(face);
            }
        }

        double total = 0;
        for (String t : triples) {
            for (String p : pairs) {
                if (!p.equals(t)) {
                    total += getRank(t) * 2 + 2.0 * getRank(p) / 3.0 + 20;
                    break;  // 每个三张只带一个对子
                }
            }
        }
        return total;
    }

    public static double TotalSingle(List<String> cards) {
        return cards.stream()
                .mapToInt(Calculate::getRank)
                .sum();
    }

}
