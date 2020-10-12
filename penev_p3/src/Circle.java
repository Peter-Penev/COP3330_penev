import java.lang.Math;
public class Circle extends Shape2D{
    double radius;

    Circle(double a){
        radius = a;
    }

    public String getName(){
        return "circle";
    }

    public double getArea(){
        return Math.PI*radius*radius;
    }
}
