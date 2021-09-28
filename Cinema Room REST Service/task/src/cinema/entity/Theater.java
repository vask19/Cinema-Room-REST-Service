package cinema.entity;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class Theater {

    private int totalRows;
    private int totalColumns;
    private List<SeatInTheater> availableSeats;



    public Theater() {
        this.totalRows = 9;
        this.totalColumns = 9;
        availableSeats = new ArrayList<>();
        for (int i =0;i<totalRows;i++){
            for (int j = 0;j<totalColumns;j++){
                SeatInTheater seat = new SeatInTheater(i+1,j+1);
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

    public List<SeatInTheater> getAvailableSeats() {
        return availableSeats;
    }

    public void setAvailableSeats(List<SeatInTheater> availableSeats) {
        this.availableSeats = availableSeats;
    }
}
