package cinema.dao;

import cinema.entity.ErrorSeat;
import cinema.entity.Seat;
import cinema.entity.SeatInTheater;
import cinema.entity.Theater;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class SeatDAO {
    @Autowired
    private Theater theater;

    public Seat purchaseTicket(Seat seat){

        if (theater.getAvailableSeats().contains(seat)) {

            int seatIndex = theater.getAvailableSeats().indexOf(seat);
            if (theater.getAvailableSeats().get(seatIndex).isIfPurchased())
                return new ErrorSeat("The ticket has been already purchased!");
            theater.getAvailableSeats().get(seatIndex).setIfPurchased(true);
            SeatInTheater newSeat = theater.getAvailableSeats().get(seatIndex);
            return newSeat;
        }
        return new ErrorSeat("The number of a row or a column is out of bounds!");


    }

}
