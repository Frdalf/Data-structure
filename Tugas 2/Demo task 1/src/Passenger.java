public class Passenger {
    // Auto-increment counter (static = shared across all instances)
    private static int idCounter = 1;

    // Private fields
    private int passengerId;
    private String name;
    private String email;
    private String phone;
    private int age;

    // Constructor
    public Passenger(String name, String email, String phone, int age) {
        this.passengerId = idCounter++; // auto-increment
        this.name        = name;
        this.email       = email;
        this.phone       = phone;
        this.age         = age;
    }

    // ── Getters ──────────────────────────────────────────────
    public int    getPassengerId() { return passengerId; }
    public String getName()        { return name; }
    public String getEmail()       { return email; }
    public String getPhone()       { return phone; }
    public int    getAge()         { return age; }

    // ── Setters ──────────────────────────────────────────────
    public void setName(String name)   { this.name  = name; }
    public void setEmail(String email) { this.email = email; }
    public void setPhone(String phone) { this.phone = phone; }
    public void setAge(int age)        { this.age   = age; }

    // ── displayInfo() ─────────────────────────────────────────
    public void displayInfo() {
        System.out.println("┌─────────────────────────────────────┐");
        System.out.printf( "│  ID      : %-26d│%n", passengerId);
        System.out.printf( "│  Name    : %-26s│%n", name);
        System.out.printf( "│  Email   : %-26s│%n", email);
        System.out.printf( "│  Phone   : %-26s│%n", phone);
        System.out.printf( "│  Age     : %-26d│%n", age);
        System.out.println("└─────────────────────────────────────┘");
    }

    // ── toString() ────────────────────────────────────────────
    @Override
    public String toString() {
        return String.format("Passenger{id=%d, name='%s', email='%s', phone='%s', age=%d}",
                passengerId, name, email, phone, age);
    }
}