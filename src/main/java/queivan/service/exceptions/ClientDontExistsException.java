package queivan.service.exceptions;

public class ClientDontExistsException extends RuntimeException {
    public ClientDontExistsException(){
        super("Client doesn't exists in DB");
    }
}
