import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {

        // ==========================================
        // BAGIAN 1: QUEUE DEMONSTRATION (FIFO)
        // ==========================================
        // Penumpang yang datang pertama akan dilayani pertama [cite: 441]

        // TODO 1: Inisialisasi Queue untuk antrian pelayanan [cite: 442]
        // Queue adalah interface, implementasinya menggunakan LinkedList [cite: 443]
        Queue<String> serviceQueue = new LinkedList<>();

        // TODO 2: Menambahkan penumpang ke antrian menggunakan add() [cite: 447]
        serviceQueue.add("Andi");
        serviceQueue.add("Titan");
        serviceQueue.add("Rapi");

        System.out.println("Initial Service Queue:");
        System.out.println(serviceQueue);

        // TODO 3: Melayani penumpang (mengambil dari depan antrian) menggunakan poll() [cite: 461]
        // poll() mengembalikan null jika queue kosong [cite: 464]
        String servedPassenger = serviceQueue.poll();

        System.out.println("Serving passenger: " + servedPassenger);
        System.out.println("Queue after serving:");
        System.out.println(serviceQueue);

        // TODO 4: Melihat elemen pertama tanpa menghapusnya [cite: 476]
        String nextPassenger = serviceQueue.peek();
        System.out.println("Next passenger to serve: " + nextPassenger);
        System.out.println();

        // ==========================================
        // BAGIAN 2: STACK DEMONSTRATION (LIFO)
        // ==========================================

        // TODO 1: Inisialisasi Stack [cite: 482]
        Stack<String> transactionHistory = new Stack<>();

        // TODO 2: Menambahkan transaksi menggunakan push() [cite: 483]
        transactionHistory.push("Transaction-1");
        transactionHistory.push("Transaction-2");
        transactionHistory.push("Transaction-3");

        System.out.println("Transaction History:");
        System.out.println(transactionHistory);

        // TODO 3: Undo (Mengambil transaksi terakhir/elemen teratas) [cite: 494]
        String lastTransaction = transactionHistory.pop();
        System.out.println("Undo last transaction: " + lastTransaction);

        System.out.println("Transaction History after undo:");
        System.out.println(transactionHistory);

        // TODO 4: Melihat transaksi teratas tanpa menghapus [cite: 501]
        String topTransaction = transactionHistory.peek();
        System.out.println("Current top transaction: " + topTransaction);

        // TODO 5: Mengecek apakah stack kosong menggunakan isEmpty() [cite: 506]
        if (transactionHistory.isEmpty()) {
            System.out.println("No transaction history.");
        } else {
            // Mengambil ukuran stack dengan size()
            System.out.println("Transaction history is not empty. Size: " + transactionHistory.size());
        }
    }
}