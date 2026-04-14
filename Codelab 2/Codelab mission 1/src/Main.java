import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        // 1. Declaration: Membuat ArrayList untuk menyimpan nama penyihir
        ArrayList<String> students = new ArrayList<>();

        // 2. Recruitment: Menambahkan Itadori, Fushiguro, dan Kugisaki di akhir list
        students.add("Itadori");
        students.add("Fushiguro");
        students.add("Kugisaki");
        System.out.println("First Years Assembled: " + students);

        // 3. Transfer Student: Menyisipkan Yuta Okkotsu di awal list (indeks 0)
        students.add(0, "Okkotsu");
        System.out.println("After Yuta joins: " + students);

        // 4. Identification: Mengambil data siswa di indeks ke-2
        System.out.println("Student at index 2 is: " + students.get(2));

        // 5. Possession: Mengubah "Itadori" (yang sekarang di indeks 1) menjadi "Ryomen Sukuna"
        students.set(1, "Ryomen Sukuna");
        System.out.println("Oh no, Itadori switched!: " + students);

        // 6. Casualties: Menghapus Kugisaki dari list (Kugisaki berada di indeks 3)
        students.remove(3);
        System.out.println("After the Shibuya Incident: " + students);

        // 7. Report: Mengecek jumlah siswa dan apakah list kosong
        System.out.println("Remaining students: " + students.size());
        if (!students.isEmpty()) {
            System.out.println("The fight continues!");
        }

        // 8. Total Wipeout: Menghapus seluruh isi list
        students.clear();
        System.out.println("Post-Culling Game Status: " + students);
    }
}