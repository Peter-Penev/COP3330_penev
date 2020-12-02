import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ContactItemTest {
    //the names of the method explains what everything in the test's objective is
    @Test
    public void creationFailsWithAllBlankValues(){
        ContactItem[] list = new ContactItem[10000];
        int size = 0;
        String first = "";
        String last = "";
        String phone = "";
        String email = "";
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
        assertEquals(-1, ContactItem.CaddTask(list, first, last, phone, email, size));
    }

    @Test
    public void creationSucceedsWithBlankEmail(){
        ContactItem[] list = new ContactItem[10000];
        int size = 0;
        String first = "Rob";
        String last = "Snow";
        String phone = "123-456-7890";
        String email = "";
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
        assertEquals(1, ContactItem.CaddTask(list, first, last, phone, email, size));
    }

    @Test
    public void creationSucceedsWithBlankFirstName(){
        ContactItem[] list = new ContactItem[10000];
        int size = 0;
        String first = "";
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
        assertEquals(1, ContactItem.CaddTask(list, first, last, phone, email, size));
    }

    @Test
    public void creationSucceedsWithBlankLastName(){
        ContactItem[] list = new ContactItem[10000];
        int size = 0;
        String first = "Rob";
        String last = "";
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
        assertEquals(1, ContactItem.CaddTask(list, first, last, phone, email, size));
    }

    @Test
    public void creationSucceedsWithBlankPhone(){
        ContactItem[] list = new ContactItem[10000];
        int size = 0;
        String first = "Rob";
        String last = "Snow";
        String phone = "";
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
        assertEquals(1, ContactItem.CaddTask(list, first, last, phone, email, size));
    }

    @Test
    public void creationSucceedsWithNonBlankValues(){
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
        assertEquals(1, ContactItem.CaddTask(list, first, last, phone, email, size));
    }

    @Test
    public void editingFailsWithAllBlankValues(){//Note: I use the same function for making and editing contacts
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
        int temp;
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
    public void editingSucceedsWithBlankEmail(){
        ContactItem[] list = new ContactItem[10000];
        int size = 0;
        String first = "Rob"; //initial contact
        String last = "Snow";
        String phone = "123-456-7890";
        String email = "ok@there.com";
        ContactItem.CaddTask(list, first, last, phone, email, size);
        size++;
        first = "Rob";//attempt to edit contact
        last = "Snow";
        phone = "123-456-7890";
        email = "";
        int temp;
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
        assertEquals(1, ContactItem.CaddTask(list, first, last, phone, email, edit));
    }

    @Test
    public void editingSucceedsWithBlankFirstName(){
        ContactItem[] list = new ContactItem[10000];
        int size = 0;
        String first = "Rob"; //initial contact
        String last = "Snow";
        String phone = "123-456-7890";
        String email = "ok@there.com";
        ContactItem.CaddTask(list, first, last, phone, email, size);
        size++;
        first = "";//attempt to edit contact
        last = "Snow";
        phone = "123-456-7890";
        email = "ok@there.com";
        int temp;
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
        assertEquals(1, ContactItem.CaddTask(list, first, last, phone, email, edit));
    }

    @Test
    public void editingSucceedsWithBlankLastName(){
        ContactItem[] list = new ContactItem[10000];
        int size = 0;
        String first = "Rob"; //initial contact
        String last = "Snow";
        String phone = "123-456-7890";
        String email = "ok@there.com";
        ContactItem.CaddTask(list, first, last, phone, email, size);
        size++;
        first = "Rob";//attempt to edit contact
        last = "";
        phone = "123-456-7890";
        email = "ok@there.com";
        int temp;
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
        assertEquals(1, ContactItem.CaddTask(list, first, last, phone, email, edit));
    }

    @Test
    public void editingSucceedsWithBlankPhone(){
        ContactItem[] list = new ContactItem[10000];
        int size = 0;
        String first = "Rob"; //initial contact
        String last = "Snow";
        String phone = "123-456-7890";
        String email = "ok@there.com";
        ContactItem.CaddTask(list, first, last, phone, email, size);
        size++;
        first = "Rob";//attempt to edit contact
        last = "Snow";
        phone = "";
        email = "ok@there.com";
        int temp;
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
        assertEquals(1, ContactItem.CaddTask(list, first, last, phone, email, edit));
    }

    @Test
    public void editingSucceedsWithNonBlankValues(){
        ContactItem[] list = new ContactItem[10000];
        int size = 0;
        String first = "Rob"; //initial contact
        String last = "Snow";
        String phone = "123-456-7890";
        String email = "ok@there.com";
        ContactItem.CaddTask(list, first, last, phone, email, size);
        size++;
        first = "Rob";//attempt to edit contact
        last = "Snow";
        phone = "123-456-7890";
        email = "ok@there.com";
        int temp;
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
        assertEquals(1, ContactItem.CaddTask(list, first, last, phone, email, edit));
    }

    @Test
    public void testToString(){
        ContactItem[] list = new ContactItem[10000];
        int size = 0;
        String first = "Rob";
        String last = "Snow";
        String phone = "123-456-7890";
        String email = "ok@there.com";
        ContactItem.CaddTask(list, first, last, phone, email, size);
        size++;
        int size2 = size;
        ContactItem.CCprint(list, size);
        assertEquals("0) Name: Rob Snow\nPhone: 123-456-7890\nEmail: ok@there.com", ContactItem.toString(list, size2));
    }
}