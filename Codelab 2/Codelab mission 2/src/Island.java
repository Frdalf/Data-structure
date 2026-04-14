public class Island {
    String name;
    Island next; // Pointer ke pulau selanjutnya

    // Constructor
    public Island(String name) {
        this.name = name;
        this.next = null;
    }
}
