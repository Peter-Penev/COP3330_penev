import java.lang.Math;
public class Sphere extends Shape3D{
    double radius;

    Sphere(double a){
        radius = a;
    }

    public String getName(){
        return "sphere";
    }

    public double getArea(){
        return 4*Math.PI*radius*radius;
    }

    public double getVolume(){
        return 4.0/3.0*Math.PI*radius*radius*radius;
    }
}
