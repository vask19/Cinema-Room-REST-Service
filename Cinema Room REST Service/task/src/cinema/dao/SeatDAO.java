package cinema.dao;


import cinema.entity.ErrorSeat;
import cinema.entity.Seat;
import cinema.entity.SeatInTheater;
import cinema.entity.Theater;
import cinema.exception.OutOfBoundsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.server.ResponseStatusException;


@Repository
public class SeatDAO {
    @Autowired
    private Theater theater;

    public ResponseEntity<Seat> purchaseTicket(Seat seat){

        if (theater.getAvailableSeats().contains(seat)) {

            int seatIndex = theater.getAvailableSeats().indexOf(seat);

            if (theater.getAvailableSeats().get(seatIndex).isIfPurchased()) {
                return new ResponseEntity<Seat>(new ErrorSeat(
                        "The ticket has been already purchased!"), HttpStatus.BAD_REQUEST);
            }
            else{
                theater.getAvailableSeats().get(seatIndex).setIfPurchased(true);
                SeatInTheater newSeat = theater.getAvailableSeats().get(seatIndex);
                return new  ResponseEntity<Seat>(newSeat,HttpStatus.OK);
            }
        }
        else {
            return new ResponseEntity<Seat>(new ErrorSeat(
                    "The number of a row or a column is out of bounds!"
            ), HttpStatus.BAD_REQUEST);
        }

    }

}
