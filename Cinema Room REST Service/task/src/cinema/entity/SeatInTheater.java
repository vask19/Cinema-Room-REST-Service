package cinema.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Objects;

public class SeatInTheater implements Seat {
    private int row;
    private int column;
    private int price;
    @JsonIgnore
    private boolean ifPurchased;

    public SeatInTheater() {
    }

    public SeatInTheater(int row, int column) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SeatInTheater seat = (SeatInTheater) o;
        return row == seat.row && column == seat.column;
    }

    @Override
    public int hashCode() {
        return Objects.hash(row, column);
    }
}
