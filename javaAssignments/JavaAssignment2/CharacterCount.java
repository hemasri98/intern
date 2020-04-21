package com.company;
import java.util.*;
import java.lang.*;
import java.util.logging.Logger;


public class CharacterCount {
    // storing the count of each alphabet in an array
    public static int[] characterCount(String inputString) {
        int []alphabetsArray = new int[26];
        String stringLowerCase = inputString.toLowerCase();           //changes all letters in string to same case as it is case-insensitive
        for(int i = 0 ; i < stringLowerCase.length() ; i++) {
            if(Character.isLetter(stringLowerCase.charAt(i))) {
                alphabetsArray[stringLowerCase.charAt(i) - 97] += 1;  // subtracting 97 from every character's ascii value so that the value of a is 0, b is 1 so on.
            }
        }
        return alphabetsArray;
    }
    //checking whether string contains all letters of alphabets
    public static boolean containsAllLetters(String inputString) {
        int []alphabetsArray = characterCount(inputString);
        for (int count : alphabetsArray) {
            if (count < 1)                                           // returns false if the count is zero
                return false;
        }
        return true;
    }
    public static void main(String []args) {
        Logger LOGGER = Logger.getAnonymousLogger();
        try {
            TestCharacterCount testcharactercount = new TestCharacterCount();
            testcharactercount.test();
            Scanner sc = new Scanner(System.in);
            String inputString = sc.next();

            if (containsAllLetters(inputString))
                LOGGER.info("Contain all alphabets");
            else
                LOGGER.info("Doesn't contain all alphabets");
        }
        catch (Exception e) {
            LOGGER.info("Error " + e);
        }
    }
}


//time complexicity : input string length(n) + array length(26) ~ O(n)
//space complexiciy : Array of length 26