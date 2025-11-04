import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        boolean[][] schedule = new boolean[8][60];
        AppointmentBook b = new AppointmentBook(schedule);

        for (int i = 25; i < 30; i++) schedule[1][i] = true;
        for (int i = 0; i < 15; i++) schedule[2][i] = true;
        for (int i = 41; i < 60; i++) schedule[2][i] = true;
        for (int i = 5; i < 30; i++) schedule[3][i] = true;
        for (int i = 44; i < 60; i++) schedule[3][i] = true;

        System.out.println(reads());
    }

    public static boolean[][] readSchedule(String lines) {
        Scanner s = new Scanner(lines);
        boolean[][] schedule = new boolean[8][60];

        for (int i = 0; i < schedule.length; i++) {
            for (int j = 0; j < schedule[i].length; j++) {
                schedule[i][j] = s.nextBoolean();
            }
        }

        return schedule;
    }

    public static int reads() throws FileNotFoundException{
        int meetings = 0;
        File f = new File("Schedules.txt");
        Scanner s = new Scanner(f);
        String schedule = "";

        while (s.hasNext()) {
            while (s.hasNextBoolean()) {
                schedule += s.nextBoolean() + " ";
            }

            AppointmentBook a = new AppointmentBook(readSchedule(schedule));
            schedule = "";

            if (a.makeAppointment(s.nextInt(), s.nextInt(), s.nextInt())){
                meetings++;
            }
        }
        return meetings;
    }
}
