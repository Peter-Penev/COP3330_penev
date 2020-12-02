import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TaskItemTest {
    //the names of the method explains what everything in the test's objective is
    @Test
    public void constructorFailsWithInvalidDueDate(){
        String title = "Title";
        String description = "Hello";
        String date = "";
        assertEquals(-1, TaskItem.createTask(title, description, date));
    }

    @Test
    public void constructorFailsWithInvalidTitle(){
        String title = "";
        String description = "Hello";
        String date = "";
        assertEquals(0, TaskItem.createTask(title, description, date));
    }

    @Test
    public void constructorSucceedsWithValidDueDate(){
        String title = "Title";
        String description = "Hello";
        String date = "2003-11-20";
        assertEquals(1, TaskItem.createTask(title, description, date));
    }

    @Test
    public void constructorSucceedsWithValidTitle(){
        String title = "Title";
        String description = "Hello";
        String date = "2003-11-20";
        assertEquals(1, TaskItem.createTask(title, description, date));
    }

    @Test
    public void editingDescriptionSucceedsWithExpectedValue(){ //Note: I use the same function for creating and editing tasks
        String title = "Title";
        String description = "Edited Description";
        String date = "2003-11-20";
        assertEquals(1, TaskItem.createTask(title, description, date));
    }

    @Test
    public void editingDueDateFailsWithInvalidDateFormat(){
        String title = "Title";
        String description = "Hello";
        String date = "";
        assertEquals(-1, TaskItem.createTask(title, description, date));
    }

    @Test
    public void editingDueDateFailsWithInvalidYYYMMDD(){
        String title = "Title";
        String description = "Hello";
        String date = "2000-90-15";
        assertEquals(-1, TaskItem.createTask(title, description, date));
    }

    @Test
    public void editingDueDateSucceedsWithExpectedValue(){
        String title = "Title";
        String description = "Hello";
        String date = "2003-11-25";
        assertEquals(1, TaskItem.createTask(title, description, date));
    }

    @Test
    public void editingTitleFailsWithEmptyString(){
        String title = "";
        String description = "Hello";
        String date = "2003-11-25";
        assertEquals(0, TaskItem.createTask(title, description, date));
    }

    @Test
    public void editingTitleSucceedsWithExpectedValue(){
        String title = "New Title";
        String description = "Hello";
        String date = "2003-11-25";
        assertEquals(1, TaskItem.createTask(title, description, date));
    }
}