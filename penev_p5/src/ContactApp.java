import java.io.*;
import java.util.Scanner;

public class ContactApp {
    public static void main(){
        Scanner scan = new Scanner(System.in);
        int finish = 0;
        while(finish != 3){
            System.out.println("Main Menu");
            System.out.println("---------");
            System.out.println();
            System.out.println("1) create a new list");
            System.out.println("2) load an existing list");
            System.out.println("3) quit");
            System.out.println();
            System.out.print(">");
            finish = scan.nextInt();
            if(finish == 1){
                ContactItem[] list = new ContactItem[10000];
                int size = 0;
                System.out.println("new contact list has been created");
                System.out.println();
                int finish2 = 0;
                while(finish2 != 6){
                    System.out.println("List Operation Menu");
                    System.out.println("---------");
                    System.out.println();
                    System.out.println("1) view the list");
                    System.out.println("2) add an item");
                    System.out.println("3) edit an item");
                    System.out.println("4) remove an item");
                    System.out.println("5) save the current list");
                    System.out.println("6) quit to the main menu");
                    System.out.println();
                    System.out.print(">");
                    finish2 = scan.nextInt();

                    if(finish2 == 1) {
                        ContactItem.CCprint(list, size);
                    }
                    if(finish2 == 2){
                        int temp;
                        System.out.print("First name: ");
                        String first;
                        scan.nextLine();
                        first = scan.nextLine();
                        System.out.print("Last name: ");
                        String last;
                        last = scan.nextLine();
                        System.out.print("Phone number (xxx-xxx-xxxx): ");
                        String phone;
                        phone = scan.nextLine();
                        System.out.print("Email address (x@y.z): ");
                        String email;
                        email = scan.nextLine();
                        temp = ContactItem.CaddTask(list, first, last, phone, email, size);
                        if(temp != 1){
                            size--;
                        }
                        size++;
                    }
                    if(finish2 == 3){
                        ContactItem.CCprint(list, size);
                        System.out.print("Which contact will you edit?");
                        int edit = scan.nextInt();
                        try{
                            System.out.print("Enter a new first name for contact " + edit + ": ");
                            String first;
                            scan.nextLine();
                            first = scan.nextLine();
                            System.out.print("Enter a new last name for contact " + edit + ": ");
                            String last;
                            last = scan.nextLine();
                            System.out.print("Enter a new phone number (xxx-xxx-xxxx) for contact " + edit + ": ");
                            String phone;
                            phone = scan.nextLine();
                            System.out.print("Enter a new email address (x@y.z) for contact " + edit + ": ");
                            String email;
                            email = scan.nextLine();
                            if(edit >= size){
                                list[-1] = list[-1];
                            }
                            else{
                                ContactItem.CaddTask(list, first, last, phone, email, edit);
                            }
                        }catch(ArrayIndexOutOfBoundsException e) {
                            System.out.println("Contact does not exist\n");
                        }
                    }
                    if(finish2 == 4) {
                        ContactItem.CCprint(list, size);
                        System.out.print("Which contact will you remove?");
                        int edit = scan.nextInt();
                        try{
                            ContactList.Cremove(list, size, edit);
                            if(size == 0 || edit >= size){
                                list[-1] = list[-1];
                            }
                            size--;
                        }catch(ArrayIndexOutOfBoundsException e){
                            System.out.println("Contact does not exist");
                        }
                        System.out.println();
                    }
                    if(finish2 == 5) {
                        System.out.print("Enter the filename to save as:");
                        scan.nextLine();
                        String name = scan.nextLine();
                        if(name.length() == 0){
                            System.out.println("Invalid Name");
                        }
                        else{
                            try {
                                FileWriter fw = new FileWriter(name);
                                for(int i = 0; i < size; i++){
                                    fw.write(list[i].First + " " + list[i].Last + " " + list[i].Phone + " " + list[i].Email + "\n");
                                }
                                fw.close();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                            System.out.println("contact list has been saved");
                        }
                        System.out.println();
                    }
                    if(finish2 == 6){
                        System.out.println();
                    }
                }
            }
            if(finish == 2){
                ContactItem[] list = new ContactItem[10000];
                int size = 0;
                String filename;
                int good = 1;
                System.out.print("Enter the filename to load:");
                filename = scan.next();
                int check = ContactList.Ccheck(filename);
                if(check == 1){
                    try {
                        BufferedReader br = new BufferedReader(new FileReader(filename));
                        String temp;
                        while((temp = br.readLine()) != null){
                            int x = temp.indexOf(' ');
                            String temp2 = temp.substring(0, x);
                            temp = temp.substring(x+1);
                            x = temp.indexOf(' ');
                            String temp3 = temp.substring(0, x);
                            temp = temp.substring(x+1);
                            x = temp.indexOf(' ');
                            String temp4 = temp.substring(0, x);
                            temp = temp.substring(x+1);
                            String temp5 = temp.substring(0, x);
                            ContactItem.CaddTask(list, temp2, temp3, temp4, temp5, size);
                            size++;
                        }
                        br.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    System.out.println("contact list has been loaded");
                    System.out.println();
                }
                else{
                    System.out.println("file does not exist");
                    System.out.println();
                    good = 0;
                }
                int finish2 = 0;
                while(finish2 != 6 && good == 1){
                    System.out.println("List Operation Menu");
                    System.out.println("---------");
                    System.out.println();
                    System.out.println("1) view the list");
                    System.out.println("2) add an item");
                    System.out.println("3) edit an item");
                    System.out.println("4) remove an item");
                    System.out.println("5) save the current list");
                    System.out.println("6) quit to the main menu");
                    System.out.println();
                    System.out.print(">");
                    finish2 = scan.nextInt();

                    if(finish2 == 1) {
                        ContactItem.CCprint(list, size);
                    }
                    if(finish2 == 2){
                        int temp;
                        System.out.print("First name: ");
                        String first;
                        scan.nextLine();
                        first = scan.nextLine();
                        System.out.print("Last name: ");
                        String last;
                        last = scan.nextLine();
                        System.out.print("Phone number (xxx-xxx-xxxx): ");
                        String phone;
                        phone = scan.nextLine();
                        System.out.print("Email address (x@y.z): ");
                        String email;
                        email = scan.nextLine();
                        temp = ContactItem.CaddTask(list, first, last, phone, email, size);
                        if(temp != 1){
                            size--;
                        }
                        size++;
                    }
                    if(finish2 == 3){
                        ContactItem.CCprint(list, size);
                        System.out.print("Which contact will you edit?");
                        int edit = scan.nextInt();
                        try{
                            System.out.print("Enter a new first name for contact " + edit + ": ");
                            String first;
                            scan.nextLine();
                            first = scan.nextLine();
                            System.out.print("Enter a new last name for contact " + edit + ": ");
                            String last;
                            last = scan.nextLine();
                            System.out.print("Enter a new phone number (xxx-xxx-xxxx) for contact " + edit + ": ");
                            String phone;
                            phone = scan.nextLine();
                            System.out.print("Enter a new email address (x@y.z) for contact " + edit + ": ");
                            String email;
                            email = scan.nextLine();
                            if(edit >= size){
                                list[-1] = list[-1];
                            }
                            else{
                                ContactItem.CaddTask(list, first, last, phone, email, edit);
                            }
                        }catch(ArrayIndexOutOfBoundsException e) {
                            System.out.println("Contact does not exist\n");
                        }
                    }
                    if(finish2 == 4) {
                        ContactItem.CCprint(list, size);
                        System.out.print("Which contact will you remove?");
                        int edit = scan.nextInt();
                        try{
                            ContactList.Cremove(list, size, edit);
                            if(size == 0 || edit >= size){
                                list[-1] = list[-1];
                            }
                            size--;
                        }catch(ArrayIndexOutOfBoundsException e){
                            System.out.println("Contact does not exist");
                        }
                        System.out.println();
                    }
                    if(finish2 == 5) {
                        System.out.print("Enter the filename to save as:");
                        scan.nextLine();
                        String name = scan.nextLine();
                        if(name.length() == 0){
                            System.out.println("Invalid Name");
                        }
                        else{
                            try {
                                FileWriter fw = new FileWriter(name);
                                for(int i = 0; i < size; i++){
                                    fw.write(list[i].First + " " + list[i].Last + " " + list[i].Phone + " " + list[i].Email + "\n");
                                }
                                fw.close();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                            System.out.println("contact list has been saved");
                        }
                        System.out.println();
                    }
                    if(finish2 == 6){
                        System.out.println();
                    }
                }
            }
        }
    }
}
