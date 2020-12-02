import java.util.Scanner;

public class App {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int selection = 0;
        while(selection != 3){
            System.out.println("Select Your Application");
            System.out.println("-----------------------");
            System.out.println();
            System.out.println("1) task list");
            System.out.println("2) contact list");
            System.out.println("3) quit");
            System.out.println();
            System.out.print("> ");
            selection = scan.nextInt();
            System.out.println();
            if(selection == 1){
                TaskApp.main();
            }
            else if(selection == 2){
                ContactApp.main();
            }
        }
    }
}
