package actions;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;

public class CreateLabel {

    private  CreateLabel createLabel;

    public  CreateLabel getLabel() {
        return createLabel;
    }

    private  Label label;

    public CreateLabel(Composite parent) {
        this.label = new Label(parent, SWT.BORDER);
        label.setLayoutData(new GridData(SWT.FILL, SWT.FILL,
                true, false, 3, 1));
        this.createLabel = this;
    }


    public  boolean getAnswer(Calculation calc) {
        String answer = Double.toString(calc.getCalculator().getAnswer());
        label.setText(answer);
        label.getParent().layout();
        return false;
    }

}