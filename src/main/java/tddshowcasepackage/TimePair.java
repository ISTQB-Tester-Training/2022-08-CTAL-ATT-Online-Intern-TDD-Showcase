package tddshowcasepackage;

import java.time.*;
import java.time.temporal.ChronoUnit;

public class TimePair {

    public double getTimeDifference(String strStartTime, String strEndTime) {

        try { LocalTime checkStartTime = LocalTime.parse(strStartTime);
        }
        catch (Exception e) {
            throw new TimePairException(e.getMessage() + "(Input value: " + strStartTime + ")", 501);
        }

        try { LocalTime checkEndTime = LocalTime.parse(strEndTime);
        }
        catch (Exception e) {
            throw new TimePairException(e.getMessage() + "(Input value: " + strEndTime + ")", 502);
        }

        double aTimeDifference = LocalTime.parse(strStartTime).until(LocalTime.parse(strEndTime), ChronoUnit.MINUTES)/60.0;
        if (aTimeDifference < 0.0) {
            throw new TimePairException("Invalid time period " +
                    strStartTime + " / " +
                    strEndTime +
                    " time difference " + aTimeDifference + " hours", 503);
        }
        return aTimeDifference;
    }

    public class TimePairException extends RuntimeException {
        private final String message;
        private final Long messageNr;

        public TimePairException (String argMessage, long argMessageNr) {
            super(argMessage);
            message = argMessage;
            messageNr = argMessageNr;
        }
        public String getMessageText() {
            return message;
        }
        public Long getMessageNr() {
            return messageNr;
        }
    }
}