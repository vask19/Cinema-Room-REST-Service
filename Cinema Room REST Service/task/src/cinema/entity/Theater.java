package cinema.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class Theater {

    private int totalRows;
    private int totalColumns;
    private List<Ticket> availableSeats;
    @JsonIgnore
    private int numberOfAvailableSeats;
    @JsonIgnore
    private Long currentIncome;
    @JsonIgnore
    private int numberOfPurchasedTickets;



    public Theater() {
        this.totalRows = 9;
        this.totalColumns = 9;
        numberOfAvailableSeats = totalRows * totalColumns;
        this.currentIncome = 0L;
        this.numberOfPurchasedTickets = 0;
        availableSeats = new ArrayList<>();
        for (int i =0;i<totalRows;i++){
            for (int j = 0;j<totalColumns;j++){
                Ticket seat = new Ticket(i+1,j+1);
                if (i > 4 ) seat.setPrice(8);
                else seat.setPrice(10);
                availableSeats.add(seat);
            }
        }
    }

    public int getTotalRows() {
        return totalRows;
    }

    public void setTotalRows(int totalRows) {
        this.totalRows = totalRows;
    }

    public int getTotalColumns() {
        return totalColumns;
    }

    public void setTotalColumns(int totalColumns) {
        this.totalColumns = totalColumns;
    }

    public List<Ticket> getAvailableSeats() {
        return availableSeats;
    }

    public void setAvailableSeats(List<Ticket> availableSeats) {
        this.availableSeats = availableSeats;
    }

    public int getNumberOfAvailableSeats() {
        return numberOfAvailableSeats;
    }

    public void setNumberOfAvailableSeats(int numberOfAvailableSeats) {
        this.numberOfAvailableSeats = numberOfAvailableSeats;
    }

    public Long getCurrentIncome() {
        return currentIncome;
    }

    public void setCurrentIncome(Long currentIncome) {
        this.currentIncome = currentIncome;
    }

    public int getNumberOfPurchasedTickets() {
        return numberOfPurchasedTickets;
    }

    public void setNumberOfPurchasedTickets(int numberOfPurchasedTickets) {
        this.numberOfPurchasedTickets = numberOfPurchasedTickets;
    }
}
