package org.linfd.leetcode.topliked;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * #17 Letter Combinations
 *
 *
 * Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent.
 *
 * A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.
 *
 *
 *  new int[]{"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"}
 *
 *
 * Example:
 *
 * Input: "23"
 *
 * 2-"abc"
 * 3-"def"
 *
 * Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 * Note:
 *
 * Although the above answer is in lexicographical order, your answer could be in any order you want.
 *
 *
 */
public class _17_LetterCombinations {

    Map<String, String> phone = new HashMap<String, String>() {{
        put("2", "abc");
        put("3", "def");
        put("4", "ghi");
        put("5", "jkl");
        put("6", "mno");
        put("7", "pqrs");
        put("8", "tuv");
        put("9", "wxyz");
    }};

    List<String> output = new ArrayList<String>();

    public void backtrack(String combination, String nextDigit){
        if(nextDigit.length() == 0){
            output.add(combination);
        }else {
            String digit = nextDigit.substring(0,1);
            String letters = phone.get(digit);
            for(int i=0; i< letters.length(); i++){
                String letter = letters.substring(i, i+1);
                backtrack(combination + letter, nextDigit.substring(1));
            }
        }
    }

    public List<String> letterCombinations(String digits) {
        if(digits.length() != 0){
            backtrack("", digits);
        }
        return output;
    }

}
