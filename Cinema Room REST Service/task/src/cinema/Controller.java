package cinema;

import cinema.dao.SeatDAO;
import cinema.entity.Seat;
import cinema.entity.Ticket;
import cinema.entity.Theater;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;



@RestController
public class Controller {
    @Autowired
    private Theater theater;

    @Autowired
    private SeatDAO seatDAO;


    @PostMapping("purchase")
    public ResponseEntity<Seat> purchaseTicket(@RequestBody Ticket seat){
        return seatDAO.purchaseTicket(seat);
    }

    @GetMapping("seats")
    public Theater getAllSeats(){
        return theater;
    }


    @PostMapping("/return")
    public ResponseEntity<?> returnTicket(@RequestBody Map<String, String> tokenBody){
        String token = tokenBody.get("token");
        return seatDAO.returnTicket(token);
    }

    @PostMapping("/stats")
    public ResponseEntity<?> getStats(@RequestParam(required = false)String password){
        return seatDAO.getStats(password);



    }
}
