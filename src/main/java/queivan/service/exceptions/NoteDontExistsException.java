package queivan.service.exceptions;

public class NoteDontExistsException extends RuntimeException {
    public NoteDontExistsException(){
        super("Note doesn't exists in DB");
    }
}
