package actions;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Text;

public class ClearButtonAction {

    private Text inputField;
    private Button button;

    public ClearButtonAction(Text inputField, String value, Composite parent, CreateTree tree) {
        this.inputField = inputField;
        this.button = new Button(parent, SWT.PUSH);
        button.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
        button.setText(value);
        button.addListener(SWT.MouseDown, new Listener(){

            public void handleEvent(Event e) {
                clearInputField(tree);
            }
        });
    }

    public void clearInputField(CreateTree tree) {
        inputField.setText("");
        tree.clearTree();
    }

}