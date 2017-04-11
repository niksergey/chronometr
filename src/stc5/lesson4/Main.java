package stc5.lesson4;

import java.util.Date;

public class Main {

    public static void main(String[] args)  {
        TimeKeeper timeKeeper = new TimeKeeper();

        Chronometr chronometr = new Chronometr("Ticker", 1000, timeKeeper);
        Printer printer5 = new Printer("5 sec Printer", 5, timeKeeper);
        Printer printer7 = new Printer("7 sec Printer", 7, timeKeeper);

        try {
            printer5.t.join();
            printer7.t.join();
            chronometr.t.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
