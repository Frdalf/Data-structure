import java.util.Stack;

public class ExpressionEvaluator {

    // Evaluasi postfix
    public static double evaluatePostfix(String postfix) {
        Stack<Double> stack = new Stack<>();
        String[] tokens = postfix.split("\\s+");

        for (String token : tokens) {
            // Kalau angka, push ke stack
            try {
                stack.push(Double.parseDouble(token));
            } catch (NumberFormatException e) {
                // Kalau operator, pop 2 operand lalu hitung
                if (stack.size() < 2) continue; // Safety check
                double b = stack.pop();
                double a = stack.pop();
                switch (token.charAt(0)) {
                    case '+': stack.push(a + b); break;
                    case '-': stack.push(a - b); break;
                    case '*': stack.push(a * b); break;
                    case '/': stack.push(a / b); break;
                }
            }
        }
        return stack.isEmpty() ? 0 : stack.pop();
    }
}
