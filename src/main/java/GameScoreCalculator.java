public class GameScoreCalculator {

    /**
     * Calculates a game score based on the level completed and bonus points earned.
     *
     * <p>The base score is calculated by multiplying the `levelCompleted` by 100.
     * Bonus points are added to the base score. If the `levelCompleted` is 5 or greater
     * and `bonusPoints` are 50 or greater, the bonus points are doubled before being added
     * to the base score.
     *
     * @param levelCompleted The level completed by the player (must be between 1 and 10 inclusive).
     * @param bonusPoints    The bonus points earned by the player (must be non-negative).
     * @return The total calculated score.
     * @throws IllegalArgumentException if `levelCompleted` is not within the valid range (1-10)
     *                                  or if `bonusPoints` is negative.
     */
    public int calculateScore(int levelCompleted, int bonusPoints) {
    	
        if (levelCompleted < 1 || levelCompleted > 10) {
            throw new IllegalArgumentException("Level completed must be between 1 and 10.");
        }

        if (bonusPoints < 0) {
            throw new IllegalArgumentException("Bonus points cannot be negative.");
        }

        int baseScore = levelCompleted * 100;

        if (levelCompleted >= 5 && bonusPoints >= 50) {
            return baseScore + bonusPoints * 2; // Double bonus points if level 5 or higher and bonus is at least 50
        } else {
            return baseScore + bonusPoints;
        }
    }
}