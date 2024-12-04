import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class GameScoreCalculatorTest {

    @Test
    public void testCalculateScore_ValidInput_Level1() {
        // given
        GameScoreCalculator calculator = new GameScoreCalculator();
        int levelCompleted = 1;
        int bonusPoints = 0;

        // when
        int result = calculator.calculateScore(levelCompleted, bonusPoints);

        // then
        assertEquals(100, result);  // يجب أن تكون النتيجة 100
    }

    @Test
    public void testCalculateScore_ValidInput_Level5() {
        // given
        GameScoreCalculator calculator = new GameScoreCalculator();
        int levelCompleted = 5;
        int bonusPoints = 50;

        // when
        int result = calculator.calculateScore(levelCompleted, bonusPoints);

        // then
        assertEquals(600, result);  // يجب أن تكون النتيجة 600
    }

    @Test
    public void testCalculateScore_ValidInput_Level10() {
        // given
        GameScoreCalculator calculator = new GameScoreCalculator();
        int levelCompleted = 10;
        int bonusPoints = 100;

        // when
        int result = calculator.calculateScore(levelCompleted, bonusPoints);

        // then
        assertEquals(1100, result);  // يجب أن تكون النتيجة 1100
    }

    @Test
    public void testCalculateScore_InvalidInput_LevelTooLow() {
        // given
        GameScoreCalculator calculator = new GameScoreCalculator();
        int levelCompleted = 0;  // مستوى غير صالح
        int bonusPoints = 50;

        // when
        try {
            calculator.calculateScore(levelCompleted, bonusPoints);
        } catch (IllegalArgumentException e) {
            // then
            assertEquals("Level completed must be between 1 and 10.", e.getMessage());
        }
    }

    @Test
    public void testCalculateScore_InvalidInput_BonusNegative() {
        // given
        GameScoreCalculator calculator = new GameScoreCalculator();
        int levelCompleted = 5;
        int bonusPoints = -1;  // نقاط مكافأة غير صالحة

        // when
        try {
            calculator.calculateScore(levelCompleted, bonusPoints);
        } catch (IllegalArgumentException e) {
            // then
            assertEquals("Bonus points cannot be negative.", e.getMessage());
        }
    }
}
