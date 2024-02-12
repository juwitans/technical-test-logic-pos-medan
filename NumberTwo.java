package posmedan;

import java.util.*;

public class NumberTwo {
    public static void main(String[] args) {
        String[] input = {"Pendanaan","Terproteksi","Untuk","Dampak","Berarti"};

        char[] chars = String.join("", input).toCharArray();

        //count the occurrence of each character
        Map<Character, Integer> counter = characterCounter(chars);

        //sort the characters based on the number of occurrence & alphabetically
        ArrayList<Map.Entry<Character, Integer>> list = sortByCountNumberAndAlphabetically(counter);

        for (Map.Entry<Character, Integer> entry : list) {
            System.out.print(entry.getKey());
        }
    }

    private static Map<Character, Integer> characterCounter(char[] chars) {
        Map<Character,Integer> check = new LinkedHashMap<>();
        Set<Character> characterSet = new LinkedHashSet<>();

        for (char i : chars) {
            if (i == ' ') continue;
            characterSet.add(i);
        }

        for (Character i : characterSet) {
            check.put(i,0);
        }

        for (Character i : check.keySet()) {
            for (char j : chars) {
                if (i == j) {
                    Integer count = check.get(i);
                    check.put(i,count + 1);
                }
            }
        }
        return check;
    }

    private static ArrayList<Map.Entry<Character, Integer>> sortByCountNumberAndAlphabetically(Map<Character, Integer> counter) {
        ArrayList<Map.Entry<Character, Integer>> list = new ArrayList<>(counter.entrySet());
        list.sort((char1,char2) -> {
            int comparedByOccurrence = char2.getValue().compareTo(char1.getValue());

            if (comparedByOccurrence == 0) {
                char character1 = char1.getKey();
                char character2 = char2.getKey();
                if (Character.isUpperCase(character1) && Character.isLowerCase(character2)) {
                    return -1;
                } else if (Character.isLowerCase(character1) && Character.isUpperCase(character2)) {
                    return 1;
                } else {
                    return Character.compare(character1,character2);
                }
            }
            return comparedByOccurrence;
        });
        return list;
    }

}
