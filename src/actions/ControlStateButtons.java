package actions;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;

public class ControlStateButtons{

    private String value;
    private Button button;


    public ControlStateButtons(Composite parent, String value, ActionText text, CreateTree tree) {
        this.value = value;
        this.button = new Button(parent, SWT.PUSH);
        button.setText(value);
        button.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
        button.addListener(SWT.MouseDown, new Listener(){

            public void handleEvent(Event e) {
                changeTreeState(text, tree);
            }
        });
    }

    public void changeTreeState(ActionText text, CreateTree tree) {
        switch(value) {
            case "<":
            {
                previousState(text, tree);
            }
            break;
            case ">":
            {
                nextState(text, tree);
            }
            break;
            default:
            break;
        }
    }

    public void nextState(ActionText text, CreateTree tree) {
        text.getTextField().nextState();
        tree.getTree().nextState(text);
    }

    public void previousState(ActionText text, CreateTree tree) {
        text.getTextField().previousState();
        tree.getTree().previousState(text);
    }

}