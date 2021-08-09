package Bowling.ScoreCalculator;

import Bowling.Exception.BowlingLineException;

import static Bowling.ScoreCalculator.Utils.BowlingLineCheck;

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
                    System.out.println("Spare / !!! ");
                    frameScore=10;
                    if (Utils.spare.equals(bowlingLine[i+1].charAt(0)) || Utils.strike.equals(bowlingLine[i+1].charAt(0))){
                        frameScore=frameScore+10;
                    } else  if (Character.isDigit(bowlingLine[i+1].charAt(0))){
                        frameScore=frameScore+Character.getNumericValue(bowlingLine[i+1].charAt(0));
                    }

                } else if (Utils.strike.equals(row)){
                    System.out.println("Strike X !!! ");
                    frameScore=10;
                    if (Utils.spare.equals(bowlingLine[i+1].charAt(0)) || Utils.strike.equals(bowlingLine[i+1].charAt(0))){
                        frameScore=frameScore+10;
                    } else  if (Character.isDigit(bowlingLine[i+1].charAt(0))){
                        frameScore=frameScore+Character.getNumericValue(bowlingLine[i+1].charAt(0));
                    }

                    if (bowlingLine[i+1].length()==2){
                        if (Utils.spare.equals(bowlingLine[i+1].charAt(1)) || Utils.strike.equals(bowlingLine[i+1].charAt(1))){
                            frameScore=frameScore+10;
                        } else  if (Character.isDigit(bowlingLine[i+1].charAt(1))){
                            frameScore=frameScore+Character.getNumericValue(bowlingLine[i+1].charAt(1));
                        }
                    } else {
                        if (Utils.spare.equals(bowlingLine[i+2].charAt(0)) || Utils.strike.equals(bowlingLine[i+2].charAt(0))){
                            frameScore=frameScore+10;
                        } else  if (Character.isDigit(bowlingLine[i+2].charAt(0))){
                            frameScore=frameScore+Character.getNumericValue(bowlingLine[i+2].charAt(0));
                        }
                    }

                }
            }

            gameScore=gameScore+frameScore;
            System.out.println("Frame  "+ frameNumber + " :  Rows " + bowlingLine[i] + " :  Frame Score  " +frameScore + " :  Game Score  " +gameScore);

        }


        return gameScore;
    }
}
