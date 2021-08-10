package bowling.exception;

public class BowlingLineException extends Exception{

    public BowlingLineException() {
        this( "This line have a problem" );
    }

    public BowlingLineException( String message ) {
        super( message );
    }

    public BowlingLineException( String message, Throwable cause ) {
        super( message, cause );
    }

}
