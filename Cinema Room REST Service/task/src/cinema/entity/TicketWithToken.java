package cinema.entity;

import java.util.UUID;

public class TicketWithToken implements Seat{
    private UUID token;
    private Ticket ticket;

    public TicketWithToken(UUID token, Ticket ticket) {
        this.token = token;
        this.ticket = ticket;
    }

    public TicketWithToken() {
    }

    public UUID getToken() {
        return token;
    }

    public void setToken(UUID token) {
        this.token = token;
    }

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }
}
