public class TrainTicket<T, U> {
    private T bookingCode;
    private Passenger<U> passenger;
    private TicketClass ticketClass;

    public TrainTicket(T bookingCode, Passenger<U> passenger, TicketClass ticketClass) {
        this.bookingCode = bookingCode;
        this.passenger = passenger;
        this.ticketClass = ticketClass;
    }

    public T getBookingCode() {
        return bookingCode;
    }

    public Passenger<U> getPassenger() {
        return passenger;
    }

    public TicketClass getTicketClass() {
        return ticketClass;
    }
}
