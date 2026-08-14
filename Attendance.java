public class Attendance {
    public static void main(String[] args) {

        int[] attendance = {1, 1, 0, 1, 1, 1, 0};
        int presentDays = 0;

        for (int i = 0; i < 7; i++) {
            if (attendance[i] == 1) {
                presentDays++;
            }
        }

        double percentage = (presentDays / 7.0) * 100;

        System.out.println("Total Present Days : " + presentDays);
        System.out.println("Attendance Percentage : " + percentage + "%");

        if (percentage >= 75) {
            System.out.println("Eligible for Exam");
        } else {
            System.out.println("Not Eligible");
        }
    }
}