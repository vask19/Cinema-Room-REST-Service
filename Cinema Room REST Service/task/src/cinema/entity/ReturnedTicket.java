package cinema.entity;

public class ReturnedTicket implements Seat{
    private int row;
    private int column;
    private int price;

    public ReturnedTicket() {
    }

    public ReturnedTicket(int row, int column, int price) {
        this.row = row;
        this.column = column;
        this.price = price;
    }
    public ReturnedTicket(Ticket ticket){
        this.row = ticket.getRow();
        this.column = ticket.getColumn();
        this.price = ticket.getPrice();
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
}
