package binarytree;

public class Node {
    public char data;
    public Node left;
    public Node right;
    Node link;

    public Node(char data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }

    Node(char c, Node left, Node right) {
        this.data = c;
        this.left = left;
        this.right = right;
    }
}