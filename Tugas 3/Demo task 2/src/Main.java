import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        QueueService queueService = new QueueService();
        TransactionHistory history = new TransactionHistory();

        while (true) {
            System.out.println("\n=== Railway Ticket Service ===");
            System.out.println("1. Add Passenger");
            System.out.println("2. Display Queue");
            System.out.println("3. Serve Passenger");
            System.out.println("4. Undo Last Transaction");
            System.out.print("Choose menu: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter passenger name: ");
                    String name = sc.nextLine();
                    queueService.addPassenger(name);
                    break;
                case 2:
                    queueService.displayQueue();
                    break;
                case 3:
                    String served = queueService.servePassenger();
                    if (served != null) {
                        history.saveTransaction(served);
                    }
                    break;
                case 4:
                    String undone = history.undoTransaction();
                    if (undone != null) {
                        queueService.requeue(undone);
                    }
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}