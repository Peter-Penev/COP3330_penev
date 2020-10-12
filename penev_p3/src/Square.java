public class Square extends Shape2D{

    double length;

    Square(double a){
        length = a;
    }

    public String getName(){
        return "square";
    }

    public double getArea(){
        return length*length;
    }

}
