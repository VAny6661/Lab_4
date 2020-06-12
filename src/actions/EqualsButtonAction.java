package actions;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;

public class EqualsButtonAction {

    private String value;
    private Button button;

    private List<Object> listeners = new ArrayList<>();

    public EqualsButtonAction(String value, Composite parent, ActionText text, Calculation calc, CreateLabel label, CreateTree tree) {
        this.value = value;
        this.button = new Button(parent, SWT.PUSH);
        button.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
        button.setText(value);
        button.addListener(SWT.MouseDown, new Listener() {

            public void handleEvent(Event e) {
                getAnswer(text, calc, label, tree);
            }
        });
    }

    public void getAnswer(ActionText text, Calculation calc, CreateLabel label, CreateTree tree) {
        if (!text.getTextField().getText().getText().isEmpty()) {
            calc.makeCalculation(text);
            label.getAnswer(calc);
            text.preparingForCalculations();
            tree.changeTreeState(text);
        }
        listeners.clear();
    }

}