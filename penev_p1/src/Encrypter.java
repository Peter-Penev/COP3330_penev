public class Encrypter {
    public static void main(String[] args) {

    }
    public static String encrypt(String initial) {
        int integer = Integer.parseInt(initial); // converts the string to an int

        int thousandth = integer / 1000;//splits the int to each individual digit
        int hundredth = integer%1000/100;
        int tenth = integer%100/10;
        int ones = integer%10;

        thousandth = addseven(thousandth); //adds seven and then checks if the digit is 10 or greater, where if it is it subtracts 10
        hundredth = addseven(hundredth);
        tenth = addseven(tenth);
        ones = addseven(ones);

        int temp = 0;

        temp = thousandth; // swaps 1st and 3rd digit
        thousandth = tenth;
        tenth = temp;

        temp = hundredth; // swaps 2nd and 4th digit
        hundredth = ones;
        ones = temp;

        integer = thousandth*1000 + hundredth*100 + tenth*10 + ones; // combines all digits to an single int

        String finale = Integer.toString(integer); //converts int to string

        if(thousandth == 0 && hundredth == 0 && tenth == 0){ //makes sure to add any leading zeros
            finale = "000" + finale;
        }
        else if(thousandth == 0 && hundredth == 0){
            finale = "00" + finale;
        }
        else if(thousandth == 0){
            finale = "0" + finale;
        }

        return finale;
    }
    public static int addseven(int input){
        input = input + 7;
        if(input>9){
            input = input - 10;
        }
        return input;
    }
}
