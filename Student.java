public class Student{
    String name;
    int rollNo;
    String dept;
    public static void main(String[] args){
        Student s = new Student();
        s.name = "Chinmay";
        s.rollNo = 17;
        s.dept = "CSE";
        System.out.println("Student Name: " + s.name);
        System.out.println("Roll Number: " + s.rollNo);
        System.out.println("Department: " + s.dept);
    }
}