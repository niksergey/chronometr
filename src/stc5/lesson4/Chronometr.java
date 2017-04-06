package stc5.lesson4;

import java.util.Date;

/**
 * Created by sergey on 06.04.17.
 */
public class Chronometr implements Runnable {
    Thread t;
    Date startTime;
    int timeSleep;

    public Chronometr(String threadName, int sleepInterval) {
        t = new Thread(this, threadName);
        startTime = new Date();
        timeSleep = sleepInterval * 1000;
        t.start();
    }

    public void run() {
        long secPassed;
        try {
            while(true) {
                Date currentDate = new Date();
                secPassed= (currentDate.getTime() - startTime.getTime()) / 1000;
                System.out.println("In thread " + t + " " + secPassed);
                Thread.sleep(timeSleep);
            }
        } catch (InterruptedException e) {
            System.out.println("Child " + t.getName() + " interrupted");
        }
    }
}

class Printer implements Runnable {
    Thread t;
    int timeSleep;

    public Printer(String threadName, int sleepInterval) {
        t = new Thread(threadName);
        timeSleep = sleepInterval * 1000;
        t.start();
    }

    public void run() {
        while(true) {
            System.out.println();
            try {
                Thread.sleep(timeSleep);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}