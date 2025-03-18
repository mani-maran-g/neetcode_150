import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LettersCombinationsKeyPad {

    static Map<Character, String> digitToString = new HashMap<>();

    LettersCombinationsKeyPad() {
        digitToString.put('2', "abc");
        digitToString.put('3', "def");
        digitToString.put('4', "ghi");
        digitToString.put('5', "jkl");
        digitToString.put('6', "mno");
        digitToString.put('7', "pqrs");
        digitToString.put('8', "tuv");
        digitToString.put('9', "wxyz");
    }

    public static List<String> letterCombinations(String digits) {

        List<String> result = new ArrayList<>();
        backtrack(digits, 0, "", result);
        return result;

    }

    static void backtrack(String digits, int ind, String currStr, List<String> res) {
        if (currStr.length() == digits.length()) {
            res.add(currStr);
            return;
        }

        for (char ch : digitToString.get(digits.charAt(ind)).toCharArray()) {
            backtrack(digits, ind + 1, currStr + ch, res);
        }
    }

    public static void main(String[] args) {

        LettersCombinationsKeyPad obj = new LettersCombinationsKeyPad();

        String[] testCases = new String[] {
                "34",
                "23",
        };

        for (String tc : testCases) {
            System.out.println(obj.letterCombinations(tc));
        }
    }
}