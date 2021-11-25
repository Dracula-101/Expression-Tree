package binarytree;

public class StackUsingLL {
    Node top;

    // Constructor
    public StackUsingLL() {
        this.top = null;
    }

    public void push(Node temp) {
        temp.link = top;
        top = temp;
        display();
    }

    public boolean isEmpty() {
        return top == null;
    }

    public Node peek() {
        if (!isEmpty()) {
            return top;
        } else {
            return null;
        }
    }

    public Node pop() {
        if (top == null) {
            System.out.print("\nStack Underflow");
            return null;
        }

        top = top.link;
        return top;
    }

    public void display() {
        if (top == null) {
            System.out.print("\nStack Underflow");
            return;
        } else {
            System.out.print("\nStack Status: \n");
            Node temp = top;
            while (temp != null) {

                System.out.print("| " + temp.data + " ");

                temp = temp.link;
            }
        }
        System.out.println("|");
    }
}
