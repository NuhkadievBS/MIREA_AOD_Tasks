package task_4;

import java.util.Scanner;

public class AVLTree {
    Node root; // Корень дерева

    // метод возращает высоту узла, иначе возвращает 0
    int height(Node p) {
        if (p != null)
            return p.height;
        return 0;
    }

    // метод высчитывает баланс узла: balance = h(left) - h(right)
    int balanceFactor(Node p) {
        return height(p.right) - height(p.left);
    }

    // Метод обновляет значение высот у каждого из узлов
    void fixHeight(Node p) {
        int hl = height(p.left);
        int hr = height(p.right);
        p.height = (Math.max(hl, hr)) + 1;
    }


    Node rotateRight(Node p) // правый поворот вокруг p
    {
        Node q = p.left;
        p.left = q.right;
        q.right = p;
        fixHeight(p);
        fixHeight(q);
        return q;
    }

    Node rotateLeft(Node q) // левый поворот вокруг q
    {
        Node p = q.right;
        q.right = p.left;
        p.left = q;
        fixHeight(q);
        fixHeight(p);
        return p;
    }

    Node balance(Node p) // балансировка узла p
    {
        fixHeight(p);
        if (balanceFactor(p) == 2) {
            if (balanceFactor(p.right) < 0)
                p.right = rotateRight(p.right);
            return rotateLeft(p);
        }
        if (balanceFactor(p) == -2) {
            if (balanceFactor(p.left) > 0)
                p.left = rotateLeft(p.left);
            return rotateRight(p);
        }
        return p; // балансировка не нужна
    }

    Node insert(Node p, String k) // вставка ключа k в дерево с корнем p
    {
        if (p == null) return new Node(k);
        int c = p.value.compareToIgnoreCase(k);
        if (c > 0) {
            p.left = insert(p.left, k);
        } else
            p.right = insert(p.right, k);
        return balance(p);
    }

    // Метод поиска длины от корня до узла
    int pathLength(Node node, String value, int count) {

        // Сравниваем значение текущего узла и введенного значения
        int cmp = value.compareTo(node.value);

        if (cmp < 0) return pathLength(node.left, value, count + 1);

        // Dig into right subtree.
        if (cmp > 0) return pathLength(node.right, value, count + 1);

        return count;
    }

    // Симметричный обход
    void inOrder(Node node) {
        if(node == null) return;
        inOrder(node.left);
        System.out.println(node.value);
        inOrder(node.right);
    }

    // Обратный обход
    void postOrder(Node node) {
        if(node == null) return;
        postOrder(node.left);
        postOrder(node.right);
        System.out.println(node.value);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Node root = new Node("Moscow");
        AVLTree tree = new AVLTree();
        root = tree.insert(root, "Washington");
        root = tree.insert(root, "Sidney");
        root = tree.insert(root, "Kyiv");
        root = tree.insert(root, "Saransk");
        root = tree.insert(root, "Paris");
        root = tree.insert(root, scanner.nextLine());
        System.out.println(TreePrinter.getTreeDisplay(root));

        System.out.println("Высота дерева = " + tree.height(root));
        System.out.println("Длина до узла = " + tree.pathLength(root, scanner.nextLine(), 0));

        System.out.println("\nОбратный обход дерева");
        tree.postOrder(root);
        System.out.println("\nСимметричный обход дерева");
        tree.inOrder(root);
    }
}
