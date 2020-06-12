import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

import actions.CreateLabel;
import actions.ActionText;
import actions.CreateTree;
import actions.Calculation;

public class Window {
    private Display display = new Display();
    private Shell shell = new Shell(display);

    public Window() {
        GridLayout layout = new GridLayout(7, true);
        shell.setBackground(display.getSystemColor(SWT.COLOR_BLUE));
        shell.setLayout(layout);
        shell.setSize(800, 400);
        
        CreateLabel answer = new CreateLabel(shell);
        
        ActionText input = new ActionText(shell);
        
        CreateTree tree = new CreateTree(shell);

        Calculation calculator = new Calculation();

        Numpad numpad = new Numpad(shell, SWT.BORDER, input, calculator, answer, tree);


    }

    public void startWindow() {
        shell.open();
        while(!shell.isDisposed()) {
            if(!display.readAndDispatch()) display.sleep();
        }
        display.dispose();
    }
}