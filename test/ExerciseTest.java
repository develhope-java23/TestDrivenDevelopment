import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ExerciseTest {

    @Test
    void isAssessed_returnFalse_ifScoreIs0() {
        Exercise exercise = new Exercise(1);
        boolean assessed = exercise.isAssessed();
        assertFalse(assessed);
    }

    @Test
    void isAssessed_returnTrue_ifScoreIs6() {
        Exercise exercise = new Exercise(1);
        exercise.assess(6);
        boolean assessed = exercise.isAssessed();
        assertTrue(assessed);
    }

    @Test
    void assess_throwsException_ifScoreIs15() {
        Exercise exercise = new Exercise(1);
        assertThrows(InvalidScoreException.class, () -> exercise.assess(15));
    }
}
