import java.util.*;
import java.util.Stack;
import binarytree.*;

public class expTree {

    public static boolean istreeNode(char c) {
        return (c == '+' || c == '-' || c == '*' || c == '/' || c == '^');
    }

    public void preorder(Node root) {
        if (root == null) {
            return;
        }
        preorder(root.left);
        preorder(root.right);
        System.out.print(root.data);
    }

    public void inorder(Node root) {
        if (root == null) {
            return;
        }

        if (istreeNode(root.data)) {
            System.out.print("(");
        }

        inorder(root.left);
        System.out.print(root.data);
        inorder(root.right);

        if (istreeNode(root.data)) {
            System.out.print(")");
        }
    }

    public Node makePrefix(String prefix) {
        if (prefix == null || prefix.length() == 0) {
            return null;
        }
        Stack<Node> s = new Stack<>();
        StackUsingLL stack = new StackUsingLL();

        char c;
        Node treeNode = null;
        for (int i = prefix.length() - 1; i >= 0; i--) {

            c = prefix.charAt(i);
            if (isDigit(c) || isCharacter(c)) {
                treeNode = new Node(c);
                s.push(treeNode);
                stack.push(treeNode);
                // stack.display();

            } else if (istreeNode(c)) {
                treeNode = new Node(c);
                treeNode.left = s.pop();
                treeNode.right = s.pop();

                stack.pop();
                stack.pop();

                s.push(treeNode);
                stack.push(treeNode);
                stack.display();

            }
        }
        treeNode = (Node) s.peek();
        s.pop();
        return treeNode;
    }

    public int findDigit(char ch) {
        return ch - '0';
    }

    public boolean isDigit(char ch) {
        if (ch >= '0' && ch <= '9')
            return true;
        return false;
    }

    public boolean isCharacter(char ch) {
        return (ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z');
    }

    public double evaluateTree(Node node) {
        if (node.left == null && node.right == null)
            return findDigit(node.data);
        else {
            double result = 0.0;
            double left = evaluateTree(node.left);
            double right = evaluateTree(node.right);
            char treeNode = node.data;

            switch (treeNode) {
            case '+':
                result = left + right;
                break;
            case '-':
                result = left - right;
                break;
            case '*':
                result = left * right;
                break;
            case '/':
                result = left / right;
                break;
            default:
                result = left + right;
                break;
            }
            return result;
        }
    }

    public boolean checkNumber(String prefix) {
        for (char c : prefix.toCharArray()) {
            if (isDigit(c)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the expression in prefix form: ");
        String prefix = input.next();

        expTree tree = new expTree();
        Node root = tree.makePrefix(prefix);
        BinaryTree newTree = new BinaryTree();

        System.out.print("\nPrefix Expression: ");
        newTree.printPreorder(root);

        System.out.print("\nInfix Expression: ");
        tree.inorder(root);
        if (tree.checkNumber(prefix)) {
            double result = tree.evaluateTree(root);
            System.out.print("\nThe evaluation of the binary tree: " + result);
            input.close();
        }
    }
}
// *+ab-cd

// Infix
// A+B/C*(D-A)^F^H

// prefix
// +A/B*C^-DA^FH