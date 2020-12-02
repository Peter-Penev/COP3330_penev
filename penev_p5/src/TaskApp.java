import java.io.*;
import java.util.Scanner;

public class TaskApp {
    public static void main(){
        Scanner scan = new Scanner(System.in);
        int finish = 0;
        while(finish != 3){//outer menu that determines if there is anything in the initial list
            System.out.println("Main Menu");
            System.out.println("---------");
            System.out.println();
            System.out.println("1) create a new list");
            System.out.println("2) load an existing list");
            System.out.println("3) quit");
            System.out.println();
            System.out.print(">");
            finish = scan.nextInt();
            if(finish == 1){//no initial tasks
                TaskItem[] list = new TaskItem[10000];
                int[] completed = new int[10000];
                for(int i = 0 ; i < 10000; i++){ //marks all tasks as not completed
                    completed[i] = 0;
                }
                int size = 0;
                System.out.println("new task list has been created");
                System.out.println();
                int finish2 = 0;
                while(finish2 != 8){// inner menu
                    System.out.println("List Operation Menu");
                    System.out.println("---------");
                    System.out.println();
                    System.out.println("1) view the list");
                    System.out.println("2) add an item");
                    System.out.println("3) edit an item");
                    System.out.println("4) remove an item");
                    System.out.println("5) mark an item as completed");
                    System.out.println("6) unmark an item as completed");
                    System.out.println("7) save the current list");
                    System.out.println("8) quit to the main menu");
                    System.out.println();
                    System.out.print(">");
                    finish2 = scan.nextInt();

                    if(finish2 == 1) {// prints out the tasks
                        TaskItem.print(list, size, completed);
                    }
                    if(finish2 == 2){// adds a task
                        System.out.print("Task title: ");//user input
                        String title;
                        scan.nextLine();
                        title = scan.nextLine();
                        System.out.print("Task description: ");
                        String description;
                        description = scan.nextLine();
                        System.out.print("Task due date (YYYY-MM-DD): ");
                        String date;
                        date = scan.nextLine();
                        TaskList.addTask(list, title, description, date, size); //adds the task and increases the size of the task list
                        size++;
                    }
                    if(finish2 == 3){ //edits a task
                        TaskItem.print(list, size, completed);
                        System.out.print("Which task will you edit?");
                        int edit = scan.nextInt();
                        try{
                            System.out.print("Enter a new title for task " + edit + ": "); //user input
                            String title;
                            scan.nextLine();
                            title = scan.nextLine();
                            System.out.print("Task description: ");
                            String description;
                            description = scan.nextLine();
                            System.out.print("Task due date (YYYY-MM-DD): ");
                            String date;
                            date = scan.nextLine();
                            if(edit >= size){
                                list[-1] = list[-1];
                            }
                            else{
                                TaskList.addTask(list, title, description, date, edit); //edits the task
                            }
                        }catch(ArrayIndexOutOfBoundsException e) {//catches if the user input is for a task that does not exist
                            System.out.println("Task does not exist\n");
                        }
                    }
                    if(finish2 == 4) { //removes a task
                        TaskItem.print(list, size, completed);
                        System.out.print("Which task will you remove?");
                        int edit = scan.nextInt();//user input for what task will be removed
                        try{
                            TaskList.remove(list, size, edit); //removes the target task
                            if(size == 0 || edit >= size){
                                list[-1] = list[-1];
                            }
                            size--;
                        }catch(ArrayIndexOutOfBoundsException e){//catches if the task that the user inputs exits
                            System.out.println("Task does not exist");
                        }
                        System.out.println();
                    }
                    if(finish2 == 5){//completes a task
                        TaskItem.Uprint(list, size, completed);
                        System.out.print("Which task will you mark as completed?");
                        int edit = scan.nextInt();//user input
                        try{
                            if(edit < size){
                                completed[edit] = 1; //completes a task
                            }
                            else{
                                completed[-1] = -1;
                            }
                        }catch(ArrayIndexOutOfBoundsException e){ //catches if the user inputs a task that does not exist
                            System.out.println("Task does not exist");
                        }
                        System.out.println();
                    }
                    if(finish2 == 6){//uncompletes a task
                        TaskItem.Cprint(list, size, completed);
                        System.out.print("Which task will you unmark as completed?");
                        int edit = scan.nextInt();//user input
                        try{
                            if(edit < size){
                                completed[edit] = 0;
                            }
                            else{
                                completed[-1] = -1;
                            }
                        }catch(ArrayIndexOutOfBoundsException e){//catches if the user inputs a task that does not exist
                            System.out.println("Task does not exist");
                        }
                        System.out.println();
                    }
                    if(finish2 == 7) { //saves file
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
                                    fw.write(list[i].Title + " " + list[i].Description + " " + list[i].Date + " " + completed[i] + "\n");
                                }
                                fw.close();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                            System.out.println("task list has been saved");
                        }
                        System.out.println();
                    }
                    if(finish2 == 8){//exit menu
                        System.out.println();
                    }
                }
            }
            if(finish == 2){
                TaskItem[] list = new TaskItem[10000];
                int[] completed = new int[10000];
                int size = 0;
                String filename;
                int good = 1;
                System.out.print("Enter the filename to load:");
                filename = scan.next();
                int check = TaskList.check(filename);
                if(check == 1){
                    try { //loads all of the tasks in the file
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
                            int temp5 = Integer.parseInt(temp);
                            TaskList.addTask(list, temp2, temp3, temp4, size);
                            completed[size] = temp5;
                            size++;
                        }
                        br.close();
                    } catch (IOException e) { //catches if the file does not exist
                        e.printStackTrace();
                    }
                    System.out.println("task list has been loaded");
                    System.out.println();
                }
                else{
                    System.out.println("file does not exist");
                    System.out.println();
                    good = 0;//stops the user from entering the menu if the file does not exist
                }
                int finish2 = 0;
                while(finish2 != 8 && good == 1){//same menu as above
                    System.out.println("List Operation Menu");
                    System.out.println("---------");
                    System.out.println();
                    System.out.println("1) view the list");
                    System.out.println("2) add an item");
                    System.out.println("3) edit an item");
                    System.out.println("4) remove an item");
                    System.out.println("5) mark an item as completed");
                    System.out.println("6) unmark an item as completed");
                    System.out.println("7) save the current list");
                    System.out.println("8) quit to the main menu");
                    System.out.println();
                    System.out.print(">");
                    finish2 = scan.nextInt();

                    if(finish2 == 1) {
                        TaskItem.print(list, size, completed);
                    }
                    if(finish2 == 2){
                        System.out.print("Task title: ");
                        String title;
                        scan.nextLine();
                        title = scan.nextLine();
                        System.out.print("Task description: ");
                        String description;
                        description = scan.nextLine();
                        System.out.print("Task due date (YYYY-MM-DD): ");
                        String date;
                        date = scan.nextLine();
                        TaskList.addTask(list, title, description, date, size);
                        size++;
                    }
                    if(finish2 == 3){
                        TaskItem.print(list, size, completed);
                        System.out.print("Which task will you edit?");
                        int edit = scan.nextInt();
                        try{
                            System.out.print("Enter a new title for task " + edit + ": ");
                            String title;
                            scan.nextLine();
                            title = scan.nextLine();
                            System.out.print("Task description: ");
                            String description;
                            description = scan.nextLine();
                            System.out.print("Task due date (YYYY-MM-DD): ");
                            String date;
                            date = scan.nextLine();
                            if(edit >= size){
                                list[-1] = list[-1];
                            }
                            else{
                                TaskList.addTask(list, title, description, date, edit);
                            }
                        }catch(ArrayIndexOutOfBoundsException e) {
                            System.out.println("Task does not exist\n");
                        }
                    }
                    if(finish2 == 4) {
                        TaskItem.print(list, size, completed);
                        System.out.print("Which task will you remove?");
                        int edit = scan.nextInt();
                        try{
                            TaskList.remove(list, size, edit);
                            if(size == 0 || edit >= size){
                                list[-1] = list[-1];
                            }
                            size--;
                        }catch(ArrayIndexOutOfBoundsException e){
                            System.out.println("Task does not exist");
                        }
                        System.out.println();
                    }
                    if(finish2 == 5){
                        TaskItem.Uprint(list, size, completed);
                        System.out.print("Which task will you mark as completed?");
                        int edit = scan.nextInt();
                        try{
                            if(edit < size){
                                completed[edit] = 1;
                            }
                            else{
                                completed[-1] = -1;
                            }
                        }catch(ArrayIndexOutOfBoundsException e){
                            System.out.println("Task does not exist");
                        }
                        System.out.println();
                    }
                    if(finish2 == 6){
                        TaskItem.Cprint(list, size, completed);
                        System.out.print("Which task will you unmark as completed?");
                        int edit = scan.nextInt();
                        try{
                            if(edit < size){
                                completed[edit] = 0;
                            }
                            else{
                                completed[-1] = -1;
                            }
                        }catch(ArrayIndexOutOfBoundsException e){
                            System.out.println("Task does not exist");
                        }
                        System.out.println();
                    }
                    if(finish2 == 7) {
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
                                    fw.write(list[i].Title + " " + list[i].Description + " " + list[i].Date + " " + completed[i] + "\n");
                                }
                                fw.close();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                            System.out.println("task list has been saved");
                        }
                        System.out.println();
                    }
                    if(finish2 == 8){
                        System.out.println();
                    }
                }
            }
        }
    }
}
