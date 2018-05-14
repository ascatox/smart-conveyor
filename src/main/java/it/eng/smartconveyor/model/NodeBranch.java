package it.eng.smartconveyor.model;

/**
 * @author ascatox
 */
public class NodeBranch {

    private Node node;
    private int choice;


    public Node getNode() {
        return node;
    }

    public void setNode(Node node) {
        this.node = node;
    }

    public int getChoice() {
        return choice;
    }

    public void setChoice(int choice) {
        this.choice = choice;
    }
}
