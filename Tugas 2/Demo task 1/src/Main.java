import java.util.List;

public class Main {
    public static void main(String[] args) {

        PassengerManager manager = new PassengerManager();

        // ────────────────────────────────────────────────────
        // 1. ADD PASSENGER
        // ────────────────────────────────────────────────────
        printSection("1. ADD PASSENGERS");
        manager.addPassenger("Farid Maulana", "farid@email.com", "081234567890", 20);
        manager.addPassenger("Budi Santoso", "budi@email.com", "082345678901", 35);
        manager.addPassenger("Citra Dewi", "citra@email.com", "083456789012", 28);
        manager.addPassenger("Dian Pratama", "dian@email.com", "084567890123", 42);
        manager.addPassenger("Eka Rahmat", "eka@email.com", "085678901234", 19);
        manager.displayAll();

        // ────────────────────────────────────────────────────
        // 2. GET PASSENGER BY INDEX
        // ────────────────────────────────────────────────────
        printSection("2. GET PASSENGER BY INDEX (index = 2)");
        Passenger p = manager.getPassenger(2);
        if (p != null)
            p.displayInfo();

        // ────────────────────────────────────────────────────
        // 3. SEARCH BY NAME
        // ────────────────────────────────────────────────────
        printSection("3. SEARCH BY NAME (keyword: \"budi\")");
        List<Passenger> found = manager.searchByName("budi");
        if (found.isEmpty()) {
            System.out.println("  No passengers found.");
        } else {
            System.out.println("  Found " + found.size() + " passenger(s):");
            for (Passenger r : found)
                r.displayInfo();
        }

        // ────────────────────────────────────────────────────
        // 4. UPDATE PASSENGER BY INDEX
        // ────────────────────────────────────────────────────
        printSection("4. UPDATE PASSENGER (index = 1)");
        System.out.println("  Before update:");
        manager.getPassenger(1).displayInfo();

        manager.updatePassenger(1,
                "Budi Santoso S.T.",
                "budi.updated@email.com",
                "089999999999",
                36);

        System.out.println("  After update:");
        manager.getPassenger(1).displayInfo();

        // ────────────────────────────────────────────────────
        // 5a. REMOVE BY INDEX
        // ────────────────────────────────────────────────────
        printSection("5a. REMOVE BY INDEX (index = 3)");
        manager.removeByIndex(3);
        manager.displayAll();

        // ────────────────────────────────────────────────────
        // 5b. REMOVE BY PASSENGER ID
        // ────────────────────────────────────────────────────
        printSection("5b. REMOVE BY PASSENGER ID (ID = 5)");
        manager.removeById(5);
        manager.displayAll();

        // ────────────────────────────────────────────────────
        // 6. DISPLAY ALL (final state)
        // ────────────────────────────────────────────────────
        printSection("6. FINAL PASSENGER LIST");
        manager.displayAll();

        System.out.println("\n========================================");
        System.out.println("  Total remaining passengers: " + manager.getTotalPassengers());
        System.out.println("========================================\n");
    }

    // Helper to print section headers
    private static void printSection(String title) {
        System.out.println("\n========================================");
        System.out.println("  " + title);
        System.out.println("========================================");
    }
}