package tddshowcasetestpackage;

import tddshowcasepackage.*;
import org.junit.Test;
import static org.junit.Assert.*;

public class TimePairTest {

    TimePair aTimePair = new TimePair();

    @Test
    public void timeDifferenceTest_1h () {
        assertEquals(1.0, aTimePair.getTimeDifference("10:00", "11:00"), 0.0);
    }

    @Test
    public void timeDifferenceTest_0h () {
        assertEquals(0.0, aTimePair.getTimeDifference("10:00", "10:00"), 0.0);
    }

    @Test
    public void timeDifferenceTest_invalidStartTimeFormat() {

        TimePair.TimePairException aTimePairException = assertThrows(TimePair.TimePairException.class,
                () -> aTimePair.getTimeDifference("SS:00", "11:00"));

        assertEquals(501, (long) aTimePairException.getMessageNr());
        System.out.println("Invalid START Time - Error Number: " + aTimePairException.getMessageNr() + " " +
                "Error text: " + aTimePairException.getMessageText());
    }

    @Test
    public void timeDifferenceTest_invalidEndTimeFormat() {

        TimePair.TimePairException aTimePairException = assertThrows(TimePair.TimePairException.class,
                () -> aTimePair.getTimeDifference("11:00", "EE:00"));

        assertEquals(502, (long) aTimePairException.getMessageNr());
        System.out.println("Invalid END Time - Error Number: " + aTimePairException.getMessageNr() + " " +
                "Error text: " + aTimePairException.getMessageText());
    }

    @Test
    public void timeDifferenceTest_invalidTimePeriod() {

        TimePair.TimePairException aTimePairException = assertThrows(TimePair.TimePairException.class,
                () -> aTimePair.getTimeDifference("19:00", "03:00"));

        assertEquals(503, (long) aTimePairException.getMessageNr());
        System.out.println("Invalid TIME PERIOD - Error Number: " + aTimePairException.getMessageNr() + " " +
                "Error text: " + aTimePairException.getMessageText());
    }
}