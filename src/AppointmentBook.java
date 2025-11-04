public class AppointmentBook {
    private final boolean[][] schedule;

    public AppointmentBook(boolean[][] schedule) {
        this.schedule = schedule;
    }

    private boolean isMinuteFree(int period, int minute) {
        return !schedule[period - 1][minute];
    }

    private void reserveBlock(int period, int startMinute, int duration) {
        for (int i = startMinute; i < startMinute + duration; i++) {
            schedule[period - 1][i] = true;
        }
    }

    public int findFreeBlock(int period, int duration) {
        int block = 0;

        for (int i = 0; i < 60; i++) {
            if (isMinuteFree(period, i)) {
                block++;

                if (block == duration) {
                    return i - duration + 1;
                }
            } else {
                block = 0;
            }
        }

        return -1;
    }

    public boolean makeAppointment(int startPeriod, int endPeriod,
                                   int duration) {
        for (int i = startPeriod; i <= endPeriod; i++) {

            int freeBlockStart = findFreeBlock(i, duration);

            if (freeBlockStart != -1) {
                reserveBlock(i, freeBlockStart, duration);
                return true;
            }
        }

        return false;
    }

    // Helper method from the images for testing/printing
    public void printPeriod(int period) {
        System.out.println("Period " + period + " schedule:");
        for (int i = 0; i < schedule[period - 1].length; i++) {
            System.out.println(i + " " + schedule[period - 1][i]);
        }
    }
}
