package queivan.service.exceptions;

public class PictureExistsException extends RuntimeException {
    public PictureExistsException(){
        super("Picture already exists in DB");
    }
}
