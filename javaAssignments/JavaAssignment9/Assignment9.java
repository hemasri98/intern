package com.company;

import java.io.File;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Assignment9 {

        public static void checkSentence(String sentence) {
            if( Pattern.compile("[A-Z](.*)[.?!]$"). matcher(sentence).matches()) {
                System.out.println("Yes");
            }
             else {
               System.out.println("No");
             }
        }
        public static void main(String[] args) {
            // write your code here
            Scanner sc = new Scanner(System.in);
            String sentence = "*linux*";
            while((sentence = sc.nextLine()).length() > 0) {
                //System.out.println(exp);
                checkSentence(sentence);
            }

        }


}

