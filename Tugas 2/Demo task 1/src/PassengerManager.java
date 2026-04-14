import java.util.ArrayList;
import java.util.List;

public class PassengerManager {

    // ── Data Structure ────────────────────────────────────────
    private ArrayList<Passenger> passengers;

    // Constructor
    public PassengerManager() {
        this.passengers = new ArrayList<>();
    }

    // ── 1. Add Passenger ──────────────────────────────────────
    // Append a new Passenger to the end of the list
    public void addPassenger(String name, String email, String phone, int age) {
        Passenger p = new Passenger(name, email, phone, age);
        passengers.add(p);
        System.out.println("[+] Passenger added: " + p.getName() + " (ID: " + p.getPassengerId() + ")");
    }

    // ── 2. Get Passenger by Index ─────────────────────────────
    public Passenger getPassenger(int index) {
        if (index < 0 || index >= passengers.size()) {
            System.out.println("[!] Index out of range.");
            return null;
        }
        return passengers.get(index);
    }

    // ── 3. Search by Name (Linear Search) ────────────────────
    public List<Passenger> searchByName(String keyword) {
        List<Passenger> results = new ArrayList<>();
        for (int i = 0; i < passengers.size(); i++) {
            if (passengers.get(i).getName().toLowerCase().contains(keyword.toLowerCase())) {
                results.add(passengers.get(i));
            }
        }
        return results;
    }

    // ── 4. Update Passenger by Index ─────────────────────────
    public void updatePassenger(int index, String name, String email, String phone, int age) {
        if (index < 0 || index >= passengers.size()) {
            System.out.println("[!] Index out of range.");
            return;
        }
        Passenger p = passengers.get(index);
        p.setName(name);
        p.setEmail(email);
        p.setPhone(phone);
        p.setAge(age);
        System.out.println("[~] Passenger at index " + index + " updated successfully.");
    }

    // ── 5a. Remove by Index ───────────────────────────────────
    public void removeByIndex(int index) {
        if (index < 0 || index >= passengers.size()) {
            System.out.println("[!] Index out of range.");
            return;
        }
        Passenger removed = passengers.remove(index);
        System.out.println("[-] Removed passenger: " + removed.getName() + " (ID: " + removed.getPassengerId() + ")");
    }

    // ── 5b. Remove by Passenger ID ────────────────────────────
    public void removeById(int id) {
        for (int i = 0; i < passengers.size(); i++) {
            if (passengers.get(i).getPassengerId() == id) {
                Passenger removed = passengers.remove(i);
                System.out.println("[-] Removed passenger: " + removed.getName() + " (ID: " + removed.getPassengerId() + ")");
                return;
            }
        }
        System.out.println("[!] Passenger with ID " + id + " not found.");
    }

    // ── 6. Display All ────────────────────────────────────────
    public void displayAll() {
        if (passengers.isEmpty()) {
            System.out.println("[!] No passengers registered.");
            return;
        }

        // Table header
        System.out.println("\n╔══════╦══════════════════════╦══════════════════════════╦══════════════╦═════╗");
        System.out.printf( "║ %-4s ║ %-20s ║ %-24s ║ %-12s ║ %-3s ║%n",
                "ID", "Name", "Email", "Phone", "Age");
        System.out.println("╠══════╬══════════════════════╬══════════════════════════╬══════════════╬═════╣");

        for (Passenger p : passengers) {
            System.out.printf("║ %-4d ║ %-20s ║ %-24s ║ %-12s ║ %-3d ║%n",
                    p.getPassengerId(), p.getName(), p.getEmail(), p.getPhone(), p.getAge());
        }
        System.out.println("╚══════╩══════════════════════╩══════════════════════════╩══════════════╩═════╝");
        System.out.println("  Total passengers: " + passengers.size());
    }

    // ── Helper: get total count ───────────────────────────────
    public int getTotalPassengers() {
        return passengers.size();
    }
}