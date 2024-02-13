package app.exceptions.height;

public class LowerLimitHeightException extends Exception {
    public LowerLimitHeightException(String errorMessage) {
        super(errorMessage);
    }
}
