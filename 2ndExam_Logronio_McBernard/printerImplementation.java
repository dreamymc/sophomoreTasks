import java.util.Stack;

public class printerImplementation extends printerAbstract {
    Stack<String> stack_enqueue = new Stack<>();
    Stack<String> stack_dequeue = new Stack<>();
    int papers;

    @Override
    public void addPaper(int x) {
        for (int i = 1; i <= x; i++)
            stack_enqueue.push("Paper " + (papers + i));
        for (int i = 1; i <= x; i++)
            papers++;
        System.out.println("Stack Enqueue: " + stack_enqueue);

    }

    @Override
    public boolean checkPrinter() {
        if (stack_dequeue.isEmpty() && !stack_enqueue.isEmpty())
            return true;
        else
            return false;
    }

    @Override
    public void proceedQueue() {
        if (stack_dequeue.isEmpty() && !stack_enqueue.isEmpty()) {
            while (!stack_enqueue.isEmpty())
                stack_dequeue.push(stack_enqueue.pop());
            System.out.println("Stack Dequeue" + stack_dequeue);
        } else {
            System.out.println("There are no papers present in the printer.");
        }
    }

    @Override
    public void print() {
        proceedQueue();
        while (!stack_dequeue.isEmpty())
            System.out.println("Printed: " + stack_dequeue.pop());
        papers = 0;
    }

}
