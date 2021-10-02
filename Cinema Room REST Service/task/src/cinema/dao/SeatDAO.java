package cinema.dao;


import cinema.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import java.util.Map;
import java.util.UUID;


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
                Ticket ticket = theater.getAvailableSeats().get(seatIndex);
                ticket.setIfPurchased(true);
                ticket.setToken(UUID.randomUUID());
                TicketWithToken newSeat = new TicketWithToken(ticket.getToken(),ticket);
                return new  ResponseEntity<Seat>(newSeat,HttpStatus.OK);
            }
        }
        else {
            return new ResponseEntity<Seat>(new ErrorSeat(
                    "The number of a row or a column is out of bounds!"
            ), HttpStatus.BAD_REQUEST);
        }

    }


    public ResponseEntity<?> returnTicket(String   token){
        for (int i =0;i<theater.getAvailableSeats().size();i++){
            Ticket ticket = theater.getAvailableSeats().get(i);
            UUID ticketToken = ticket.getToken();
            if (ticketToken == null) continue;
            if (ticketToken.toString().equals(token)){
                ticket.setToken(null);
                ticket.setIfPurchased(false);
                return new ResponseEntity<>(Map.of("returned_ticket", ticket), HttpStatus.OK);
            }
        }
        return new ResponseEntity<>(Map.of("error", "Wrong token!"), HttpStatus.BAD_REQUEST);

    }

}
