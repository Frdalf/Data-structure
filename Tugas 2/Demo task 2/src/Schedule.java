public class Schedule {
    // Auto-increment counter
    private static int idCounter = 1;

    // Private fields
    private int scheduleId;
    private String trainCode;
    private String trainName;
    private String origin;
    private String destination;
    private String departureTime;
    private double baseFare;

    // Constructor
    public Schedule(String trainCode, String trainName, String origin,
                    String destination, String departureTime, double baseFare) {
        this.scheduleId    = idCounter++;
        this.trainCode     = trainCode;
        this.trainName     = trainName;
        this.origin        = origin;
        this.destination   = destination;
        this.departureTime = departureTime;
        this.baseFare      = baseFare;
    }

    // ── Getters ──────────────────────────────────────────────
    public int    getScheduleId()    { return scheduleId; }
    public String getTrainCode()     { return trainCode; }
    public String getTrainName()     { return trainName; }
    public String getOrigin()        { return origin; }
    public String getDestination()   { return destination; }
    public String getDepartureTime() { return departureTime; }
    public double getBaseFare()      { return baseFare; }

    // ── Setters ──────────────────────────────────────────────
    public void setTrainCode(String trainCode)         { this.trainCode     = trainCode; }
    public void setTrainName(String trainName)         { this.trainName     = trainName; }
    public void setOrigin(String origin)               { this.origin        = origin; }
    public void setDestination(String destination)     { this.destination   = destination; }
    public void setDepartureTime(String departureTime) { this.departureTime = departureTime; }
    public void setBaseFare(double baseFare)           { this.baseFare      = baseFare; }

    // ── displayInfo() ─────────────────────────────────────────
    public void displayInfo() {
        System.out.println("┌──────────────────────────────────────────┐");
        System.out.printf( "│  Schedule ID  : %-26d│%n", scheduleId);
        System.out.printf( "│  Train Code   : %-26s│%n", trainCode);
        System.out.printf( "│  Train Name   : %-26s│%n", trainName);
        System.out.printf( "│  Origin       : %-26s│%n", origin);
        System.out.printf( "│  Destination  : %-26s│%n", destination);
        System.out.printf( "│  Departure    : %-26s│%n", departureTime);
        System.out.printf( "│  Base Fare    : Rp %-23.0f│%n", baseFare);
        System.out.println("└──────────────────────────────────────────┘");
    }

    // ── toString() ────────────────────────────────────────────
    @Override
    public String toString() {
        return String.format(
                "Schedule{id=%d, code='%s', name='%s', %s→%s, depart='%s', fare=Rp%.0f}",
                scheduleId, trainCode, trainName, origin, destination, departureTime, baseFare);
    }
}