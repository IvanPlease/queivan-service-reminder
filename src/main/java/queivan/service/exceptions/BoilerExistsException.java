package queivan.service.exceptions;

public class BoilerExistsException extends RuntimeException {
    public BoilerExistsException(String serialNumber){
        super(String.format("Bojler o numerze seryjnym: %s, istnieje już w BD", serialNumber));
    }
}
