package queivan.service.exceptions;

public class NoteExistsException extends RuntimeException {
    public NoteExistsException(){
        super("Note already exists in DB");
    }
}
