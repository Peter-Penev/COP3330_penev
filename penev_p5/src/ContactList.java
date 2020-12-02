import java.io.File;

public class ContactList {

    ContactList(){
        ContactItem[] a = new ContactItem[10000];
    }

    public static int Ccheck(String filename){
        File f = new File(filename);
        if(f.exists() && f.isFile()){
            return 1;
        }
        else return 0;
    }

    public static void Cremove(ContactItem[] a, int size, int remove){
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
