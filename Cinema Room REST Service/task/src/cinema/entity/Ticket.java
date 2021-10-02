package cinema.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Objects;
import java.util.UUID;

public class Ticket implements Seat {
    private int row;
    private int column;
    private int price;
    @JsonIgnore
    private UUID token;
    @JsonIgnore
    private boolean ifPurchased;

    public Ticket() {
    }

    public Ticket(int row, int column) {
        this.row = row;
        this.column = column;
        ifPurchased = false;

    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public boolean isIfPurchased() {
        return ifPurchased;
    }

    public void setIfPurchased(boolean ifPurchased) {
        this.ifPurchased = ifPurchased;
    }

    public UUID getToken() {
        return token;
    }

    public void setToken(UUID token) {
        this.token = token;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ticket seat = (Ticket) o;
        return row == seat.row && column == seat.column;
    }

    @Override
    public int hashCode() {
        return Objects.hash(row, column);
    }

}
