public class Decrypter {
    public static void main(String[] args){

    }
    public static String decrypt(String input){
        int integer = Integer.parseInt(input); // converts the string to an int

        int thousandth = integer / 1000;//splits the int to each individual digit
        int hundredth = integer%1000/100;
        int tenth = integer%100/10;
        int ones = integer%10;

        int temp;

        temp = thousandth;// switches the 1st and 3rd digit
        thousandth = tenth;
        tenth = temp;

        temp = hundredth;// switches the 2nd and 4th digit
        hundredth = ones;
        ones = temp;

        thousandth = subtractseven(thousandth); // subtracts seven from each digit and if the digit is negative, add 10
        hundredth = subtractseven(hundredth);
        tenth = subtractseven(tenth);
        ones = subtractseven(ones);

        integer = thousandth*1000 + hundredth*100 + tenth*10 + ones; //combines the digits to one int

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

    public static int subtractseven(int input) {
        input = input - 7;
        if(input < 0) {
            input = input + 10;
        }
        return input;
    }
}
