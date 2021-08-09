package Bowling.Exception;

public class BowlingFrameException extends BowlingLineException{

    public BowlingFrameException() {
        this( "Denominator cannot be zero" );
    }

    public BowlingFrameException( String message ) {
        super( message );
    }

    public BowlingFrameException( String message, Throwable cause ) {
        super( message, cause );
    }
}
