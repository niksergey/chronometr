package stc5.lesson4;

import java.util.Date;

/**
 * Created by sergey on 06.04.17.
 */
public class Chronometr implements Runnable {
    Thread t;
    private TimeKeeper tk;
    private Date startTime;
    private int timeSleep;
    private String threadName;

    public Chronometr(String threadName, int sleepInterval, TimeKeeper tk) {
        t = new Thread(this, threadName);
        this.tk = tk;
        this.threadName = threadName;
        startTime = new Date();
        timeSleep = sleepInterval;
        t.start();
    }

    public void run() {
        long secPassed;
        try {
            for (int i = 0; i < 31; i++) {
                synchronized (tk) {
                    Date currentDate = new Date();
                    secPassed = (currentDate.getTime() - startTime.getTime()) / 1000;
                    System.out.println("[" + new Date() + "] " + threadName + ", seconds: " + secPassed);
                    tk.updatePassedSeconds((int)secPassed);
                    tk.notifyAll();
                }
                Thread.sleep(timeSleep);
            }
        } catch (InterruptedException e) {
            System.out.println(t.getName() + " прерван");
        }
    }
}

