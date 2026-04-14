import java.util.List;

public class MainSchedule {
    public static void main(String[] args) {

        ScheduleManager manager = new ScheduleManager();

        // ────────────────────────────────────────────────────
        // 1. ADD LAST — Jadwal normal (antri di akhir)
        // ────────────────────────────────────────────────────
        printSection("1. ADD SCHEDULES (addLast)");
        manager.addLast("TRN001", "Argo Bromo Anggrek", "Surabaya Pasar Turi", "Jakarta Gambir",  "07:00", 350000);
        manager.addLast("TRN002", "Bima Express",       "Surabaya Gubeng",     "Bandung",          "09:30", 275000);
        manager.addLast("TRN003", "Gajayana",           "Malang",              "Jakarta Gambir",   "11:00", 300000);
        manager.addLast("TRN004", "Sancaka",            "Surabaya Gubeng",     "Yogyakarta",       "14:00", 175000);
        manager.displayAll();

        // ────────────────────────────────────────────────────
        // 1b. ADD FIRST — Jadwal mendadak/prioritas di awal
        // ────────────────────────────────────────────────────
        printSection("1b. ADD URGENT SCHEDULE (addFirst)");
        manager.addFirst("TRN000", "Sembrani Ekspres", "Jakarta Gambir", "Surabaya Pasar Turi", "06:00", 400000);
        manager.displayAll();

        // ────────────────────────────────────────────────────
        // 2a. REMOVE FIRST — Keberangkatan pertama sudah selesai
        // ────────────────────────────────────────────────────
        printSection("2a. REMOVE FIRST (keberangkatan sudah selesai)");
        manager.removeFirst();
        manager.displayAll();

        // ────────────────────────────────────────────────────
        // 2b. REMOVE LAST — Batalkan jadwal paling akhir
        // ────────────────────────────────────────────────────
        printSection("2b. REMOVE LAST (batalkan jadwal terakhir)");
        manager.removeLast();
        manager.displayAll();

        // ────────────────────────────────────────────────────
        // 3. SEARCH BY ORIGIN OR DESTINATION
        // ────────────────────────────────────────────────────
        printSection("3. SEARCH ROUTES (keyword: \"surabaya\")");
        List<Schedule> results = manager.searchRoutes("surabaya");
        if (results.isEmpty()) {
            System.out.println("  No schedules found.");
        } else {
            System.out.println("  Found " + results.size() + " schedule(s):");
            for (Schedule s : results) s.displayInfo();
        }

        // ────────────────────────────────────────────────────
        // 3b. SEARCH BY DESTINATION
        // ────────────────────────────────────────────────────
        printSection("3b. SEARCH ROUTES (keyword: \"jakarta\")");
        List<Schedule> results2 = manager.searchRoutes("jakarta");
        if (results2.isEmpty()) {
            System.out.println("  No schedules found.");
        } else {
            System.out.println("  Found " + results2.size() + " schedule(s):");
            for (Schedule s : results2) s.displayInfo();
        }

        // ────────────────────────────────────────────────────
        // 4. ITERATOR TRAVERSAL (sudah diimplementasi di displayAll)
        //    Tambah beberapa jadwal dulu untuk demo cleanup
        // ────────────────────────────────────────────────────
        printSection("4. ADD MORE SCHEDULES BEFORE CLEANUP");
        manager.addLast("TRN002", "Bima Express",   "Jakarta Gambir", "Surabaya Gubeng", "20:00", 275000);
        manager.addLast("TRN002", "Bima Express",   "Surabaya Gubeng","Jakarta Gambir",  "22:00", 275000);
        manager.addLast("TRN005", "Tawang Jaya",    "Semarang Tawang","Jakarta Pasar Senen", "08:00", 150000);
        manager.displayAll();

        // ────────────────────────────────────────────────────
        // 5. CLEANUP — Hapus semua jadwal dengan kode TRN002
        //    menggunakan Iterator (hindari ConcurrentModificationException)
        // ────────────────────────────────────────────────────
        printSection("5. CLEANUP by Train Code \"TRN002\" (via Iterator.remove())");
        manager.cleanupByTrainCode("TRN002");
        manager.displayAll();

        // ────────────────────────────────────────────────────
        // FINAL STATE
        // ────────────────────────────────────────────────────
        printSection("FINAL SCHEDULE LIST");
        manager.displayAll();
        System.out.println("\n========================================");
        System.out.println("  Total active schedules: " + manager.getTotalSchedules());
        System.out.println("========================================\n");
    }

    private static void printSection(String title) {
        System.out.println("\n========================================");
        System.out.println("  " + title);
        System.out.println("========================================");
    }
}