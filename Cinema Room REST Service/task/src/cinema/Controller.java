package cinema;

import cinema.dao.SeatDAO;
import cinema.entity.Seat;
import cinema.entity.SeatInTheater;
import cinema.entity.Theater;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class Controller {
    @Autowired
    private Theater theater;

    @Autowired
    private SeatDAO seatDAO;


    @PostMapping("purchase")
    public Seat purchaseTicket(@RequestBody SeatInTheater seat){
        return seatDAO.purchaseTicket(seat);
    }

    @GetMapping("seats")
    public Theater getAllSeats(){
        return theater;

    }
}
