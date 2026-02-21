package com.mena.calculator;
import java.text.DecimalFormat;
import java.util.Scanner;

public class CalculatorMain {
    //main program
    public static void main(String[] args) throws Exception {
        Scanner keyboard = new Scanner(System.in); 
        DecimalFormat df = new DecimalFormat("0.######");
        boolean ongoing = true;
        System.out.println("Welcome To The Calculator for Expressions!");
        System.out.println("Write down an expression without having any letters");
        System.out.println("Ex: ((1+2*3/4)^2 + 5 * 6) / 7 + 8");
        System.out.println("As you can see, spaces are irrelevant");
        System.out.println("Type Q to quit");
        while(ongoing){
            System.out.print("Expression: ");
            String input = keyboard.nextLine();
            if (input.equalsIgnoreCase("Q"))
                ongoing = false;
            else if (doesNotContainLetters(input)) {
                try {
                    double result = PostfixEvaluation.evaluate(input);
                    System.out.print("Solution: ");
                    System.out.println(df.format(result));
                } catch (IllegalArgumentException e) {
                    System.out.println("Invalid expression. Please try again.");
                    System.out.println("Reason: " + e.getMessage());
                }
            } else
                System.out.println("The expression you entered contains letters. Please try again.");
        }
        System.out.println("Thank you for using the expression calculator!");
    }
    //returns true if the input doesn't contain any letters
    public static Boolean doesNotContainLetters(String s){
        String signs = "+-*/^().";
        String withoutSpace = Tokenizer.removeSpace(s);
        for (int i = 0; i < withoutSpace.length(); i++)
            if (! Character.isDigit(withoutSpace.charAt(i)) && signs.indexOf(withoutSpace.charAt(i)) == -1)
                return false;
        return true;
    }
    
}

