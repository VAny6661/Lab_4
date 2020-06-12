package converter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


  
import java.util.Stack; 
  
public class InfixToPostfix 
{ 

    static int Prec(char ch) 
    { 
        switch (ch) 
        { 
        case '+': 
        case '-': 
            return 1; 
       
        case '*': 
        case '/': 
        case '%': 
            return 2; 
       
        case '^': 
        case '√':
                return 3;
        } 
        return -1; 
    } 
       

    public static List<String> Convert(String exp) 
    { 

        String result = new String("");

        exp = exp.replaceAll("(\\*|/|\\+|-|%|\\^|√)", " $1 ");
          

        Stack<Character> stack = new Stack<>(); 
          
        for (int i = 0; i<exp.length(); ++i)
        { 
            char c = exp.charAt(i);

            if (Character.isLetterOrDigit(c) || c == '.' || c == ' ' || c == '-' &&
                    ((i==1 && Character.isDigit(exp.charAt(i+2)))
                            || (!Character.isDigit(exp.charAt(i-2)) && Character.isDigit(exp.charAt(i+2)))))
                result += c; 

            else if (c == '(') 
                stack.push(c); 
              
            else if (c == ')') 
            { 
                while (!stack.isEmpty() && stack.peek() != '(') {
                    result += " ";
                    result += stack.pop(); 
                }
                  
                if (!stack.isEmpty() && stack.peek() != '(') {
                    return null; // invalid expression        
                }         
                else {
                    stack.pop(); 
                }
            } 
            else // an operator is encountered 
            { 
                while (!stack.isEmpty() && Prec(c) <= Prec(stack.peek())){ 
                    if(stack.peek() == '(') 
                        return null; 
                    result += stack.pop(); 
             } 
                stack.push(c); 
            } 
       
        } 
       
        while (!stack.isEmpty()){ 
            if(stack.peek() == '(') 
                return null; 
            result += " ";
            result += stack.pop(); 
         }
        ArrayList<String> operands = new ArrayList<String>(Arrays.asList(result.split(" ")));
         operands.removeIf(i -> i.isBlank());
        return operands; 
    }
   }
