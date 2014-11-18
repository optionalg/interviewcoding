package leetcode;

import java.util.ArrayList;
import java.util.List;

public class LetterCombinationsofAPhoneNumber
{

	/**
	 * Based on the letters of a telephone keys
	 * Convert numbers to all possible combinations of letters
	 * e.g., 2: abc, 3:def, then 23 can be ad, ae, af, be, ...
	 */
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
    		// only one digit
        if(start == digits.length - 1)
        {
        		// make each letter a word
            List<String> result = new ArrayList<String>();
            char[] letters = getLetters(digits[start]);
            for(char c: letters)
                result.add("" + c);
            return result;
        }
        
        // get the letters of the first word
        char[] firstWord = getLetters(digits[start]);
        
        // recursively get the combinations of the rest words
        List<String> subResult = letterCombinations(digits, start + 1);
        
        // prepend each letter of the 1st word to each of the combinations
        List<String> result = new ArrayList<String>();
        for(char c: firstWord)
            for(String word: subResult)
                result.add("" + c + word);
        return result;
    }
    
    // Convert a digit to an array of letters
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
