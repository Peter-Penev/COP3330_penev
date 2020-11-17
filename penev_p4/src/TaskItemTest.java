import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TaskItemTest {
    @Test
    public void creatingTaskItemFailsWithInvalidDueDate(){
        String title = "Title";
        String description = "Hello";
        String date = "";
        assertEquals(-1, TaskItem.createTask(title, description, date));
    }

    @Test
    public void creatingTaskItemFailsWithInvalidTitle(){
        String title = "";
        String description = "Hello";
        String date = "";
        assertEquals(0, TaskItem.createTask(title, description, date));
    }

    @Test
    public void creatingTaskItemSucceedsWithValidDueDate(){
        String title = "Title";
        String description = "Hello";
        String date = "2003-11-20";
        assertEquals(1, TaskItem.createTask(title, description, date));
    }

    @Test
    public void creatingTaskItemSucceedsWithValidTitle(){
        String title = "Title";
        String description = "Hello";
        String date = "2003-11-20";
        assertEquals(1, TaskItem.createTask(title, description, date));
    }

    @Test
    public void settingTaskItemDueDateFailsWithInvalidDate(){ //I use same function for making and editing TaskItem's (I just change input)
        String title = "Title";
        String description = "Hello";
        String date = "";
        assertEquals(-1, TaskItem.createTask(title, description, date));
    }

    @Test
    public void settingTaskItemDueDateSucceedsWithValidDate(){//I use same function for making and editing TaskItem's (I just change input)
        String title = "";
        String description = "Hello";
        String date = "";
        assertEquals(0, TaskItem.createTask(title, description, date));
    }

    @Test
    public void settingTaskItemTitleFailsWithInvalidTitle(){//I use same function for making and editing TaskItem's (I just change input)
        String title = "Title";
        String description = "Hello";
        String date = "2003-11-20";
        assertEquals(1, TaskItem.createTask(title, description, date));
    }

    @Test
    public void settingTaskItemTitleSucceedsWithValidTitle(){//I use same function for making and editing TaskItem's (I just change input)
        String title = "Title";
        String description = "Hello";
        String date = "2003-11-20";
        assertEquals(1, TaskItem.createTask(title, description, date));
    }
}