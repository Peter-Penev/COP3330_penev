public class Cube extends Shape3D{
    double length;

    Cube(double a){
        length = a;
    }

    public String getName(){
        return "cube";
    }

    public double getArea(){
        return 6*length*length;
    }

    public double getVolume(){
        return length*length*length;
    }
}
