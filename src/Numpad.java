import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Text;

import actions.*;

public class Numpad extends Composite {

    public Numpad(Composite parent, int style, ActionText text, Calculation calc, CreateLabel label, CreateTree tree) {
        super(parent, style);
        Text inputField = text.getTextField().getText();
        this.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 4, 1));
        this.setLayout(new GridLayout(5, true));
        this.setBackground(Display.getDefault().getSystemColor(SWT.COLOR_BLACK));
        
        ControlStateButtons returnButton = new ControlStateButtons(this, "<", text, tree);
        
        ControlStateButtons nextButton = new ControlStateButtons(this, ">", text, tree);
        
        ClearButtonAction clearButton = new ClearButtonAction(inputField, "C", this, tree);

        InputButtonAction leftBracketButton = new InputButtonAction(inputField, "(", this);

        InputButtonAction rightBracketButton = new InputButtonAction(inputField, ")", this);
        
        InputButtonAction nineButton = new InputButtonAction(inputField, "9", this);
        
        InputButtonAction eightButton = new InputButtonAction(inputField, "8", this);
        
        InputButtonAction sevenButton = new InputButtonAction(inputField, "7", this);

        InputButtonAction plusButton = new InputButtonAction(inputField, "+", this);

        InputButtonAction minusButton = new InputButtonAction(inputField, "-", this);
        
        InputButtonAction sixButton = new InputButtonAction(inputField, "6", this);
        
        InputButtonAction fiveButton = new InputButtonAction(inputField, "5", this);
        
        InputButtonAction fourButton = new InputButtonAction(inputField, "4", this);

        InputButtonAction multiplyButton = new InputButtonAction(inputField, "*", this);
        
        InputButtonAction divisionButton = new InputButtonAction(inputField, "/", this);
        
        InputButtonAction oneButton = new InputButtonAction(inputField, "1", this);
        
        InputButtonAction twoButton = new InputButtonAction(inputField, "2", this);
        
        InputButtonAction threeButton = new InputButtonAction(inputField, "3", this);

        InputButtonAction percentButton = new InputButtonAction(inputField, "%", this);
        
        InvertButtonAction invertButton = new InvertButtonAction(inputField, "1/x", this);
        
        InputButtonAction zeroButton = new InputButtonAction(inputField, "0", this);
        
        InputButtonAction pointButton = new InputButtonAction(inputField, ".", this);

        EqualsButtonAction equalsButton = new EqualsButtonAction("=", this, text, calc, label, tree);

        ActionAdditionalNumpad additionalButton = new ActionAdditionalNumpad("Additional", this, inputField);
    }

}