import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class ScheduleManager {

    // ── Data Structure ────────────────────────────────────────
    private LinkedList<Schedule> schedules;

    // Constructor
    public ScheduleManager() {
        this.schedules = new LinkedList<>();
    }

    // ════════════════════════════════════════════════════════
    // 1. ADD FIRST / ADD LAST
    // ════════════════════════════════════════════════════════

    // Tambah jadwal di awal list (untuk keberangkatan mendadak / prioritas)
    public void addFirst(String trainCode, String trainName, String origin,
                         String destination, String departureTime, double baseFare) {
        Schedule s = new Schedule(trainCode, trainName, origin, destination, departureTime, baseFare);
        schedules.addFirst(s);
        System.out.println("[+] Schedule added to FIRST: " + s.getTrainName()
                + " (ID: " + s.getScheduleId() + ")");
    }

    // Tambah jadwal di akhir list (untuk jadwal mendatang)
    public void addLast(String trainCode, String trainName, String origin,
                        String destination, String departureTime, double baseFare) {
        Schedule s = new Schedule(trainCode, trainName, origin, destination, departureTime, baseFare);
        schedules.addLast(s);
        System.out.println("[+] Schedule added to LAST : " + s.getTrainName()
                + " (ID: " + s.getScheduleId() + ")");
    }

    // ════════════════════════════════════════════════════════
    // 2. REMOVE FIRST / REMOVE LAST
    // ════════════════════════════════════════════════════════

    // Hapus jadwal pertama (keberangkatan sudah selesai)
    public void removeFirst() {
        if (schedules.isEmpty()) {
            System.out.println("[!] Schedule list is empty.");
            return;
        }
        Schedule removed = schedules.removeFirst();
        System.out.println("[-] Removed FIRST schedule: " + removed.getTrainName()
                + " (ID: " + removed.getScheduleId() + ")");
    }

    // Hapus jadwal terakhir (batalkan jadwal paling akhir)
    public void removeLast() {
        if (schedules.isEmpty()) {
            System.out.println("[!] Schedule list is empty.");
            return;
        }
        Schedule removed = schedules.removeLast();
        System.out.println("[-] Removed LAST schedule : " + removed.getTrainName()
                + " (ID: " + removed.getScheduleId() + ")");
    }

    // ════════════════════════════════════════════════════════
    // 3. SEARCH BY ORIGIN OR DESTINATION
    // ════════════════════════════════════════════════════════
    public List<Schedule> searchRoutes(String keyword) {
        List<Schedule> results = new ArrayList<>();
        // Gunakan Iterator untuk traversal
        Iterator<Schedule> it = schedules.iterator();
        while (it.hasNext()) {
            Schedule s = it.next();
            boolean matchOrigin      = s.getOrigin().toLowerCase().contains(keyword.toLowerCase());
            boolean matchDestination = s.getDestination().toLowerCase().contains(keyword.toLowerCase());
            if (matchOrigin || matchDestination) {
                results.add(s);
            }
        }
        return results;
    }

    // ════════════════════════════════════════════════════════
    // 4. ITERATOR TRAVERSAL — tampilkan semua jadwal
    // ════════════════════════════════════════════════════════
    public void displayAll() {
        if (schedules.isEmpty()) {
            System.out.println("[!] No schedules available.");
            return;
        }

        // Header tabel
        System.out.println("\n╔══════╦══════════╦══════════════════════╦══════════════════╦══════════════════╦══════════╦═══════════════╗");
        System.out.printf( "║ %-4s ║ %-8s ║ %-20s ║ %-16s ║ %-16s ║ %-8s ║ %-13s ║%n",
                "ID", "Code", "Train Name", "Origin", "Destination", "Depart", "Fare (Rp)");
        System.out.println("╠══════╬══════════╬══════════════════════╬══════════════════╬══════════════════╬══════════╬═══════════════╣");

        // Gunakan Iterator (sesuai requirement modul)
        Iterator<Schedule> it = schedules.iterator();
        while (it.hasNext()) {
            Schedule s = it.next();
            System.out.printf("║ %-4d ║ %-8s ║ %-20s ║ %-16s ║ %-16s ║ %-8s ║ %,13.0f ║%n",
                    s.getScheduleId(),
                    s.getTrainCode(),
                    s.getTrainName(),
                    s.getOrigin(),
                    s.getDestination(),
                    s.getDepartureTime(),
                    s.getBaseFare());
        }
        System.out.println("╚══════╩══════════╩══════════════════════╩══════════════════╩══════════════════╩══════════╩═══════════════╝");
        System.out.println("  Total schedules: " + schedules.size());
    }

    // ════════════════════════════════════════════════════════
    // 5. CLEANUP — hapus jadwal tertentu via Iterator
    //    (menghindari ConcurrentModificationException)
    // ════════════════════════════════════════════════════════
    public void cleanupByTrainCode(String trainCode) {
        Iterator<Schedule> it = schedules.iterator();
        int count = 0;
        while (it.hasNext()) {
            Schedule s = it.next();
            if (s.getTrainCode().equalsIgnoreCase(trainCode)) {
                it.remove(); // aman: pakai iterator.remove(), bukan list.remove()
                System.out.println("[-] Cleaned up: " + s.getTrainName()
                        + " (" + s.getTrainCode() + ", ID: " + s.getScheduleId() + ")");
                count++;
            }
        }
        if (count == 0) {
            System.out.println("[!] No schedule found with train code: " + trainCode);
        } else {
            System.out.println("[✓] Total removed: " + count + " schedule(s).");
        }
    }

    // ── Helper: total schedules ───────────────────────────────
    public int getTotalSchedules() {
        return schedules.size();
    }
}