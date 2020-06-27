package actions;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;

import converter.InfixToPostfix;
import converter.PostToIn;

public class ActionText {

    private  ActionText text;

    public  ActionText getTextField() {
        return text;
    }

    private  List<String> states;
    private int stateIndex = 0;
    private Text inputField;
    private boolean skip = false;

    public ActionText(Composite parent) {
        this.inputField = new Text(parent, SWT.BORDER);
        inputField.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false, 4, 1));
        this.states = new ArrayList<>();
        this.text = this;
    }

    public  Text getText() {
        return inputField;
    }

    public  void preparingForCalculations() {
        states.clear();
        states.add(inputField.getText());
        calculateStates();
    }

    private void calculateStates() {
        String input = inputField.getText();
        List<String> operands = InfixToPostfix.Convert(input);
        for(int i = 0; i < operands.size(); i++) {
            switch(operands.get(i)) {
                case "+":
                {
                    double firstOperand;
                    double secondOperand;
                    if(skip == true){
                        firstOperand = Double.parseDouble(operands.get(i-3) + operands.get((i-2)));
                        secondOperand = Double.parseDouble( operands.get(i-1));
                        operands.remove(i-1);
                        i--;
                        operands.remove(i-1);
                        i--;
                        operands.remove(i-1);
                        i--;
                    }
                    else{
                        firstOperand = Double.parseDouble(operands.get(i-2));
                        secondOperand = Double.parseDouble( operands.get(i-1));
                        operands.remove(i-1);
                        i--;
                        operands.remove(i-1);
                        i--;}

                    operands.set(i, String.valueOf(firstOperand + secondOperand));
                    String nextState = PostToIn.convert(operands);
                    states.add(nextState);
                    skip = false;
                }
                break;
                case "-":
                {
                    if(i-2<0){
                        skip =true;
                        break;
                    }
                    double firstOperand;
                    double secondOperand;
                    if(skip == true){
                        firstOperand = Double.parseDouble(operands.get(i-3) + operands.get((i-2)));
                        secondOperand = Double.parseDouble( operands.get(i-1));
                        operands.remove(i-1);
                        i--;
                        operands.remove(i-1);
                        i--;
                        operands.remove(i-1);
                        i--;
                    }
                    else{
                        firstOperand = Double.parseDouble(operands.get(i-2));
                        secondOperand = Double.parseDouble( operands.get(i-1));
                        operands.remove(i-1);
                        i--;
                        operands.remove(i-1);
                        i--;}
                    operands.set(i, String.valueOf(firstOperand - secondOperand));
                    String nextState = PostToIn.convert(operands);
                    states.add(nextState);
                    skip = false;
                }
                break;
                case "^":
                {
                    double firstOperand;
                    double secondOperand;
                    if(skip == true){
                        firstOperand = Double.parseDouble(operands.get(i-3) + operands.get((i-2)));
                        secondOperand = Double.parseDouble( operands.get(i-1));
                        operands.remove(i-1);
                        i--;
                        operands.remove(i-1);
                        i--;
                        operands.remove(i-1);
                        i--;
                    }
                    else{
                        firstOperand = Double.parseDouble(operands.get(i-2));
                        secondOperand = Double.parseDouble( operands.get(i-1));
                        operands.remove(i-1);
                        i--;
                        operands.remove(i-1);
                        i--; }
                    operands.set(i, String.valueOf(Math.pow(firstOperand, secondOperand)));
                    String nextState = PostToIn.convert(operands);
                    states.add(nextState);
                    skip = false;
                }
                break;
                case "*":
                {
                    double firstOperand;
                    double secondOperand;
                    if(skip == true){
                        firstOperand = Double.parseDouble(operands.get(i-3) + operands.get((i-2)));
                        secondOperand = Double.parseDouble( operands.get(i-1));
                        operands.remove(i-1);
                        i--;
                        operands.remove(i-1);
                        i--;
                        operands.remove(i-1);
                        i--;
                    }
                    else{
                        firstOperand = Double.parseDouble(operands.get(i-2));
                        secondOperand = Double.parseDouble( operands.get(i-1));
                        operands.remove(i-1);
                        i--;
                        operands.remove(i-1);
                        i--;}
                    operands.set(i, String.valueOf(firstOperand * secondOperand));
                    String nextState = PostToIn.convert(operands);
                    states.add(nextState);
                    skip = false;
                }
                break;
                case "/":
                {
                    double firstOperand;
                    double secondOperand;
                    if(skip == true){
                        firstOperand = Double.parseDouble(operands.get(i-3) + operands.get((i-2)));
                        secondOperand = Double.parseDouble( operands.get(i-1));
                        operands.remove(i-1);
                        i--;
                        operands.remove(i-1);
                        i--;
                        operands.remove(i-1);
                        i--;
                    }
                    else{
                        firstOperand = Double.parseDouble(operands.get(i-2));
                        secondOperand = Double.parseDouble( operands.get(i-1));
                        operands.remove(i-1);
                        i--;
                        operands.remove(i-1);
                        i--;}
                    operands.set(i, String.valueOf(firstOperand / secondOperand));
                    String nextState = PostToIn.convert(operands);
                    states.add(nextState);
                    skip = false;
                }
                break;
                case "%":
                {
                    double firstOperand;
                    double secondOperand;
                    if(skip == true){
                        firstOperand = Double.parseDouble(operands.get(i-3) + operands.get((i-2)));
                        secondOperand = Double.parseDouble( operands.get(i-1));
                        operands.remove(i-1);
                        i--;
                        operands.remove(i-1);
                        i--;
                        operands.remove(i-1);
                        i--;
                    }
                    else{
                        firstOperand = Double.parseDouble(operands.get(i-2));
                        secondOperand = Double.parseDouble( operands.get(i-1));
                        operands.remove(i-1);
                        i--;
                        operands.remove(i-1);
                        i--;}
                    operands.set(i, String.valueOf(firstOperand % secondOperand));
                    String nextState = PostToIn.convert(operands);
                    states.add(nextState);
                    skip = false;
                }
                break;
                case "√":
                {
                    double firstOperand = Double.parseDouble(operands.get(i-1));
                    operands.remove(i-1);
                    i--;
                    operands.set(i, String.valueOf(Math.sqrt(firstOperand)));
                    String nextState = PostToIn.convert(operands);
                    states.add(nextState);
                    skip = false;
                }
                break;
            }
        }
    }


    public void nextState() {
        if(stateIndex + 1 < states.size()) {
            stateIndex++;
            inputField.setText(states.get(stateIndex));
        }
    }


    public void previousState() {
        if(stateIndex - 1 >= 0) {
            stateIndex--;
            inputField.setText(states.get(stateIndex));
        }
    }
    
}