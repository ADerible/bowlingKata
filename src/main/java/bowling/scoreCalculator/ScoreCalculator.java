package bowling.scoreCalculator;

import bowling.exception.BowlingLineException;

import static bowling.scoreCalculator.Utils.BowlingLineCheck;
import static bowling.scoreCalculator.Utils.rowValue;

public class ScoreCalculator {

    public static int main (String[] bowlingLine) throws BowlingLineException {
        int gameScore=0;
        int frameScore;

        // Check of the bowling line input
        BowlingLineCheck(bowlingLine);

        // Calculate Score
        int frameNumber;

        for (int i=0; i <10 ; i++){
            frameScore=0;
            frameNumber=i+1;

            for (Character row : bowlingLine[i].toCharArray()) {
                if (Character.isDigit(row)){
                    frameScore=frameScore+Character.getNumericValue(row);
                } else if (Utils.spare.equals(row)){
                    frameScore=10+rowValue(bowlingLine[i+1].charAt(0));
                } else if (Utils.strike.equals(row)){
                    frameScore=10+rowValue(bowlingLine[i+1].charAt(0));

                    if (bowlingLine[i+1].length()==2){
                        frameScore=frameScore+rowValue(bowlingLine[i+1].charAt(1));
                    } else {
                        frameScore=frameScore+rowValue(bowlingLine[i+2].charAt(0));
                    }

                }
            }

            gameScore=gameScore+frameScore;
            System.out.println("Frame  "+ frameNumber + " : " + bowlingLine[i] + " ;  Frame Score  " +frameScore + " ;  Game Score  " +gameScore);
        }
        System.out.println("Final game score : "+gameScore);
        return gameScore;
    }
}
