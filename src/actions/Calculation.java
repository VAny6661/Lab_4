package actions;

import java.util.Stack;

import converter.InfixToPostfix;

public class Calculation {

    private  Calculation calculator;

    public  Calculation getCalculator() {
        return calculator;
    }

    private  double answer = 0;

    private  boolean change = false;


    public Calculation() {
        this.calculator = this;
    }

    private  void calculate(ActionText text) {
        Stack<Double> stack = new Stack<>();
        String input = text.getTextField().getText().getText();
        for(int i =0;i<input.length();i++){
            int j =i;
            if(input.charAt(i) == '-' && i==0){
                i++;
                while(Character.isDigit(input.charAt(i)))i++;
                stack.push(Double.parseDouble(input.substring(j, i)));
                input = input.substring(0, j) + input.substring(i, input.length());
                change =true;
            break;}

        }
        var operands = InfixToPostfix.Convert(input);

        for (var operand : operands) {
            switch(operand) {
                case "+":
                {
                    double firstOperand = stack.pop();
                    double secondOperand = stack.pop();
                    stack.push(firstOperand + secondOperand);
                }
                break;
                case "-":
                {
                    if(stack.size() <2)
                        break;
                    double firstOperand = stack.pop();
                    double secondOperand = stack.pop();
                    stack.push(secondOperand - firstOperand);
                }
                break;
                case "*":
                {
                    double firstOperand = stack.pop();
                    double secondOperand = stack.pop();
                    stack.push(firstOperand * secondOperand);
                }
                break;
                case "/":
                {
                    double firstOperand = stack.pop();
                    double secondOperand = stack.pop();
                    stack.push(secondOperand / firstOperand);
                }
                break;
                case "%":
                {
                    double firstOperand = stack.pop();
                    double secondOperand = stack.pop();
                    stack.push(secondOperand % firstOperand);
                }
                break;
                case "√":
                {
                    double firstOperand = stack.pop();
                    stack.push(Math.sqrt((firstOperand)));
                }
                break;
                case "^":
                {
                    double firstOperand = stack.pop();
                    double secondOperand = stack.pop();
                    stack.push(Math.pow(secondOperand, firstOperand));
                }
                break;
                case "":
                break;
                default:
                stack.push(Double.parseDouble(operand));
                break;
            }
        }
        answer = stack.pop();
    }

    public double getAnswer() {
        return answer;
    }

    public  void makeCalculation(ActionText text) {
        calculate(text);
    }
}