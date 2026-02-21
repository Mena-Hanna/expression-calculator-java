package com.mena.calculator;
import java.util.ArrayList;

public class Tokenizer {
    // returns a string without any spaces
    public static String removeSpace(String input){
        String output = "";
        for (int i = 0; i < input.length(); i++){
            if (input.charAt(i) != ' ')
                output += input.charAt(i);
        }
        return output;
    }
    //tokenizes the string input and returns an ArrayList of tokenized strings
    public static ArrayList<String> tokenize(String input){
        String noSpaces = removeSpace(input);
        ArrayList<String> finalOutput = new ArrayList<>();
        String number = "";
        for (int i = 0; i < noSpaces.length(); i++){
            char c = noSpaces.charAt(i);

            if (c == '-' && (i == 0 || "+-*/^(".indexOf(noSpaces.charAt(i - 1)) != -1))
                number += c;
            else if (c == '.')
                number += c;  
            else if (! Character.isDigit(c)){
                if (!number.isEmpty())
                    finalOutput.add(number);
                number = "";
                finalOutput.add(String.valueOf(c));
            }
            else
                number += c;
            
        }
        if (!number.isEmpty())
            finalOutput.add(number);
        return finalOutput;
    }
}
