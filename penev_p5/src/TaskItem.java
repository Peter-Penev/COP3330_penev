public class TaskItem extends TaskList{

    String Title;
    String Description;
    String Date;

    TaskItem(String title, String description, String date){
        Title = title;
        Description = description;
        Date = date;
    }

    public static void print(TaskItem[] a, int size, int[] completed){
        System.out.println("Current Tasks");
        System.out.println("-------------");
        System.out.println();
        for(int i = 0; i < size;i++){
            if(completed[i] == 1){
                System.out.println(i + ") *** [" + a[i].Date + "] " + a[i].Title + ": " + a[i].Description);
            }
            else{
                System.out.println(i + ") [" + a[i].Date + "] " + a[i].Title + ": " + a[i].Description);
            }
        }
        System.out.println();
    }

    public static void Uprint(TaskItem[] a, int size, int[] completed){
        System.out.println("Uncompleted Tasks");
        System.out.println("-------------");
        System.out.println();
        for(int i = 0; i < size;i++){
            if(completed[i] == 1){
            }
            else{
                System.out.println(i + ") [" + a[i].Date + "] " + a[i].Title + ": " + a[i].Description);
            }
        }
        System.out.println();
    }

    public static void Cprint(TaskItem[] a, int size, int[] completed){
        System.out.println("Completed Tasks");
        System.out.println("-------------");
        System.out.println();
        for(int i = 0; i < size;i++){
            if(completed[i] == 0){
            }
            else{
                System.out.println(i + ") [" + a[i].Date + "] " + a[i].Title + ": " + a[i].Description);
            }
        }
        System.out.println();
    }

    public static int createTask(String title, String description, String date){
        if(title.equals("")){
            System.out.println("WARNING: title must be at least 1 character long; task not created");
            System.out.println();
            return 0;
        }
        else if(dateValid(date) == 0){
            System.out.println("WARNING: invalid due date; task not created");
            System.out.println();
            return -1;
        }
        else{
            System.out.println();
            TaskItem task = new TaskItem(title, description, date);
            return 1;
        }
    }

    public static int dateValid(String date){
        if(date.length() == 10){
            if(date.charAt(4) == '-' && date.charAt(7) == '-'){
                for(int i = 0; i < 10; i++){
                    if(i != 4 && i != 7){
                        if(date.charAt(i) >= 48 && date.charAt(i) <= 57){
                        }
                        else{
                            return 0;
                        }
                    }
                }
                if(Integer.parseInt(date.substring(5, 7)) < 1 || Integer.parseInt(date.substring(5, 7)) > 12){
                    return 0;
                }
                if(Integer.parseInt(date.substring(8, 10)) < 1 || Integer.parseInt(date.substring(8, 10)) > 31){
                    return 0;
                }
            }
            else{
                return 0;
            }
        }
        else{
            return 0;
        }
        return 1;
    }
}
