package exception;

public class IndexNotRightException extends RuntimeException {
    public IndexNotRightException() {}
    public IndexNotRightException(String detail)
    {
        super(detail);
    }
}
