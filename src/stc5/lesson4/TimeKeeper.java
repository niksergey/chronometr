package stc5.lesson4;

class TimeKeeper {
    private volatile int passedSeconds; //Atomic or volatile

    TimeKeeper() {
        passedSeconds = -1;
    }

    int getPassedSeconds() {
        return passedSeconds;
    }

    void updatePassedSeconds(int i) {
        passedSeconds = i;
    }
}