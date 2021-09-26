package queivan.service.exceptions;

public class PictureDontExistsException extends RuntimeException {
    public PictureDontExistsException(){
        super("Picture doesn't exists in DB");
    }
}
