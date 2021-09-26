package queivan.service.exceptions;

public class ClientExistsException extends RuntimeException {
    public ClientExistsException(int phoneNumber){
        super(String.format("Klient posiadający numer telefonu: %s, istnieje już w BD", phoneNumber));
    }
}
