import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.print("Masukkan ekspresi infix: ");
            String infix = sc.nextLine();

            // Panggil kelas ExpressionConverter untuk konversi
            String postfix = ExpressionConverter.infixToPostfix(infix);
            
            // Panggil kelas ExpressionEvaluator untuk hitung hasil
            double result = ExpressionEvaluator.evaluatePostfix(postfix);

            System.out.println("Infix   : " + infix);
            System.out.println("Postfix : " + postfix);

            // Format hasil: kalau bulat, tampilkan tanpa desimal
            if (result == (long) result) {
                System.out.println("Result  : " + (long) result);
            } else {
                System.out.println("Result  : " + result);
            }
            System.out.println();
        }
    }
}