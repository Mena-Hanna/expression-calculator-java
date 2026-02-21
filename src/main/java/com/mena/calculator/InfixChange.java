package com.mena.calculator;
import java.util.ArrayList;

public class InfixChange {
    //turns it from infix order to postfix
    public static ArrayList<String> toPostfix(String input){
        ArrayList<String> tokenized = Tokenizer.tokenize(input);
        ArrayList<String> output = new ArrayList<>();
        ArrayList<String> operators = new ArrayList<>();
        String signs = "+-*/^()";
        
        //takes only numbers from tokenized input and adds them to numbers list
        for (int i = 0; i < tokenized.size(); i++){
            String incoming = tokenized.get(i);
            if (signs.indexOf(incoming) == -1)
                output.add(incoming);
            else if (incoming.equals("(")) 
                operators.add(incoming);
            else if (incoming.equals(")")){
                while (! operators.get(operators.size() - 1).equals("(")){
                    output.add(operators.get(operators.size() - 1));
                    operators.remove(operators.size() - 1);
                }
                operators.remove(operators.size() - 1);
            }
            else {
                //if empty
                if (operators.isEmpty())
                    operators.add(incoming);
                //if not empty operators list
                else {
                    Boolean checking = true;
                    while(checking){
                        int topIndex = 0;
                        String top = "";
                        if (! operators.isEmpty()) {
                            topIndex = operators.size() - 1;
                            top = operators.get(topIndex);
                        } else {
                            operators.add(incoming);
                            checking = false;
                        }
                        if(precedence(top) >= precedence(incoming)){
                            operators.remove(topIndex);
                            output.add(top);
                        } else {
                            if (checking)
                                operators.add(incoming);
                            checking = false;
                        }    
                    }   
                }
            }
        }
        while(! operators.isEmpty()){
            output.add(operators.get(operators.size() - 1));
            operators.remove(operators.size() - 1);
        }

        return output;
    }
    public static int precedence(String operator){
        switch (operator) {
            case "^":
                return 3;
            case "*":
                return 2;
            case "/":
                return 2;
            case "+":
                return 1;
            case "-":
                return 1;
            default:
                return 0;
        }
    }
    
}
