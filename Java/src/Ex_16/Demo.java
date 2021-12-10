package Ex_16;

public class Demo {

    public static void main(String[] args) {

        System.out.println("Exception Block per exception type demo: ");
        for (int i=0; i<3 ; i++){
            try{
                switch (i) {
                    case 0 : giveExceptionC();
                    case 1 : giveExceptionB();
                    case 2 : giveExceptionA();
                }
            } catch (ExceptionC ec) {
                System.out.println("ExceptionC catch block.");
                System.out.println(ec);
            } catch (ExceptionB eb) {
                System.out.println("ExceptionB catch block.");
                System.out.println(eb);
            } catch (ExceptionA ea) {
                System.out.println("ExceptionA catch block.");
                System.out.println(ea);
            }

        }

        System.out.println("Exception and Children all Caught in one block demo.");
        for (int i=0; i<3 ; i++){
            try{
                switch (i) {
                    case 0 : giveExceptionC();
                    case 1 : giveExceptionB();
                    case 2 : giveExceptionA();
                }
            } catch (ExceptionA ea) {
                System.out.println("ExceptionA catch block.");
                System.out.println(ea);
            }

        }

    }

    public static void giveExceptionA() throws ExceptionA {
        throw new ExceptionA();
    }

    public static void giveExceptionB() throws ExceptionB {
        throw new ExceptionB();
    }
    public static void giveExceptionC() throws ExceptionC {
        throw new ExceptionC();
    }

}