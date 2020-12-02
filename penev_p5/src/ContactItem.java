public class ContactItem extends ContactList{

    String First;
    String Last;
    String Phone;
    String Email;

    ContactItem(String First, String Last, String Phone, String Email){ //constructor for a contactItem
        this.First = First;
        this.Last = Last;
        this.Phone = Phone;
        this.Email = Email;
    }

    public static void CCprint(ContactItem[] a, int size){ //prints out the current contacts
        System.out.println("Current Contacts");
        System.out.println("-------------");
        System.out.println();
        for(int i = 0; i < size;i++){
            System.out.println(i + ") Name: " + a[i].First + " " + a[i].Last);
            System.out.println("Phone: " + a[i].Phone);
            System.out.println("Email: " + a[i].Email);
        }
        System.out.println();
    }

    public static String toString(ContactItem[] a, int size) { //Saves what would be printed as a string
        String b = "";
        for (int i = 0; i < size; i++) {
            b = b + i + ") Name: " + a[i].First + " " + a[i].Last + "\n";
            b = b + "Phone: " + a[i].Phone + "\n";
            b = b + "Email: " + a[i].Email;
        }
        return b;
    }

    public static int Ccheck(String a, String b, String c, String d){ //checks if the phone and email is valid
        if(c.length() > 0){
            if(phoneValid(c) == 0){
                System.out.println("WARNING: invalid phone format");
                return 0;
            }
        }
        else if(d.length() > 0){
            if(emailValid(d) == 0){
                System.out.println("WARNING: invalid email format");
                return 0;
            }
        }
        return 1;
    }

    public static int phoneValid(String date){ //checks if the phone is valid
        if(date.length() == 12){
            if(date.charAt(3) == '-' && date.charAt(7) == '-'){
                for(int i = 0; i < 12; i++){
                    if(i != 3 && i != 7){
                        if(date.charAt(i) >= 48 && date.charAt(i) <= 57){
                        }
                        else{
                            return 0;
                        }
                    }
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

    public static int emailValid(String email){ //checks if the email is valid
        int size = email.length();
        int one = -1; // @
        int two = -1; // .
        if(email.charAt(0) == '@'){
            return 0;
        }
        if(email.charAt(size-1) == '.'){
            return 0;
        }
        for(int i = 0; i < size; i++){
            if(email.charAt(i) == '@'){
                if(one != -1){
                    return 0;
                }
                if(two != -1){
                    return 0;
                }
                one = i;
            }
            else if(email.charAt(i) == '.'){
                if(one == -1){
                    return 0;
                }
                if(two != -1){
                    return 0;
                }
                if(i-1 == one){
                    return 0;
                }
                two = i;
            }
            else if((email.charAt(i) > 64 && email.charAt(i) < 91) || (email.charAt(i) > 96 && email.charAt(i) < 123)){
            }
            else{
                return 0;
            }
        }
        return 1;
    }

    public static int CaddTask(ContactItem[] a, String first, String last, String phone, String email, int size){ //checks if the contact is valid
        if(first.equals("") && last.equals("") && phone.equals("") && email.equals("")){
            System.out.println("WARNING: contact must have at least one item");
            return -1;
        }
        else{
            if(ContactItem.Ccheck(first, last, phone, email) == 1){
                a[size] = new ContactItem(first, last, phone, email);
                return 1;
            }
            else{
                return 0;
            }
        }
    }
}
