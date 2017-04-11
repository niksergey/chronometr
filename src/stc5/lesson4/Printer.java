package stc5.lesson4;

/**
 * Created by sergey on 06.04.17.
 */

import java.util.Date;

class Printer implements Runnable {
    Thread t;
    private TimeKeeper tk;
    private int period;
    private String threadName;

    Printer(String threadName, int period, TimeKeeper tk) {
        t = new Thread(this, threadName);
        this.tk = tk;
        this.period = period;
        this.threadName = threadName;
        t.start();
    }

    public void run() {
        for (int i = 0; i < 30; i++) {
            synchronized (tk) {
                try {
                    int passedSeconds = tk.getPassedSeconds();
                    if (passedSeconds % period == 0)
                        System.out.println("[" + new Date() + "] " + threadName + ", seconds: " + passedSeconds);
                    tk.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
