import java.lang.Math;
public class Pyramid extends Shape3D{
    double length;
    double width;
    double height;

    Pyramid(double a, double b, double c){
        length = a;
        width = b;
        height = c;
    }

    public String getName(){
        return "pyramid";
    }

    public double getArea(){
        return length*width+length*Math.sqrt((width/2)*(width/2)+height*height)+width*Math.sqrt((length/2)*(length/2)+height*height);
    }

    public double getVolume(){
        return length*width*height/3;
    }
}
