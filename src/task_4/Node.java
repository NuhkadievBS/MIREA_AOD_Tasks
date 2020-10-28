package task_4;

public class Node implements TreePrinter.PrintableNode {

    // The value/data contained within the node.
    public String value;

    // The left and the right children of this node.
    public Node left, right;

    public Node(String value) {
        this.value = value;
    }

    @Override
    public TreePrinter.PrintableNode getLeft() {
        return left;
    }

    @Override
    public TreePrinter.PrintableNode getRight() {
        return right;
    }

    @Override
    public String getText() {
        return value.toString();
    }
}
