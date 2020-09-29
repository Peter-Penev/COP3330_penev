import java.util.*;

public class BodyMassIndex {

    double bmi;

    BodyMassIndex(double height, double weight){
        this.bmi = findBMI(height, weight); //calls the findBMI function and the result is sent back to the App function
    }
    public static double findBMI(double height, double weight){
        return 703 * weight / (height * height); //finds the BMI based on the height and weight
    }
    public static String findBMICategory(BodyMassIndex bmi){ // determines in what category the bmi falls under
        if(bmi.bmi < 18.5){ // definition of underweight
            return "Underweight";
        }
        else if(bmi.bmi <= 24.9){ // definition of normal weight
            return "Normal weight";
        }
        else if(bmi.bmi >= 25 && bmi.bmi <= 29.9){ // definition of overweight
            return "Overweight";
        }
        else { // definition of obese
            return "Obesity";
        }
    }
    public static boolean moreInput(){ // determines if the user wants to add more info
        System.out.println("Enter Y or N"); //asks the user if they want to input more info
        Scanner scan = new Scanner(System.in);
        String result = scan.next();
        if(result.equals("Y")){
            return true; //returns true if the user wants to add more info
        }
        else{
            return false; //return false if the user does not want to add more info
        }
    }
    public static double getUserHeight(){ //gets the target user's height
        Scanner scan = new Scanner(System.in);
        int good = 0;
        double height = 0;
        while(good == 0){ //leaves loop when good is not 0
            System.out.println("Enter your positive height in inches.");
            height = scan.nextDouble(); //sets the height equal to the next input
            scan.nextLine();
            if(height > 0){ //checks if the height is positive
                good = 1; //if the height is positive, sets good to 1 to break the while loop
            }
            else{
                System.out.println("I said enter a POSITIVE height."); // means that the user entered a negative height and makes the loop go again until a positive number is entered
            }
        }
        return height;
    }
    public static double getUserWeight(){ //gets the target user's weight
        Scanner scan = new Scanner(System.in);
        int good = 0;
        double weight = 0;
        while(good == 0){//leaves loop when good is not 0
            System.out.println("Enter your positive weight in pounds.");
            weight = scan.nextDouble();//sets the weight equal to the next input
            scan.nextLine();
            if(weight > 0){ //checks if the weight is positive
                good = 1;//if the weight is positive, sets good to 1 to break the while loop
            }
            else{
                System.out.println("I said enter a POSITIVE weight.");// means that the user entered a negative weight and makes the loop go again until a positive number is entered
            }
        }
        return weight;
    }
    public static void displayBmiInfo(BodyMassIndex bmi){
        System.out.println("Your BMI score is: " + bmi.bmi); //prints out the bmi score
        String category = findBMICategory(bmi);//calls the function to find the category of the given bmi score
        System.out.println("Your BMI category is " + category); //prints out the category of the bmi score
    }
    public static void displayBmiStatistics(ArrayList<BodyMassIndex> bmiData){
        int length = bmiData.size();
        double sum = 0;
        for(int i = 0; i < length; i++){
            sum = sum + bmiData.get(i).bmi; //loops through the full arraylist and sums up the values of the bmi
        }
        double answer = sum/(length*1.0); //divides the sum of the bmi values by the number of bmi values to get the average
        System.out.println("The average BMI score is: " + answer); //prints out the average bmi score
    }
}
