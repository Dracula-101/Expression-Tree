package binarytree;

public class BinaryTree {
    Node root;
    int elements, counter;

    public void insert(char data) {
        Node newNode = new Node(data);
        if (root == null) {
            root = newNode;
            elements++;
            System.out.println(data + " is the Root of the BST\n");
            return;
        } else {
            Node current = root;
            Node parent = null;
            elements++;
            while (true) {
                parent = current;
                if (data < current.data) {
                    current = current.left;
                    if (current == null) {
                        parent.left = newNode;
                        System.out.println("Parent Node= " + parent.data + " Inserted Left\n");
                        return;
                    }
                } else {
                    current = current.right;
                    if (current == null) {
                        parent.right = newNode;
                        System.out.println("Parent Node= " + parent.data + " Inserted Right\n");
                        return;
                    }
                }
            }
        }
    }

    public Node getMinimumValue(Node curr) {
        while (curr.left != null) {
            curr = curr.left;
        }
        return curr;
    }

    public int maxDepth(Node node) {
        if (node == null)
            return 0;
        else {

            int leftDepth = maxDepth(node.left);
            int rightDepth = maxDepth(node.right);

            if (leftDepth > rightDepth)
                return (leftDepth + 1);
            else
                return (rightDepth + 1);
        }
    }

    void printPostorder(Node node) {
        if (node == null)
            return;

        printPostorder(node.left);
        printPostorder(node.right);
        System.out.print(node.data + " ");
    }

    public void printPreorder(Node node) {
        if (node == null)
            return;

        System.out.print(node.data + " ");
        printPreorder(node.left);
        printPreorder(node.right);
    }

    void inorderRec(Node root) {
        if (root != null) {
            inorderRec(root.left);
            if (counter < elements)
                System.out.print(root.data + "->");
            inorderRec(root.right);
        }
    }

    public void lvlOrder(Node node) {
        if (node == null) {
            return;
        }
        for (int i = 0; i <= maxDepth(root); i++) {
            printAtLvl(node, i + 1);
            System.out.println();
        }
    }

    public void printAtLvl(Node node, int level) {
        if (node == null) {
            return;
        }
        if (level == 1) {
            System.out.print(node.data + " ");
            return;
        }
        printAtLvl(node.left, level - 1);
        printAtLvl(node.right, level - 1);
    }

    public void printPostorderofExpTree(String root2) {
        System.out.print(root2);
    }
}
