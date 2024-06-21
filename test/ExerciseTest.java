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

    @Test
    void assess_throwsException_ifExerciseIsAlreadyAssessed() {
        Exercise exercise = new Exercise(1);
        exercise.assess(7);
        assertThrows(AlreadyAssessExerciseException.class, () -> exercise.assess(8));
    }

    @Test
    void isAssessed_returnFalse_ifExerciseScoreIsInvalid() {
        Exercise exercise = new Exercise(1);
        try {
            exercise.assess(15);
        } catch (InvalidScoreException e) {

        }
        assertFalse(exercise.isAssessed());
    }

    @Test
    void isAssessed_returnTrue_ifAssesIsCalledMoreTime_andTheExerciseScoreIsInvalid() {
        Exercise exercise = new Exercise(1);
        exercise.assess(8);
        try {
            exercise.assess(15);
        } catch (AlreadyAssessExerciseException e) {

        }
        assertTrue(exercise.isAssessed());
    }

    @Test
    void isAssessed_returnTrue_ifAssesIsCalledMoreTime_andTheExerciseScoreIsValid() {
        Exercise exercise = new Exercise(1);
        exercise.assess(8);
        try {
            exercise.assess(9);
        } catch (AlreadyAssessExerciseException e) {

        }
        assertTrue(exercise.isAssessed());
    }

    @Test
    void getScore_returnFirstScore_afterExerciseIsAssessedMoreTimes() {
        Exercise exercise = new Exercise(1);
        exercise.assess(10);
        try {
            exercise.assess(4);
        } catch (AlreadyAssessExerciseException e) {

        }
        int expected = 10;
        int result = exercise.getScore();
        assertEquals(expected, result);
    }
}
