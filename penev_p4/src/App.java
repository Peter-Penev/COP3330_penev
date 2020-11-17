import java.io.*;
import java.util.Scanner;

public class App {
    public static void main(String[] args){
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
                TaskItem list[] = new TaskItem[10000];
                int completed[] = new int[10000];
                for(int i = 0 ; i < 10000; i++){
                    completed[i] = 0;
                }
                int size = 0;
                System.out.println("new task list has been created");
                System.out.println();
                int finish2 = 0;
                while(finish2 != 8){
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
                        TaskList.output(list, size, completed);
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
                        TaskList.output(list, size, completed);
                        System.out.print("Which task will you edit?");
                        int edit = scan.nextInt();
                        if(edit < 0 || edit >= size){
                            System.out.println("Task does not exist");
                        }
                        else{
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
                            TaskList.addTask(list, title, description, date, edit);
                        }
                    }
                    if(finish2 == 4) {
                        TaskList.output(list, size, completed);
                        System.out.print("Which task will you remove?");
                        int edit = scan.nextInt();
                        if(edit < 0 || edit >= size){
                            System.out.println("Task does not exist");
                            System.out.println();
                        }
                        else{
                            TaskList.remove(list, size, edit);
                            size--;
                            System.out.println();
                        }
                    }
                    if(finish2 == 5){
                        TaskList.Uoutput(list, size, completed);
                        System.out.print("Which task will you mark as completed?");
                        int edit = scan.nextInt();
                        if(edit < 0 || edit >= size || completed[edit] == 1){
                            if(edit < 0 || edit >= size){
                                System.out.println("Task does not exist");
                            }
                            else{
                                System.out.println("Task is already completed");
                            }
                        }
                        else{
                            completed[edit] = 1;
                        }
                        System.out.println();
                    }
                    if(finish2 == 6){
                        TaskList.Coutput(list, size, completed);
                        System.out.print("Which task will you unmark as completed?");
                        int edit = scan.nextInt();
                        if(edit < 0 || edit >= size || completed[edit] == 0){
                            if(edit < 0 || edit >= size){
                                System.out.println("Task does not exist");
                            }
                            else{
                                System.out.println("Task is not completed");
                            }
                        }
                        else{
                            completed[edit] = 0;
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
            if(finish == 2){
                TaskItem list[] = new TaskItem[10000];
                int completed[] = new int[10000];
                int size = 0;
                String filename;
                int good = 1;
                System.out.print("Enter the filename to load:");
                filename = scan.next();
                int check = TaskList.check(filename);
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
                            int temp5 = Integer.parseInt(temp);
                            TaskList.addTask(list, temp2, temp3, temp4, size);
                            completed[size] = temp5;
                            size++;
                        }
                        br.close();
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    System.out.println("task list has been loaded");
                    System.out.println();
                }
                else{
                    System.out.println("file does not exist");
                    System.out.println();
                    good = 0;
                }
                int finish2 = 0;
                while(finish2 != 8 && good == 1){
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
                        TaskList.output(list, size, completed);
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
                        TaskList.output(list, size, completed);
                        System.out.print("Which task will you edit?");
                        int edit = scan.nextInt();
                        if(edit < 0 || edit >= size){
                            System.out.println("Task does not exist");
                        }
                        else{
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
                            TaskList.addTask(list, title, description, date, edit);
                        }
                    }
                    if(finish2 == 4) {
                        TaskList.output(list, size, completed);
                        System.out.print("Which task will you remove?");
                        int edit = scan.nextInt();
                        if(edit < 0 || edit >= size){
                            System.out.println("Task does not exist");
                            System.out.println();
                        }
                        else{
                            TaskList.remove(list, size, edit);
                            size--;
                            System.out.println();
                        }
                    }
                    if(finish2 == 5){
                        TaskList.Uoutput(list, size, completed);
                        System.out.print("Which task will you mark as completed?");
                        int edit = scan.nextInt();
                        if(edit < 0 || edit >= size || completed[edit] == 1){
                            if(edit < 0 || edit >= size){
                                System.out.println("Task does not exist");
                            }
                            else{
                                System.out.println("Task is already completed");
                            }
                        }
                        else{
                            completed[edit] = 1;
                        }
                        System.out.println();
                    }
                    if(finish2 == 6){
                        TaskList.Coutput(list, size, completed);
                        System.out.print("Which task will you unmark as completed?");
                        int edit = scan.nextInt();
                        if(edit < 0 || edit >= size || completed[edit] == 0){
                            if(edit < 0 || edit >= size){
                                System.out.println("Task does not exist");
                            }
                            else{
                                System.out.println("Task is not completed");
                            }
                        }
                        else{
                            completed[edit] = 0;
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
