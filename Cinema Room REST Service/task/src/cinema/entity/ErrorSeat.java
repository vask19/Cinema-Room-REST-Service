package cinema.entity;

public class ErrorSeat implements Seat{
    private String error;

    public ErrorSeat() {
    }

    public ErrorSeat(String error) {
        this.error = error;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}
