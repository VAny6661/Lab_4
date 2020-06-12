package actions;

import java.util.Collections;
import java.util.List;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.*;

import converter.InfixToPostfix;

public class CreateTree{

    private  CreateTree createdTree;

    public  CreateTree getTree() {
        return createdTree;
    }

    public  void clearTree() {
        createdTree.tree.removeAll();
    }
    
    private  Composite parent;
    private  Tree tree;
    

    public CreateTree(Composite parent) {
        this.parent = parent;
        this.tree = new Tree(parent, SWT.BORDER | SWT.MULTI);
        tree.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 3, 1));
        this.createdTree = this;
    }

    public  boolean changeTreeState(ActionText text) {
        String input = text.getTextField().getText().getText();
        var operands = InfixToPostfix.Convert(input);
        Collections.reverse(operands);

        tree.removeAll();
        if(operands.size() > 1) {
            createTree(operands, tree, 2, null);
        }
        if(operands.size() == 1){
            TreeItem child = new TreeItem(tree, SWT.NONE);
            child.setExpanded(true);
            child.setText(operands.get(0));
            operands.remove(0);
        }
        return false;
    }

    private  List<String> createTree(List<String> operands, Tree root, int childrenLimit, TreeItem parent) {
        int limit = 0;
        if(operands.size()>0 && operands.get(operands.size()-1).equals("-")){
            operands.set(operands.size()-2, "-" + operands.get(operands.size()-2));
            operands.remove(operands.size()-1);
        }
        while(!operands.isEmpty()) {
            var operand = operands.get(0);
            switch(operand) {
                case "+":
                case "-":
                case "*":
                case "/":
                case "^":
                case "%":
                {
                    TreeItem child;
                    if(parent == null) {
                        child = new TreeItem(root, SWT.NONE);
                        child.setExpanded(true);
                        child.setText(operand);
                        operands.remove(operand);
                        operands = createTree(operands, root, 2, child);
                        parent = child;
                        limit++;
                    }
                    else {
                        child = new TreeItem(parent, SWT.NONE);
                        child.setExpanded(true);
                        child.setText(operand);
                        operands.remove(operand);
                        limit++;
                        operands = createTree(operands, root, 2, child);
                    }
                }
                break;
                case "√":
                {
                    TreeItem child;
                    if(parent == null) {
                        child = new TreeItem(root, SWT.NONE);
                        child.setExpanded(true);
                        switch(operand) {
                            case "√":
                            child.setText("√");
                            break;
                        }
                        operands.remove(operand);
                        operands = createTree(operands, root, 1, child);
                        parent = child;
                        limit++;
                    }
                    else {
                        child = new TreeItem(parent, SWT.NONE);
                        child.setExpanded(true);
                        switch(operand) {
                            case "√":
                            child.setText("√");
                            break;
                        }
                        operands.remove(operand);
                        limit++;
                        operands = createTree(operands, root, 1, child);
                    }
                }
                break;
                default:
                {
                    if(limit < childrenLimit) {
                        if(parent == null){
                            if(operands.size() == 1){
                                TreeItem child = new TreeItem(root, SWT.NONE);
                                child.setExpanded(true);
                                child.setText(operand);
                                operands.remove(operand);
                                limit = childrenLimit;
                                break;
                            }
                                TreeItem child = new TreeItem(root, SWT.NONE);
                                child.setExpanded(true);
                                child.setText(operand);
                                operands.remove(operand);
                                operands = createTree(operands, root, 2, child);
                                parent = child;
                                limit++;
                                break;
                            }

                        TreeItem num = new TreeItem(parent, SWT.NONE);
                        num.setText(operand);
                        operands.remove(operand);
                        limit++;
                    }
                    if(limit >= childrenLimit) return operands;
                }
                break;
            }
        }
        return operands;
    }

    public void nextState(ActionText text) {
        changeTreeState(text);
    }

    public void previousState(ActionText text) {
        changeTreeState(text);
    }

    private void SelectTree(){
        tree.getSelection();
    }
}