package ru.masterdm.uct.entity;

/**
 * Event to be fixed in journal.
 */
public class Event {
    private ErrorCode bsErrorCode;
    private String bsError;

    /**
     * Constructor with all fields.
     * @param bsErrorCode error code
     * @param bsError error text
     */
    public Event(ErrorCode bsErrorCode, String bsError) {
        this.bsError = bsError;
        this.bsErrorCode = bsErrorCode;
    }

    /**
     * bsError field getter.
     * @return bsError
     */
    public String getBsError() {
        return bsError;
    }

    /**
     * bsErrorCode field getter.
     * @return bsErrorCode
     */
    public String getBsErrorCode() {
        return bsErrorCode.getCode();
    }

    @Override
    public String toString() {
        return "Event{" + "bsError='" + bsError + '\'' + ", bsErrorCode='" + bsErrorCode + '\'' + '}';
    }
}
