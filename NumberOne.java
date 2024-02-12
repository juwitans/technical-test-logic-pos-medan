package posmedan;

import java.util.*;

public class NumberOne {
    public static void main(String[] args) {
        //receive input
        Scanner scanner = new Scanner(System.in);
        System.out.print("Input: ");
        String string = scanner.nextLine();

        //change input to lowercase and then to char array
        char[] chars = string.toLowerCase().toCharArray();

        //count the occurrence of each character
        Map<Character, Integer> counter = characterCounter(chars);

        //print result
        for (Map.Entry<Character, Integer> entry : counter.entrySet()) {
            System.out.print(entry.getKey() + ":" + entry.getValue()+ " ");
        }

    }

    private static Map<Character, Integer> characterCounter(char[] chars) {
        Map<Character,Integer> check = new LinkedHashMap<>();
        Set<Character> characterSet = new LinkedHashSet<>();

        //find all distinct characters from input
        for (char i : chars) {
            if (i == ' ') continue;
            characterSet.add(i);
        }

        //set the number of occurrence of each character to 0
        for (Character i : characterSet) {
            check.put(i,0);
        }

        //count the occurrence of each character
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
}
