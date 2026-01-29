import java.util.ArrayList;

public class PostfixEvaluation {
    //evaluates a list of numbers and operators and gives you the solution of the equation
    public static double evaluate(String input){
        ArrayList<String> list = InfixChange.toPostfix(input);
        ArrayList<Double> solution = new ArrayList<>();
        int currentIndex = 0;
        String current = list.get(0);
        while(currentIndex < list.size()){
            current = list.get(currentIndex);
            if (isNumber(current)) {
                solution.add(Double.parseDouble(current));
            } else {
                if (solution.size() < 2) 
                    throw new IllegalArgumentException("not enough operands before or after operator '" + current + "'");

                double right = solution.remove(solution.size() - 1);
                double left = solution.remove(solution.size() - 1);
                
                double evaluated = 0.0;
                switch (current) {
                    case "^": evaluated = Math.pow(left, right); break;
                    case "*": evaluated = left * right; break;
                    case "/": evaluated = left / right; break;
                    case "+": evaluated = left + right; break;
                    case "-": evaluated = left - right; break;
                    default:
                    throw new IllegalArgumentException("unknown operator '" + current + "'");
                }
                solution.add(evaluated);
            }
            currentIndex++;

        }
        if (solution.size() != 1) 
            throw new IllegalArgumentException("leftover values on stack (" + solution.size() + ")");

        return solution.get(0);
    }


    //returns true if the String is a number
    public static Boolean isNumber(String s){
        if ("+-*/^()".indexOf(s.charAt(0)) != -1 && s.length() == 1)
            return false;
        return true;
    }
}
