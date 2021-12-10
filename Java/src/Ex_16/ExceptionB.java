package Ex_16;
public class ExceptionB extends ExceptionA {


    public ExceptionB() {
        super("ExceptionB");
    }

    public ExceptionB(String message) {
        super(message);
    }

    public ExceptionB(Throwable cause) {
        super(cause);
    }

    public ExceptionB(String message, Throwable cause) {
        super(message, cause);
    }



}