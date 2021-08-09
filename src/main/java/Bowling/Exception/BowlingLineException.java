package Bowling.Exception;

public class BowlingLineException extends Exception{

    public BowlingLineException() {
        this( "Denominator cannot be zero" );
    }

    public BowlingLineException( String message ) {
        super( message );
    }

    public BowlingLineException( String message, Throwable cause ) {
        super( message, cause );
    }

}
