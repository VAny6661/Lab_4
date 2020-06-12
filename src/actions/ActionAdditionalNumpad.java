package actions;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Text;

import AdditionalNumpad;

public class ActionAdditionalNumpad{

    private Text inputField;
    private Button button;
    private boolean isEnabled = false;
    private Composite parent;
    private AdditionalNumpad additionalNumpad;

    public ActionAdditionalNumpad(String value, Composite parent, Text inputField) {
        this.inputField = inputField;
        this.parent = parent;
        this.button = new Button(parent, SWT.PUSH);
        button.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 2, 1));
        button.setText(value);
        button.addListener(SWT.MouseDown, new Listener(){
        

            public void handleEvent(Event e) {
                checkAdditionPad();
            }
        });
        this.additionalNumpad = new AdditionalNumpad(parent, inputField);
    }

    public void checkAdditionPad() {
        if(!isEnabled) {
            additionalNumpad.show();
            this.isEnabled = true;
        } else {
            additionalNumpad.hide();
            this.isEnabled = false;
        }
    }

}