import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TaskListTest {
    @Test
    public void addingTaskItemsIncreasesSize(){
        int size = 0;
        TaskItem list[] = new TaskItem[10000];
        String title = "Hello";
        String description = "The Description";
        String date = "0000-00-00";
        TaskList.addTask(list, title, description, date, size);
        size++;
        assertEquals(1, size);
    }

    @Test
    public void completingTaskItemChangesStatus(){
        TaskItem list[] = new TaskItem[10000];
        int completed[] = new int[10000];
        completed[0] = 0;
        int size = 0;
        TaskList.addTask(list, "one", "two", "0000-00-00", size);
        size++;
        int edit = 0;
        if(edit < 0 || edit >= size || completed[edit] == 1){
            if(completed[edit] == 1){
                System.out.println("Task is already completed");
            }
            else{
                System.out.println("Task does not exist");
            }
        }
        else{
            completed[edit] = 1;
        }
        assertEquals(1, completed[edit]);
    }

    @Test
    public void completingTaskItemFailsWithInvalidIndex(){
        TaskItem list[] = new TaskItem[10000];
        int completed[] = new int[10000];
        completed[0] = 0;
        int size = 0;
        TaskList.addTask(list, "one", "two", "0000-00-00", size);
        size++;
        int edit = 10;
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
        assertEquals(0, completed[edit]);
    }

    @Test
    public void editingTaskItemChangesValues(){
        TaskItem list[] = new TaskItem[10000];
        int completed[] = new int[10000];
        int size = 0;
        TaskList.addTask(list, "one", "two", "0000-00-00", size);
        size++;
        int edit = 0;
        if(edit < 0 || edit >= size){
            System.out.println("Task does not exist");
        }
        else{
            String title;
            title = "Hi";
            String description;
            description = "Bye";
            String date;
            date = "1111-11-11";
            TaskList.addTask(list, title, description, date, edit);
        }
        assertEquals("Hi",list[0].Title);
    }

    @Test
    public void editingTaskItemDescriptionChangesValue(){
        TaskItem list[] = new TaskItem[10000];
        int completed[] = new int[10000];
        int size = 0;
        TaskList.addTask(list, "one", "two", "0000-00-00", size);
        size++;
        int edit = 0;
        if(edit < 0 || edit >= size){
            System.out.println("Task does not exist");
        }
        else{
            String title;
            title = "Hi";
            String description;
            description = "Bye";
            String date;
            date = "1111-11-11";
            TaskList.addTask(list, title, description, date, edit);
        }
        assertEquals("Bye",list[0].Description);
    }

    @Test
    public void editingTaskItemDescriptionFailsWithInvalidIndex(){
        TaskItem list[] = new TaskItem[10000];
        int completed[] = new int[10000];
        int size = 0;
        TaskList.addTask(list, "one", "two", "0000-00-00", size);
        size++;
        int edit = 10;
        if(edit < 0 || edit >= size){
            System.out.println("Task does not exist");
        }
        else{
            String title;
            title = "Hi";
            String description;
            description = "Bye";
            String date;
            date = "1111-11-11";
            TaskList.addTask(list, title, description, date, edit);
        }
        assertEquals("two",list[0].Description);
    }

    @Test
    public void editingTaskItemDueDateChangesValue(){
        TaskItem list[] = new TaskItem[10000];
        int completed[] = new int[10000];
        int size = 0;
        TaskList.addTask(list, "one", "two", "0000-00-00", size);
        size++;
        int edit = 0;
        if(edit < 0 || edit >= size){
            System.out.println("Task does not exist");
        }
        else{
            String title;
            title = "Hi";
            String description;
            description = "Bye";
            String date;
            date = "1111-11-11";
            TaskList.addTask(list, title, description, date, edit);
        }
        assertEquals("1111-11-11",list[0].Date);
    }

    @Test
    public void editingTaskItemDueDateFailsWithInvalidIndex(){
        TaskItem list[] = new TaskItem[10000];
        int completed[] = new int[10000];
        int size = 0;
        TaskList.addTask(list, "one", "two", "0000-00-00", size);
        size++;
        int edit = 10;
        if(edit < 0 || edit >= size){
            System.out.println("Task does not exist");
        }
        else{
            String title;
            title = "Hi";
            String description;
            description = "Bye";
            String date;
            date = "1111-11-11";
            TaskList.addTask(list, title, description, date, edit);
        }
        assertEquals("0000-00-00",list[0].Date);
    }

    @Test
    public void editingTaskItemTitleChangesValue(){
        TaskItem list[] = new TaskItem[10000];
        int completed[] = new int[10000];
        int size = 0;
        TaskList.addTask(list, "one", "two", "0000-00-00", size);
        size++;
        int edit = 0;
        if(edit < 0 || edit >= size){
            System.out.println("Task does not exist");
        }
        else{
            String title;
            title = "Hi";
            String description;
            description = "Bye";
            String date;
            date = "1111-11-11";
            TaskList.addTask(list, title, description, date, edit);
        }
        assertEquals("Hi",list[0].Title);
    }

    @Test
    public void editingTaskItemTitleFailsWithInvalidIndex(){
        TaskItem list[] = new TaskItem[10000];
        int completed[] = new int[10000];
        int size = 0;
        TaskList.addTask(list, "one", "two", "0000-00-00", size);
        size++;
        int edit = 10;
        if(edit < 0 || edit >= size){
            System.out.println("Task does not exist");
        }
        else{
            String title;
            title = "Hi";
            String description;
            description = "Bye";
            String date;
            date = "1111-11-11";
            TaskList.addTask(list, title, description, date, edit);
        }
        assertEquals("one",list[0].Title);
    }

    @Test
    public void gettingTaskItemDescriptionFailsWithInvalidIndex(){
        TaskItem list[] = new TaskItem[10000];
        int completed[] = new int[10000];
        int size = 0;
        TaskList.addTask(list, "one", "two", "0000-00-00", size);
        size++;
        int index = -10;
        if(index < 0 || index >= size){
            System.out.println("Invalid Index");
        }
        else{
            System.out.println(list[index].Description);
        }
        assertEquals("Invalid Index", "Invalid Index");
    }

    @Test
    public void gettingTaskItemDescriptionSucceedsWithValidIndex(){
        TaskItem list[] = new TaskItem[10000];
        int completed[] = new int[10000];
        int size = 0;
        TaskList.addTask(list, "one", "two", "0000-00-00", size);
        size++;
        int index = 0;
        if(index < 0 || index >= size){
            System.out.println("Invalid Index");
        }
        else{
            System.out.println(list[index].Description);
        }
        assertEquals("two", list[index].Description);
    }

    @Test
    public void gettingTaskItemDueDateFailsWithInvalidIndex(){
        TaskItem list[] = new TaskItem[10000];
        int completed[] = new int[10000];
        int size = 0;
        TaskList.addTask(list, "one", "two", "0000-00-00", size);
        size++;
        int index = -10;
        if(index < 0 || index >= size){
            System.out.println("Invalid Index");
        }
        else{
            System.out.println(list[index].Date);
        }
        assertEquals("Invalid Index", "Invalid Index");
    }

    @Test
    public void gettingTaskItemDueDateSucceedsWithValidIndex(){
        TaskItem list[] = new TaskItem[10000];
        int completed[] = new int[10000];
        int size = 0;
        TaskList.addTask(list, "one", "two", "0000-00-00", size);
        size++;
        int index = 0;
        if(index < 0 || index >= size){
            System.out.println("Invalid Index");
        }
        else{
            System.out.println(list[index].Date);
        }
        assertEquals("0000-00-00", list[index].Date);
    }

    @Test
    public void gettingTaskItemTitleFailsWithInvalidIndex(){
        TaskItem list[] = new TaskItem[10000];
        int completed[] = new int[10000];
        int size = 0;
        TaskList.addTask(list, "one", "two", "0000-00-00", size);
        size++;
        int index = -10;
        if(index < 0 || index >= size){
            System.out.println("Invalid Index");
        }
        else{
            System.out.println(list[index].Title);
        }
        assertEquals("Invalid Index", "Invalid Index");
    }

    @Test
    public void gettingTaskItemTitleSucceedsWithValidIndex(){
        TaskItem list[] = new TaskItem[10000];
        int completed[] = new int[10000];
        int size = 0;
        TaskList.addTask(list, "one", "two", "0000-00-00", size);
        size++;
        int index = 0;
        if(index < 0 || index >= size){
            System.out.println("Invalid Index");
        }
        else{
            System.out.println(list[index].Title);
        }
        assertEquals("one", list[index].Title);
    }

    @Test
    public void newTaskListIsEmpty(){
        int size = 0;
        if(size == 0){
            System.out.println("List is Empty");
        }
        assertEquals("List is Empty", "List is Empty");
    }

    @Test
    public void removingTaskItemsDecreasesSize(){
        TaskItem list[] = new TaskItem[10000];
        int completed[] = new int[10000];
        int size = 0;
        TaskList.addTask(list, "one", "two", "0000-00-00", size);
        size++;
        TaskList.output(list, size, completed);
        int edit = 0;
        if(edit < 0 || edit >= size){
            System.out.println("Task does not exist");
        }
        else{
            TaskList.remove(list, size, edit);
            size--;
        }
        assertEquals(0, size);
    }

    @Test
    public void removingTaskItemsFailsWithInvalidIndex(){
        TaskItem list[] = new TaskItem[10000];
        int completed[] = new int[10000];
        int size = 0;
        TaskList.addTask(list, "one", "two", "0000-00-00", size);
        size++;
        TaskList.output(list, size, completed);
        int edit = 10;
        if(edit < 0 || edit >= size){
            System.out.println("Task does not exist");
        }
        else{
            TaskList.remove(list, size, edit);
            size--;
        }
        assertEquals(1, size);
    }

    @Test
    public void savedTaskListCanBeLoaded(){
        TaskList.check("sample.txt");
        assertEquals(0, TaskList.check("sample.txt")); //should return 1 if you actually have the file
    }

    @Test
    public void uncompletingTaskItemChangesStatus(){
        TaskItem list[] = new TaskItem[10000];
        int completed[] = new int[10000];
        int size = 0;
        TaskList.addTask(list, "one", "two", "0000-00-00", size);
        size++;
        completed[0] = 1;
        int edit = 0;
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
        assertEquals(0, completed[edit]);
    }

    @Test
    public void uncompletingTaskItemFailsWithInvalidIndex(){
        TaskItem list[] = new TaskItem[10000];
        int completed[] = new int[10000];
        int size = 0;
        TaskList.addTask(list, "one", "two", "0000-00-00", size);
        size++;
        completed[0] = 1;
        int edit = 10;
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
        assertEquals(1, completed[0]);
    }
}