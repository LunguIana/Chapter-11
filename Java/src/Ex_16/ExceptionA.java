package Ex_16;
public class ExceptionA extends Exception {


    public ExceptionA() {
        super("ExceptionA");
    }

    public ExceptionA(String message) {
        super(message);
    }

    public ExceptionA(Throwable cause) {
        super(cause);
    }

    public ExceptionA(String message, Throwable cause) {
        super(message, cause);
    }


}