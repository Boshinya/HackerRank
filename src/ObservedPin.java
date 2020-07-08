import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

public class ObservedPin {
//    Alright, detective, one of our colleagues successfully observed our target person, Robby the robber. We followed him to a secret warehouse, where we assume to find all the stolen stuff. The door to this warehouse is secured by an electronic combination lock. Unfortunately our spy isn't sure about the PIN he saw, when Robby entered it.
//
//    The keypad has the following layout:
//
//        ┌───┬───┬───┐
//        │ 1 │ 2 │ 3 │
//        ├───┼───┼───┤
//        │ 4 │ 5 │ 6 │
//        ├───┼───┼───┤
//        │ 7 │ 8 │ 9 │
//        └───┼───┼───┘
//        │ 0 │
//        └───┘
//    He noted the PIN 1357, but he also said, it is possible that each of the digits he saw could actually be another adjacent digit (horizontally or vertically, but not diagonally). E.g. instead of the 1 it could also be the 2 or 4. And instead of the 5 it could also be the 2, 4, 6 or 8.
//
//    He also mentioned, he knows this kind of locks. You can enter an unlimited amount of wrong PINs, they never finally lock the system or sound the alarm. That's why we can try out all possible (*) variations.
//
//        * possible in sense of: the observed PIN itself and all variations considering the adjacent digits

        //codeWars solution
        public static List<String> getPINs(String observed) {

            LinkedHashMap<Character, String> map = new LinkedHashMap();

            map.put('1',"241");
            map.put('2', "1352");
            map.put('3', "263");
            map.put('4', "154");
            map.put('5', "46825");
            map.put('6', "3965");
            map.put('7', "487");
            map.put('8', "05798");
            map.put('9', "689");
            map.put('0', "08");

            List<String> ans = Arrays.asList("");

            for (char c: observed.toCharArray()) {

                List<String> tmp = new ArrayList<String>();
                for (char cc: map.get(c).toCharArray()) {
                    for (String s: ans) tmp.add(s+cc);
                }
                ans = tmp;
            }
            return ans;
    }

        private static final String[] LOCK_ADJACENTS = new String[] {
            "08",
            "124",
            "2135",
            "326",
            "4157",
            "52468",
            "6359",
            "748",
            "85790",
            "968"
        };

        public static List<String> generate(String s) {
            List<String> results = new ArrayList<>();
            generateAll(s, 0, results, new Stack<>());
            results.stream().forEach(System.out::println);
            return results;
        }

        private static void generateAll(String s, int index, List<String> generated, Stack<Character> charPlacements) {
            if(index == s.length()) {
                String string = charPlacements.stream().map(String::valueOf).collect(Collectors.joining());
                generated.add(string);
            } else {
                char c = s.charAt(index);
                String mnemonics = LOCK_ADJACENTS[c-'0'];
                for (Character m : mnemonics.toCharArray()) {
                    charPlacements.push(m);
                    generateAll(s, index+1, generated, charPlacements);
                    charPlacements.pop();
                }
            }
        }

    @Test
    public void testObservedPin() {
        getPINs("369");
    }

}
