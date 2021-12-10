package Ex_16;
public class ExceptionC extends ExceptionB {


    public ExceptionC() {
        super("ExceptionC");
    }

    public ExceptionC(String message) {
        super(message);
    }

    public ExceptionC(Throwable cause) {
        super(cause);
    }

    public ExceptionC(String message, Throwable cause) {
        super(message, cause);
    }

}