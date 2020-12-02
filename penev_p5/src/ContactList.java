import java.io.File;

public class ContactList {

    ContactList(){ //constructor
        ContactItem[] a = new ContactItem[10000];
    }

    public static int Ccheck(String filename){ //checks if a given file exists
        File f = new File(filename);
        if(f.exists() && f.isFile()){
            return 1;
        }
        else return 0;
    }

    public static void Cremove(ContactItem[] a, int size, int remove){ //removes a contact if the contact exists
        if(remove < 0 || remove >= size){
            a[-1] = a[-1];
        }
        for(int i = 0; i < size; i++){
            if(i >= remove && i+1 != size){
                a[i] = a[i+1];
            }
        }
    }
}
