import java.util.ArrayList;
import java.util.List;

import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;

import actions.InputButtonAction;

public class AdditionalNumpad {

    private Text inputField;
    private Composite parent;
    private List<InputButtonAction> buttons = new ArrayList<>();
    private Point prevSize;

    public AdditionalNumpad(Composite parent, Text inputField) {
        this.parent = parent;
        this.inputField = inputField;
    }

    public void show() {
        buttons.add(new InputButtonAction(inputField, "^", parent));
        buttons.add(new InputButtonAction(inputField, "^2", parent));
        buttons.add(new InputButtonAction(inputField, "^3", parent));
        buttons.add(new InputButtonAction(inputField, "10^", parent));
        buttons.add(new InputButtonAction(inputField, "√", parent));
        this.prevSize = parent.getSize();
        parent.pack();
        parent.setSize(prevSize);
    }

    public void hide() {
        for(int i = 0; i < buttons.size(); i++) {
            buttons.get(i).DisposeButton();
        }
        buttons.clear();
        parent.pack();
        parent.setSize(prevSize);
    }
}