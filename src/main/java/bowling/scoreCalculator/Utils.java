package bowling.scoreCalculator;

import bowling.exception.BowlingFrameException;
import bowling.exception.BowlingLineException;
import bowling.exception.BowlingRowException;


public class Utils {

    static final Character spare ='/';
    static final Character strike ='X';
    static final Character miss ='-';

    private Utils() {
        //
    }

    public static void BowlingLineCheck(String[] bowlingLine) throws BowlingLineException {
        LineNullCheck(bowlingLine);
        LineLengthCheck(bowlingLine);
        FramesCheck(bowlingLine);
    }

    public static int rowValue(Character row) throws BowlingRowException {
        if (Utils.spare.equals(row) || Utils.strike.equals(row)){
            return 10;
        } else  if (Character.isDigit(row)){
            return Character.getNumericValue(row);
        } else {
            throw new BowlingRowException("A row have a wrong character");
        }

    }

    private static void LineNullCheck(String[] bowlingLine) throws BowlingLineException {
        if (bowlingLine == null) {
            throw new BowlingLineException("The bowling lane is Null");
        }
    }

    private static void LineLengthCheck(String[] bowlingLine) throws BowlingLineException {
        if (bowlingLine.length < 10 || bowlingLine.length > 12) {
            throw new BowlingLineException("Number of frame in the bowling lane is wrong");
        } else if (bowlingLine.length==11) {
            if ((strike.equals(bowlingLine[9].charAt(0)) && ! Character.isDigit(bowlingLine[10].charAt(0))) ||
                    bowlingLine[9].length()==2 &&  !  spare.equals(bowlingLine[9].charAt(1)) ){
                throw new BowlingLineException("Number of frame in the bowling lane is wrong");
            }
        } else if (bowlingLine.length==12) {
            if ( ! strike.equals(bowlingLine[9].charAt(0))  || ! strike.equals(bowlingLine[10].charAt(0))){
                throw new BowlingLineException("Number of frame in the bowling lane is wrong");
            }
        }
    }

    private static void FramesCheck(String[] bowlingLine) throws BowlingFrameException, BowlingRowException {
        for(int i =0; i <bowlingLine.length; i++){
            String frame = bowlingLine[i];
            int frameNumber = i+1;

            if (frame.length()< 1 || frame.length()> 2) {
                throw new BowlingFrameException("Number of row in the bowling frame " +frameNumber+" is wrong");
            }

            if (frame.length() == 1 ) {
                if ( isCharacterValuable(frame.charAt(0))){
                    throw new BowlingRowException("A character is wrong in row of the frame " +frameNumber);
                }

                if(! strike.equals(bowlingLine[i].charAt(0)) && i<10) {
                    throw new BowlingFrameException("Number of row in the bowling frame " +frameNumber+" is wrong");
                } else if (i==10
                        && (!strike.equals(bowlingLine[i-1].charAt(0))&& !strike.equals(bowlingLine[i-2].charAt(0)))
                        && ( bowlingLine[i-1].length() != 2 || !spare.equals(bowlingLine[i-1].charAt(1)))) {
                    throw new BowlingFrameException("Number of row in the bowling frame " +frameNumber+" is wrong");
                }
            }

            if (frame.length() == 2 ) {

                if ( isCharacterValuable(frame.charAt(0)) || isCharacterValuable(frame.charAt(1))){
                    throw new BowlingRowException("A character is wrong in row of the frame " +frameNumber);
                }

                if (i==11 ) {
                    throw new BowlingFrameException("Number of row in the bowling frame " +frameNumber+" is wrong");
                }

                if ( Character.isDigit(bowlingLine[i].charAt(0)) && Character.isDigit(bowlingLine[i].charAt(1))
                        && (Character.getNumericValue(bowlingLine[i].charAt(0)) + Character.getNumericValue(bowlingLine[i].charAt(1)) >10)){
                            throw new BowlingFrameException("The score of the row is too high");
                }

                if (spare.equals(bowlingLine[i].charAt(0))){
                    throw new BowlingFrameException("A frame can't start with a Spare");
                }

                if (strike.equals(bowlingLine[i].charAt(1))){
                    throw new BowlingFrameException("A frame can't have a strike on a second row");
                }

            }





        }

    }

    private static boolean isCharacterValuable (Character row) {
        return !Character.isDigit(row)
                && !spare.equals(row)
                && !strike.equals(row)
                && !miss.equals(row);
    }

}
