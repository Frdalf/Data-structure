import java.util.Stack;

public class ExpressionConverter {

    // Cek precedence operator
    private static int precedence(char op) {
        if (op == '+' || op == '-') return 1;
        if (op == '*' || op == '/') return 2;
        return 0;
    }

    // Konversi infix -> postfix (Shunting-Yard)
    public static String infixToPostfix(String infix) {
        Stack<Character> stack = new Stack<>();
        StringBuilder output = new StringBuilder();

        for (int i = 0; i < infix.length(); i++) {
            char c = infix.charAt(i);

            // Skip spasi
            if (c == ' ') continue;

            // Angka (termasuk multi-digit)
            if (Character.isDigit(c)) {
                output.append(c);
                // Cek apakah digit berikutnya masih bagian dari angka yang sama
                while (i + 1 < infix.length() && Character.isDigit(infix.charAt(i + 1))) {
                    i++;
                    output.append(infix.charAt(i));
                }
                output.append(' ');

                // Kurung buka
            } else if (c == '(') {
                stack.push(c);

                // Kurung tutup
            } else if (c == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    output.append(stack.pop()).append(' ');
                }
                if (!stack.isEmpty()) stack.pop(); // buang '('

                // Operator
            } else if (c == '+' || c == '-' || c == '*' || c == '/') {
                while (!stack.isEmpty() && precedence(stack.peek()) >= precedence(c)) {
                    output.append(stack.pop()).append(' ');
                }
                stack.push(c);
            }
        }

        // Pop sisa operator di stack
        while (!stack.isEmpty()) {
            output.append(stack.pop()).append(' ');
        }

        return output.toString().trim();
    }
}
