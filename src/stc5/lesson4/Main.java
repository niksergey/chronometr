package stc5.lesson4;

import java.util.Date;

public class Main {

    public static void main(String[] args)  {
        Thread t = Thread.currentThread();

	    new Chronometr("1 sec ", 1);
        new Chronometr("7 sec", 7);
    }
}
