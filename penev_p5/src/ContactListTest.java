import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ContactListTest {
    @Test
    public void addingItemsIncreasesSize(){
        ContactItem[] list = new ContactItem[10000];
        int size = 0;
        String first = "Rob";
        String last = "Snow";
        String phone = "123-456-7890";
        String email = "ok@there.com";
        int temp;
        try{
            temp = ContactItem.CaddTask(list, first, last, phone, email, size);
            if(temp != 1){
                size--;
            }
            size++;
        }catch (ArrayIndexOutOfBoundsException e){
            System.out.println("Contact does not exist\n");
        }
        assertEquals(1, size);
    }

    @Test
    public void editingItemsFailsWithAllBlankValues(){
        ContactItem[] list = new ContactItem[10000];
        int size = 0;
        String first = "Rob"; //initial contact
        String last = "Snow";
        String phone = "123-456-7890";
        String email = "ok@there.com";
        ContactItem.CaddTask(list, first, last, phone, email, size);
        size++;
        first = "";//attempt to edit contact
        last = "";
        phone = "";
        email = "";
        System.out.print("Which contact will you edit?");
        int edit = 0;
        try{
            if(edit >= size){
                list[-1] = list[-1];
            }
            else{
                ContactItem.CaddTask(list, first, last, phone, email, edit);
            }
        }catch(ArrayIndexOutOfBoundsException e) {
            System.out.println("Contact does not exist\n");
        }
        assertEquals(-1, ContactItem.CaddTask(list, first, last, phone, email, edit));
    }

    @Test
    public void editingItemsFailsWithInvalidIndex(){
        ContactItem[] list = new ContactItem[10000];
        int size = 0;
        String temp1 = "Rob"; //initial contact
        String temp2 = "Snow";
        String temp3 = "123-456-7890";
        String temp4 = "ok@there.com";
        ContactItem.CaddTask(list, temp1, temp2, temp3, temp4, size);
        size++;
        String first = "Robert";//attempt to edit contact
        String last = "Snow";
        String phone = "123-456-7890";
        String email = "ok@there.com";
        int edit = -1;
        try{
            if(edit >= size){
                list[-1] = list[-1];
            }
            else{
                ContactItem.CaddTask(list, first, last, phone, email, edit);
            }
        }catch(ArrayIndexOutOfBoundsException e) {
            System.out.println("Contact does not exist\n");
        }
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> ContactItem.CaddTask(list, first, last, phone, email, edit));
    }

    @Test
    public void editingSucceedsWithBlankFirstName(){
        ContactItem[] list = new ContactItem[10000];
        int size = 0;
        String temp1 = "Rob"; //initial contact
        String temp2 = "Snow";
        String temp3 = "123-456-7890";
        String temp4 = "ok@there.com";
        ContactItem.CaddTask(list, temp1, temp2, temp3, temp4, size);
        size++;
        String first = "";//attempt to edit contact
        String last = "Snow";
        String phone = "123-456-7890";
        String email = "ok@there.com";
        int edit = 0;
        try{
            if(edit >= size){
                list[-1] = list[-1];
            }
            else{
                ContactItem.CaddTask(list, first, last, phone, email, edit);
            }
        }catch(ArrayIndexOutOfBoundsException e) {
            System.out.println("Contact does not exist\n");
        }
        assertEquals(1, ContactItem.CaddTask(list, first, last, phone, email, edit));
    }

    @Test
    public void editingSucceedsWithBlankLastName(){
        ContactItem[] list = new ContactItem[10000];
        int size = 0;
        String temp1 = "Rob"; //initial contact
        String temp2 = "Snow";
        String temp3 = "123-456-7890";
        String temp4 = "ok@there.com";
        ContactItem.CaddTask(list, temp1, temp2, temp3, temp4, size);
        size++;
        String first = "Rob";//attempt to edit contact
        String last = "";
        String phone = "123-456-7890";
        String email = "ok@there.com";
        int edit = 0;
        try{
            if(edit >= size){
                list[-1] = list[-1];
            }
            else{
                ContactItem.CaddTask(list, first, last, phone, email, edit);
            }
        }catch(ArrayIndexOutOfBoundsException e) {
            System.out.println("Contact does not exist\n");
        }
        assertEquals(1, ContactItem.CaddTask(list, first, last, phone, email, edit));
    }

    @Test
    public void editingSucceedsWithBlankPhone(){
        ContactItem[] list = new ContactItem[10000];
        int size = 0;
        String temp1 = "Rob"; //initial contact
        String temp2 = "Snow";
        String temp3 = "123-456-7890";
        String temp4 = "ok@there.com";
        ContactItem.CaddTask(list, temp1, temp2, temp3, temp4, size);
        size++;
        String first = "Rob";//attempt to edit contact
        String last = "Snow";
        String phone = "";
        String email = "ok@there.com";
        int edit = 0;
        try{
            if(edit >= size){
                list[-1] = list[-1];
            }
            else{
                ContactItem.CaddTask(list, first, last, phone, email, edit);
            }
        }catch(ArrayIndexOutOfBoundsException e) {
            System.out.println("Contact does not exist\n");
        }
        assertEquals(1, ContactItem.CaddTask(list, first, last, phone, email, edit));
    }

    @Test
    public void editingSucceedsWithNonBlankValues(){
        ContactItem[] list = new ContactItem[10000];
        int size = 0;
        String temp1 = "Rob"; //initial contact
        String temp2 = "Snow";
        String temp3 = "123-456-7890";
        String temp4 = "ok@there.com";
        ContactItem.CaddTask(list, temp1, temp2, temp3, temp4, size);
        size++;
        String first = "Rob";//attempt to edit contact
        String last = "Snow";
        String phone = "123-456-7890";
        String email = "ok@there.com";
        int edit = 0;
        try{
            if(edit >= size){
                list[-1] = list[-1];
            }
            else{
                ContactItem.CaddTask(list, first, last, phone, email, edit);
            }
        }catch(ArrayIndexOutOfBoundsException e) {
            System.out.println("Contact does not exist\n");
        }
        assertEquals(1, ContactItem.CaddTask(list, first, last, phone, email, edit));
    }

    @Test
    public void newListIsEmpty(){
        ContactItem[] list = new ContactItem[10000];
        int size = 0;
        assertEquals(0, size);
    }

    @Test
    public void removingItemsDecreasesSize(){
        ContactItem[] list = new ContactItem[10000];
        int size = 0;
        String first = "Rob"; //initial contact
        String last = "Snow";
        String phone = "123-456-7890";
        String email = "ok@there.com";
        ContactItem.CaddTask(list, first, last, phone, email, size);
        size++;
        int edit = 0;
        try{
            ContactList.Cremove(list, size, edit);
            if(size == 0 || edit >= size){
                list[-1] = list[-1];
            }
            size--;
        }catch(ArrayIndexOutOfBoundsException e){
            System.out.println("Contact does not exist");
        }
        assertEquals(0, size);
    }

    @Test
    public void removingItemsFailsWithInvalidIndex(){
        ContactItem[] list = new ContactItem[10000];
        int size = 0;
        String first = "Rob"; //initial contact
        String last = "Snow";
        String phone = "123-456-7890";
        String email = "ok@there.com";
        ContactItem.CaddTask(list, first, last, phone, email, size);
        size++;
        int edit = -1;
        try{
            ContactList.Cremove(list, size, edit);
            if(size == 0 || edit >= size){
                list[-1] = list[-1];
            }
            size--;
        }catch(ArrayIndexOutOfBoundsException e){
            System.out.println("Contact does not exist");
        }
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> ContactList.Cremove(list, 1, edit));
    }

    @Test
    public void savedContactListCanBeLoaded(){
        ContactList.Ccheck("sample.txt");
        assertEquals(0, ContactList.Ccheck("sample.txt")); //should return 1 if you actually have the file
    }
}