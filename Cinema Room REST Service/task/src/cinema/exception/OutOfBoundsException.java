package cinema.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class OutOfBoundsException extends RuntimeException{


    public OutOfBoundsException(String cause){
        super(cause);
    }
}
