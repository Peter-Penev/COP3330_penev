public class Triangle extends Shape2D{

    double length;
    double height;

    Triangle(double a, double b){
        length = a;
        height = b;
    }

    public String getName(){
        return "triangle";
    }

    public double getArea(){
        return length*height/2;
    }
}
