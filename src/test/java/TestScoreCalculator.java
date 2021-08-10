import bowling.exception.BowlingLineException;
import bowling.scoreCalculator.ScoreCalculator;
import org.junit.Assert;
import org.junit.Test;

public class TestScoreCalculator {

    // Test OK
    @Test
    public void testOkStandardLine() throws BowlingLineException {
        String[] args = new String[]{"45", "45", "45", "45", "45", "45", "45", "45", "45", "45"  };
        Assert.assertEquals(90, ScoreCalculator.main(args));
    }

    @Test
    public void testOkSomeMiss() throws BowlingLineException {
        String[] args = new String[]{"45", "45", "-5", "45", "4-", "45", "45", "45", "45", "45"  };
        Assert.assertEquals(81, ScoreCalculator.main(args));
    }

    @Test
    public void testOkSomeSpares() throws BowlingLineException {
        String[] args = new String[]{"45", "45", "4/", "45", "45", "4/", "45", "45", "45", "45"  };
        Assert.assertEquals(100, ScoreCalculator.main(args));
    }

    @Test
    public void testOkSomeStrikes() throws BowlingLineException {
        String[] args = new String[]{"45", "45", "X", "45", "45", "X", "45", "45", "45", "45"  };
        Assert.assertEquals(110, ScoreCalculator.main(args));
    }

    @Test
    public void testOkEndWithSpare() throws BowlingLineException {
        String[] args = new String[]{"45", "45", "45", "45", "45", "45", "45", "45", "45", "4/", "4"  };
        Assert.assertEquals(95, ScoreCalculator.main(args));
    }

    @Test
    public void testOkEndWithStrikes() throws BowlingLineException {
        String[] args = new String[]{"45", "45", "45", "45", "45", "45", "45", "45", "45", "X", "45"  };
        Assert.assertEquals(100, ScoreCalculator.main(args));
    }
    @Test
    public void testOkAllMiss() throws BowlingLineException {
        String[] args = new String[]{"--", "--", "--", "--", "--", "--", "--", "--", "--", "--"  };
        Assert.assertEquals(0, ScoreCalculator.main(args));
    }

    @Test
    public void testOkAllSpares() throws BowlingLineException {
        String[] args = new String[]{"5/", "5/", "5/", "5/", "5/", "5/", "5/", "5/", "5/", "5/", "5/"  };
        Assert.assertEquals(150, ScoreCalculator.main(args));
    }

    @Test
    public void testOkAllStrikes() throws BowlingLineException {
        String[] args = new String[]{"X", "X", "X", "X", "X", "X", "X", "X", "X", "X", "X", "X"  };
        Assert.assertEquals(300, ScoreCalculator.main(args));
    }

    //Test KO

    @Test(expected = BowlingLineException.class)
    public void testKoNull() throws BowlingLineException {
        ScoreCalculator.main(null);
    }

    @Test(expected = BowlingLineException.class)
    public void testKoEmptyLine() throws BowlingLineException {
        String[] args = new String[]{};
        ScoreCalculator.main(args);
    }

    @Test(expected = BowlingLineException.class)
    public void testKoArrayWithNullString() throws BowlingLineException {
        String[] args = new String[]{"45", "45", null, "45", "45", "45", "45", "45", "45", "45", "45" , "45" , "45" , "45" , "45"   };
        ScoreCalculator.main(args);
    }

    @Test(expected = BowlingLineException.class)
    public void testKoTooManyFrames() throws BowlingLineException {
        String[] args = new String[]{"45", "45", "45", "45", "45", "45", "45", "45", "45", "45", "45" , "45" , "45" , "45" , "45"   };
        ScoreCalculator.main(args);
    }

    @Test(expected = BowlingLineException.class)
    public void testKoTooFewFrames() throws BowlingLineException{
        String[] args = new String[]{ "45", "45", "45" , "45" , "45" , "45" , "45"   };
        ScoreCalculator.main(args);
    }

    @Test(expected = BowlingLineException.class)
    public void testKoTooManyRollsInFrames() throws BowlingLineException{
        String[] args = new String[]{"45", "4545434", "45", "45", "45", "45", "45", "45", "45", "45" };
        ScoreCalculator.main(args);
    }

    @Test(expected = BowlingLineException.class)
    public void testKoTooFewRollsInFrames() throws BowlingLineException{
        String[] args = new String[]{"45", "45", "4", "45", "45", "45", "45", "45", "45", "45" };
        ScoreCalculator.main(args);
    }

    @Test(expected = BowlingLineException.class)
    public void testKoRollsEndWithStrike() throws BowlingLineException{
        String[] args = new String[]{"45", "45", "45", "45", "45", "45", "4X", "45", "45", "45" };
        ScoreCalculator.main(args);
    }


    @Test(expected = BowlingLineException.class)
    public void testKoRollsStartWithSpare() throws BowlingLineException{
        String[] args = new String[]{"45", "45", "45", "45", "/5", "45", "45", "45", "45", "45" };
        ScoreCalculator.main(args);
    }


    @Test(expected = BowlingLineException.class)
    public void testKoFramesScoreBiggerThanTen() throws BowlingLineException{
        String[] args = new String[]{"45", "99", "45", "45", "45", "45", "45", "45", "45", "45" };
        ScoreCalculator.main(args);
    }

    @Test(expected = BowlingLineException.class)
    public void testKoFramesWithASingleRowMiss() throws BowlingLineException{
        String[] args = new String[]{"45", "-", "45", "45", "45", "45", "45", "45", "45", "45" };
        ScoreCalculator.main(args);
    }

    @Test(expected = BowlingLineException.class)
    public void testKoFramesWithASingleRowSpare() throws BowlingLineException{
        String[] args = new String[]{"45", "/", "45", "45", "45", "45", "45", "45", "45", "45" };
        ScoreCalculator.main(args);
    }

    @Test(expected = BowlingLineException.class)
    public void testKoOtherChar() throws BowlingLineException{
        String[] args = new String[]{"45", "%4", "45", "45", "45", "45", "45", "45", "45", "45" };
        ScoreCalculator.main(args);
    }

}
