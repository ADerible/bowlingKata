package bowling.exception;

public class BowlingRowException extends BowlingLineException{

    public BowlingRowException() {
        this( "A row have a problem" );
    }

    public BowlingRowException( String message ) {
        super( message );
    }

    public BowlingRowException( String message, Throwable cause ) {
        super( message, cause );
    }

}
