package leetcode;

import java.util.ArrayList;
import java.util.List;

public class LetterCombinationsofAPhoneNumber
{

    public List<String> letterCombinations(String digits)
    {
        if(digits == null || digits.isEmpty())
        {
            List<String> result = new ArrayList<String>();
            result.add("");
            return result;
        }
        return letterCombinations(digits.toCharArray(), 0);
    }
    
    private List<String> letterCombinations(char[] digits, int start)
    {
        if(start == digits.length - 1)
        {
            List<String> result = new ArrayList<String>();
            char[] letters = getLetters(digits[start]);
            for(char c: letters)
                result.add("" + c);
            return result;
        }
        
        char[] firstWord = getLetters(digits[start]);
        List<String> subResult = letterCombinations(digits, start + 1);
        List<String> result = new ArrayList<String>();
        for(char c: firstWord)
            for(String word: subResult)
                result.add("" + c + word);
        return result;
    }
    
    private char[] getLetters(char digit)
    {
        char[][] letters = new char[][] {
                {}, 
                {}, 
                {'a', 'b', 'c'},
                {'d', 'e', 'f'},
                {'g', 'h', 'i'},
                {'j', 'k', 'l'},
                {'m', 'n', 'o'},
                {'p', 'q', 'r', 's'},
                {'t', 'u', 'v'},
                {'w', 'x', 'y', 'z'}
        };
        return letters[digit - '0'];
    }
    
    public static void main(String[] args)
    {
        LetterCombinationsofAPhoneNumber l = new LetterCombinationsofAPhoneNumber();
        System.out.println(l.letterCombinations("12"));
    }

}
