public class Passenger<T> {
    private String name;
    private T identityNumber; // T allows identity to be Integer, String, etc.

    public Passenger(String name, T identityNumber) {
        this.name = name;
        this.identityNumber = identityNumber;
    }

    public String getName() {
        return name;
    }

    public T getIdentityNumber() {
        return identityNumber;
    }
}
