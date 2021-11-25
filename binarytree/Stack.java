package binarytree;

public class Stack {
    int stackLength;
    public int top = -1;
    char stack[];

    // To intialize the stack Length
    public Stack(int stackLength) {
        this.stackLength = stackLength;
        stack = new char[stackLength];
    }

    // Push operation
    public void push(char num) {
        if (isStackFull()) {
            System.out.println("Stack index exceeded!!!");
            System.exit(0);
        } else {
            top++;
            stack[top] = num;
        }

    }

    // Pop operation
    public char pop() {
        if (isStackEmpty()) {
            System.out.println("Nothing to remove!!");
            System.exit(0);
        } else {
            char stackNumber;
            stackNumber = stack[top];
            stack[top] = 0;
            top--;
            return stackNumber;
        }
        return 0;
    }

    // To check if the stack is Full
    public boolean isStackFull() {
        if (top == stackLength - 1)
            return true;
        else
            return false;
    }

    // To check if the stack is empty
    public boolean isStackEmpty() {
        if (top == -1)
            return true;
        else
            return false;
    }

    // To check the top-most element of the stack
    public char seeTop() {
        return stack[top];
    }

    // To display the whole stack
    public void displayAll() {
        System.out.println("\nOperators present in stack ");
        for (char n : stack) {
            if (n == '\0')
                continue;
            System.out.print("| " + n + " ");
        }
        System.out.print("|\n");
    }
}
