import java.util.Stack;

public class TransactionHistory {
    private Stack<String> stack = new Stack<>();

    public void saveTransaction(String passengerName) {
        stack.push(passengerName);
        System.out.println("Transaction saved.");
    }

    public String undoTransaction() {
        if (stack.isEmpty()) {
            System.out.println("No transactions to undo.");
            return null;
        }
        String undone = stack.pop();
        System.out.println("Undo transaction for passenger: " + undone);
        return undone;
    }
}