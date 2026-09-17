package college.student;

public class Student {
    private final int studentId;
    private final String name;
    private final String department;
    private final String email;

    public Student(int studentId, String name, String department, String email) {
        this.studentId = studentId;
        this.name = name;
        this.department = department;
        this.email = email;
    }

    public int getStudentId() {
        return studentId;
    }

    public String getName() {
        return name;
    }

    public String getDepartment() {
        return department;
    }

    public String getEmail() {
        return email;
    }

    public void displayInfo() {
        System.out.println("Student ID: " + studentId);
        System.out.println("Name: " + name);
        System.out.println("Department: " + department);
        System.out.println("Email: " + email);
    }
}
