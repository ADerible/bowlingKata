package bowling.exception;

public class BowlingFrameException extends BowlingLineException{

    public BowlingFrameException() {
        this( "A frame have a problem" );
    }

    public BowlingFrameException( String message ) {
        super( message );
    }

    public BowlingFrameException( String message, Throwable cause ) {
        super( message, cause );
    }
}
