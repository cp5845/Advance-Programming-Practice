import college.course.Course;
import college.student.Student;

public class Main {
    public static void main(String[] args) {
        Student student = new Student(
                1001,
                "Ananya Sharma",
                "Computer Science",
                "ananya@example.com"
        );
        Course course = new Course(
                "CS201",
                "Object-Oriented Programming",
                4,
                "Dr. Ravi Kumar"
        );

        System.out.println("Student Information");
        student.displayInfo();
        System.out.println("\nCourse Information");
        course.displayInfo();
    }
}
