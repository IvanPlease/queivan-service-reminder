package queivan.service.exceptions;

public class BoilerDontExistsException extends RuntimeException {
    public BoilerDontExistsException(){
        super("Boiler doesn't exists in DB");
    }
}
