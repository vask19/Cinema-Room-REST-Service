package cinema;

import cinema.entity.Theater;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class Controller {
    @Autowired
    private Theater theater;

    @GetMapping("seats")
    public Theater getAllSeats(){

        return theater;

    }
}
