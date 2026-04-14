public class Main {
    // --- Main Method untuk menjalankan simulasi ---
    public static void main(String[] args) {
        GrandLineNavigation logPose = new GrandLineNavigation();

        // Menyusun rute
        logPose.addIsland("Alabasta");
        logPose.addIsland("Skypiea");
        logPose.addIsland("Water 7");
        logPose.addIsland("Enies Lobby");

        // Menampilkan logbook awal
        logPose.printLogbook();

        // Mengecek Fishman Island
        System.out.println("Visited Fishman Island? " + logPose.isIslandOnRoute("Fishman Island"));

        // Mengaktifkan Buster Call di Enies Lobby
        System.out.println("Buster Call initiated on Enies Lobby!");
        logPose.busterCall("Enies Lobby");

        // Menampilkan logbook setelah Enies Lobby dihapus
        logPose.printLogbook();

        // Menghitung total pulau yang tersisa
        System.out.println("Total Islands visited: " + logPose.countIslands());
    }
}