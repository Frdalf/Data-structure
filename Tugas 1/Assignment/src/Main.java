import java.util.Scanner;

public class Main {

    // 4. Method utilizing Wildcards <?>
    public static void displayTicketInfo(TrainTicket<?, ?> ticket) {
        System.out.println("\n=== Ticket Information ===");
        System.out.println("Booking Code      : " + ticket.getBookingCode());
        System.out.println("Passenger Name    : " + ticket.getPassenger().getName());
        // Mengambil tipe data asli dari generic parameter
        System.out.println("Identity Type     : " + ticket.getPassenger().getIdentityNumber().getClass().getSimpleName());
        System.out.println("Identity Number   : " + ticket.getPassenger().getIdentityNumber());
        System.out.println("Ticket Class      : " + ticket.getTicketClass());
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Railway Ticket Booking ===");

        System.out.print("Enter Passenger Name: ");
        String name = scanner.nextLine();

        System.out.print("Enter Identity Number: ");
        int identityNumber = scanner.nextInt();
        scanner.nextLine(); // Consume newline left-over

        System.out.print("Enter Booking Code: ");
        String bookingCode = scanner.nextLine();

        System.out.println("\nSelect Ticket Class:");
        System.out.println("1. ECONOMY");
        System.out.println("2. BUSINESS");
        System.out.println("3. EXECUTIVE");
        System.out.print("Enter choice: ");
        int choice = scanner.nextInt();

        TicketClass selectedClass;
        switch (choice) {
            case 1:
                selectedClass = TicketClass.ECONOMY;
                break;
            case 2:
                selectedClass = TicketClass.BUSINESS;
                break;
            case 3:
                selectedClass = TicketClass.EXECUTIVE;
                break;
            default:
                selectedClass = TicketClass.ECONOMY; // Default fallback
                break;
        }

        // Instansiasi objek dengan tipe spesifik
        Passenger<Integer> passenger = new Passenger<>(name, identityNumber);
        TrainTicket<String, Integer> ticket = new TrainTicket<>(bookingCode, passenger, selectedClass);

        // Memanggil wildcard method
        displayTicketInfo(ticket);

        scanner.close();
    }
}