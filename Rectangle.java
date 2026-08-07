class Rectangle{
    double length;
    double breadth;
    void area(){
        double a = length * breadth;
        System.out.println("Area = " + a);
    }
        public static void main(String[] args){
        Rectangle r = new Rectangle();
        r.length = 12;
        r.breadth = 8;
        r.area();
    }
}