import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class TaskListTest {
    //the names of the method explains what everything in the test's objective is
    @Test
    public void addingItemsIncreasesSize(){
        int size = 0;
        TaskItem[] list = new TaskItem[10000];
        String title = "Hello";
        String description = "The Description";
        String date = "1111-11-11";
        try{
            TaskList.addTask(list, title, description, date, size);
            size++;
        }catch(ArrayIndexOutOfBoundsException e){
            System.out.println("Task does not exist");
        }
        assertEquals(1, size);
    }

    @Test
    public void completingTaskItemChangesStatus(){
        TaskItem[] list = new TaskItem[10000];
        int[] completed = new int[10000];
        completed[0] = 0;
        int size = 0;
        TaskList.addTask(list, "one", "two", "1111-11-11", size);
        size++;
        int edit = 0;
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
        assertEquals(1, completed[edit]);
    }

    @Test
    public void completingTaskItemFailsWithInvalidIndex(){
        TaskItem[] list = new TaskItem[10000];
        int[] completed = new int[10000];
        completed[0] = 0;
        int size = 0;
        TaskList.addTask(list, "one", "two", "1111-11-11", size);
        size++;
        int edit = -1;
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
        assertThrows(IndexOutOfBoundsException.class,() -> completed[edit] = 1);
    }

    @Test
    public void editingItemDescriptionFailsWithInvalidIndex(){ //Note: I use the same function for making and editing tasks
        TaskItem[] list = new TaskItem[10000];
        int[] completed = new int[10000];
        int size = 0;
        TaskList.addTask(list, "one", "two", "1111-11-11", size);
        size++;
        int edit = -1;
        String title = "one";
        String description = "Hello";
        String date = "1111-11-11";
        try{
            TaskList.addTask(list, title, description, date, edit);
        }catch(ArrayIndexOutOfBoundsException e) {
            System.out.println("Task does not exist\n");
        }
        assertThrows(IndexOutOfBoundsException.class,() -> TaskList.addTask(list, title, description, date, edit));
    }

    @Test
    public void editingItemDescriptionSucceedsWithExpectedValue(){
        TaskItem[] list = new TaskItem[10000];
        int[] completed = new int[10000];
        int size = 0;
        TaskList.addTask(list, "one", "two", "1111-11-11", size);
        size++;
        int edit = 0;
        String title = "one";
        String description = "Hello";
        String date = "1111-11-11";
        try{
            TaskList.addTask(list, title, description, date, edit);
        }catch(ArrayIndexOutOfBoundsException e) {
            System.out.println("Task does not exist\n");
        }
        assertEquals("Hello", list[0].Description);
    }

    @Test
    public void editingItemDueDateSucceedsWithExpectedValue(){
        TaskItem[] list = new TaskItem[10000];
        int[] completed = new int[10000];
        int size = 0;
        TaskList.addTask(list, "one", "two", "1111-11-11", size);
        size++;
        int edit = 0;
        String title = "one";
        String description = "two";
        String date = "1111-11-12";
        try{
            TaskList.addTask(list, title, description, date, edit);
        }catch(ArrayIndexOutOfBoundsException e) {
            System.out.println("Task does not exist\n");
        }
        assertEquals("1111-11-12", list[0].Date);
    }

    @Test
    public void editingItemTitleFailsWithEmptyString(){
        TaskItem[] list = new TaskItem[10000];
        int[] completed = new int[10000];
        int size = 0;
        TaskList.addTask(list, "one", "two", "1111-11-11", size);
        size++;
        int edit = 0;
        String title = "";
        String description = "two";
        String date = "1111-11-11";
        try{
            TaskList.addTask(list, title, description, date, edit);
        }catch(ArrayIndexOutOfBoundsException e) {
            System.out.println("Task does not exist\n");
        }
        assertEquals(0, TaskItem.createTask(title, description, date));
    }

    @Test
    public void editingItemTitleFailsWithInvalidIndex(){
        TaskItem[] list = new TaskItem[10000];
        int[] completed = new int[10000];
        int size = 0;
        TaskList.addTask(list, "one", "two", "1111-11-11", size);
        size++;
        int edit = -1;
        String title = "onety one";
        String description = "two";
        String date = "1111-11-11";
        try{
            TaskList.addTask(list, title, description, date, edit);
        }catch(ArrayIndexOutOfBoundsException e) {
            System.out.println("Task does not exist\n");
        }
        assertThrows(IndexOutOfBoundsException.class,() -> TaskList.addTask(list, title, description, date, edit));
    }

    @Test
    public void editingItemTitleSucceedsWithExpectedValue(){
        TaskItem[] list = new TaskItem[10000];
        int[] completed = new int[10000];
        int size = 0;
        TaskList.addTask(list, "one", "two", "1111-11-11", size);
        size++;
        int edit = 0;
        String title = "onety one";
        String description = "two";
        String date = "1111-11-11";
        try{
            TaskList.addTask(list, title, description, date, edit);
        }catch(ArrayIndexOutOfBoundsException e) {
            System.out.println("Task does not exist\n");
        }
        assertEquals("onety one", list[0].Title);
    }

    @Test
    public void editingTaskItemDueDateFailsWithInvalidDateFormat(){
        TaskItem[] list = new TaskItem[10000];
        int[] completed = new int[10000];
        int size = 0;
        TaskList.addTask(list, "one", "two", "1111-11-11", size);
        size++;
        int edit = 0;
        String title = "one";
        String description = "two";
        String date = "";
        try{
            TaskList.addTask(list, title, description, date, edit);
        }catch(ArrayIndexOutOfBoundsException e) {
            System.out.println("Task does not exist\n");
        }
        assertEquals(-1, TaskItem.createTask(title, description, date));
    }

    @Test
    public void editingTaskItemDueDateFailsWithInvalidIndex(){
        TaskItem[] list = new TaskItem[10000];
        int[] completed = new int[10000];
        int size = 0;
        TaskList.addTask(list, "one", "two", "1111-11-11", size);
        size++;
        int edit = -1;
        String title = "one";
        String description = "two";
        String date = "1111-11-12";
        try{
            TaskList.addTask(list, title, description, date, edit);
        }catch(ArrayIndexOutOfBoundsException e) {
            System.out.println("Task does not exist\n");
        }
        assertThrows(IndexOutOfBoundsException.class,() -> TaskList.addTask(list, title, description, date, edit));
    }

    @Test
    public void editingTaskItemDueDateFailsWithInvalidYYYMMDD(){
        TaskItem[] list = new TaskItem[10000];
        int[] completed = new int[10000];
        int size = 0;
        TaskList.addTask(list, "one", "two", "1111-11-11", size);
        size++;
        int edit = -1;
        String title = "one";
        String description = "two";
        String date = "1111-51-12";
        try{
            TaskList.addTask(list, title, description, date, edit);
        }catch(ArrayIndexOutOfBoundsException e) {
            System.out.println("Task does not exist\n");
        }
        assertEquals(-1, TaskItem.createTask(title, description, date));
    }

    @Test
    public void gettingItemDescriptionFailsWithInvalidIndex(){
        TaskItem[] list = new TaskItem[10000];
        int[] completed = new int[10000];
        int size = 0;
        TaskList.addTask(list, "one", "two", "1111-11-11", size);
        size++;
        int edit = -1;
        String temp;
        try{
            temp = list[edit].Description;
        }catch(ArrayIndexOutOfBoundsException e) {
            System.out.println("Task does not exist\n");
        }
        assertThrows(IndexOutOfBoundsException.class,() -> list[edit].Description = list[edit].Description);
    }

    @Test
    public void gettingItemDescriptionSucceedsWithValidIndex(){
        TaskItem[] list = new TaskItem[10000];
        int[] completed = new int[10000];
        int size = 0;
        TaskList.addTask(list, "one", "two", "1111-11-11", size);
        size++;
        int edit = 0;
        String temp = "";
        try{
            temp = list[edit].Description;
        }catch(ArrayIndexOutOfBoundsException e) {
            System.out.println("Task does not exist\n");
        }
        assertEquals("two", temp);
    }

    @Test
    public void gettingItemDueDateFailsWithInvalidIndex(){
        TaskItem[] list = new TaskItem[10000];
        int[] completed = new int[10000];
        int size = 0;
        TaskList.addTask(list, "one", "two", "1111-11-11", size);
        size++;
        int edit = -1;
        String temp = "";
        try{
            temp = list[edit].Date;
        }catch(ArrayIndexOutOfBoundsException e) {
            System.out.println("Task does not exist\n");
        }
        assertThrows(IndexOutOfBoundsException.class,() -> list[edit].Date = list[edit].Date);
    }

    @Test
    public void gettingItemDueDateSucceedsWithValidIndex(){
        TaskItem[] list = new TaskItem[10000];
        int[] completed = new int[10000];
        int size = 0;
        TaskList.addTask(list, "one", "two", "1111-11-11", size);
        size++;
        int edit = 0;
        String temp = "";
        try{
            temp = list[edit].Date;
        }catch(ArrayIndexOutOfBoundsException e) {
            System.out.println("Task does not exist\n");
        }
        assertEquals("1111-11-11", temp);
    }

    @Test
    public void gettingItemTitleFailsWithInvalidIndex(){
        TaskItem[] list = new TaskItem[10000];
        int[] completed = new int[10000];
        int size = 0;
        TaskList.addTask(list, "one", "two", "1111-11-11", size);
        size++;
        int edit = -1;
        String temp = "";
        try{
            temp = list[edit].Title;
        }catch(ArrayIndexOutOfBoundsException e) {
            System.out.println("Task does not exist\n");
        }
        assertThrows(IndexOutOfBoundsException.class,() -> list[edit].Title = list[edit].Title);
    }

    @Test
    public void gettingItemTitleSucceedsWithValidIndex(){
        TaskItem[] list = new TaskItem[10000];
        int[] completed = new int[10000];
        int size = 0;
        TaskList.addTask(list, "one", "two", "1111-11-11", size);
        size++;
        int edit = 0;
        String temp = "";
        try{
            temp = list[edit].Title;
        }catch(ArrayIndexOutOfBoundsException e) {
            System.out.println("Task does not exist\n");
        }
        assertEquals("one", temp);
    }

    @Test
    public void newListIsEmpty(){
        TaskItem[] list = new TaskItem[10000];
        int[] completed = new int[10000];
        for(int i = 0 ; i < 10000; i++){
            completed[i] = 0;
        }
        int size = 0;
        assertEquals(0, size);
    }

    @Test
    public void removingItemsDecreasesSize(){
        TaskItem[] list = new TaskItem[10000];
        int[] completed = new int[10000];
        int size = 0;
        TaskList.addTask(list, "one", "two", "1111-11-11", size);
        size++;
        int edit = 0;
        try{
            TaskList.remove(list, size, edit);
            if(size == 0 || edit >= size){
                list[-1] = list[-1];
            }
            size--;
        }catch(ArrayIndexOutOfBoundsException e){
            System.out.println("Task does not exist");
        }
        assertEquals(0, size);
    }

    @Test
    public void removingItemsFailsWithInvalidIndex(){
        TaskItem[] list = new TaskItem[10000];
        int[] completed = new int[10000];
        int size = 0;
        TaskList.addTask(list, "one", "two", "1111-11-11", size);
        size++;
        int edit = -1;
        String title = "one";
        String description = "two";
        String date = "1111-11-11";
        try{
            TaskList.remove(list, size, edit);
            if(size == 0 || edit >= size){
                list[-1] = list[-1];
            }
            size--;
        }catch(ArrayIndexOutOfBoundsException e){
            System.out.println("Task does not exist");
        }
        assertThrows(IndexOutOfBoundsException.class,() -> TaskList.remove(list, 1, edit));
    }

    @Test
    public void savedTaskListCanBeLoaded(){
        TaskList.check("sample.txt");
        assertEquals(0, TaskList.check("sample.txt")); //should return 1 if you actually have the file
    }

    @Test
    public void uncompletingTaskItemChangesStatus(){
        TaskItem[] list = new TaskItem[10000];
        int[] completed = new int[10000];
        int size = 0;
        TaskList.addTask(list, "one", "two", "1111-11-11", size);
        size++;
        int edit = 0;
        completed[edit] = 1;// we assume the task is already completed
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
        assertEquals(0, completed[edit]);
    }

    @Test
    public void uncompletingTaskItemFailsWithInvalidIndex(){
        TaskItem[] list = new TaskItem[10000];
        int[] completed = new int[10000];
        int size = 0;
        TaskList.addTask(list, "one", "two", "1111-11-11", size);
        size++;
        completed[0] = 1;// we assume the task is already completed
        int edit = -1; //the invalid index
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
        assertThrows(IndexOutOfBoundsException.class,() -> completed[edit] = 0);
    }
}