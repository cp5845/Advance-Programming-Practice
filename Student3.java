class Student3{
    String name;
    int age;
    void display(){
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
    }
    public static void main(String[] args){
        Student3 s1 = new Student3();
        Student3 s2 = new Student3();
        s1.name = "Chinmay";
        s1.age = 18;
        s2.name = "Bharadwaj";
        s2.age = 19;
        s1.display();
        System.out.println();
        s2.display();
    }
}