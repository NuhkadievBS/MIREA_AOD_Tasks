package task_4;

public class AVLTree {
    Node root;

    public AVLTree(Node root) {
        this.root = root;
    }

    public boolean insert(String value) {
        if(value == null)
            return false;
        insert(root, value);
        return true;
    }

    private void insert(Node node, String value) {
        int cmp = value.compareTo(node.value);
        if(node == null)
            root = new Node(value);
        else {

            if (cmp < 0) {
                if (node.left == null && node.right == null) {
                    node.left = new Node(value);
                }
                else
                    insert(node.left, value);
            } else {
                if (node.left == null && node.right == null) {
                    node.right = new Node(value);
                }
                else
                    insert(node.right, value);
            }
        }


    }


    public static void main(String[] args) {
        AVLTree tree = new AVLTree(new Node("Hello"));
        tree.insert("world");
       // tree.insert("of");
        tree.insert("Hair");
        System.out.println(TreePrinter.getTreeDisplay(tree.root));
    }
}
