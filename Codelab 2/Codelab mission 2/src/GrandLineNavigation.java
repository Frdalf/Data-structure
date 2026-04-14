public class GrandLineNavigation {
    Island head; // Titik awal rute (Head)

    // 2. Chart Course: Menambahkan pulau baru di akhir rantai (Tail)
    public void addIsland(String name) {
        Island newIsland = new Island(name);

        // Jika rute masih kosong, pulau ini jadi rute pertama
        if (head == null) {
            head = newIsland;
            return;
        }

        // Jika tidak, telusuri sampai pulau terakhir, lalu sambungkan
        Island current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = newIsland;
    }

    // 3. Buster Call: Menghapus pulau dari peta berdasarkan nama
    public void busterCall(String name) {
        // Jika pulau yang hancur adalah pulau pertama
        if (head != null && head.name.equals(name)) {
            head = head.next;
            return;
        }

        Island current = head;
        Island previous = null;

        // Cari pulau target
        while (current != null && !current.name.equals(name)) {
            previous = current;
            current = current.next;
        }

        // Jika pulaunya ketemu, putus rantainya dan sambungkan ke pulau berikutnya
        if (current != null) {
            previous.next = current.next;
        }
    }

    // 4. Logbook: Menelusuri (traversal) dan mencetak rute
    public void printLogbook() {
        Island current = head;
        System.out.print("Grand Line Route: ");

        while (current != null) {
            System.out.print(current.name + " -> ");
            current = current.next;
        }
        System.out.println("(End)");
    }

    // 5. Check: Mencari apakah suatu pulau ada di dalam rute
    public boolean isIslandOnRoute(String name) {
        Island current = head;
        while (current != null) {
            if (current.name.equals(name)) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    // 6. Adventure Count: Menghitung total pulau yang dikunjungi
    public int countIslands() {
        int count = 0;
        Island current = head;
        while (current != null) {
            count++;
            current = current.next;
        }
        return count;
    }
}
