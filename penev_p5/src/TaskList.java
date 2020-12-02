import java.io.File;

class TaskList {

    public static TaskItem[] a;

    TaskList(){
        TaskItem[] a = new TaskItem[10000];
    }

    public static int check(String filename){
        File f = new File(filename);
        if(f.exists() && f.isFile()){
            return 1;
        }
        else return 0;
    }

    public static void remove(TaskItem[] a, int size, int remove){
        if(remove < 0 || remove >= size){
            a[-1] = a[-1];
        }
        for(int i = 0; i < size; i++){
            if(i >= remove && i+1 != size){
                a[i] = a[i+1];
            }
        }
    }

    public static void addTask(TaskItem[] a, String title, String description, String date, int size){
        if(TaskItem.createTask(title, description, date) == 1){
            a[size] = new TaskItem(title, description, date);
        }
    }
}
