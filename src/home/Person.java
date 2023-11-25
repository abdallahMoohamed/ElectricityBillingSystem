package home;

public class Person {
    private  String Name;
    private  String Phone;
    private  String E_mail;
    private  String Password;
    
    Person() {
    }
    public Person(String name, String email, String phone, String password){
        this.Name     = name;
        this.E_mail   = email;
        this.Phone    = phone;
        this.Password = password;
    }


    public void SetName(String n){
        Name = n;
    }
    public void SetPhone(String p){
        Phone = p;
    }
    public void SetE_mail(String e){
        E_mail = e;
    }
    public void SetPassword(String p){
        Password = p;
    }
    public String GetName(){
        return Name;
    }
    public String GetPhone(){
        return Phone;
    }
    public String GetE_mail(){
        return E_mail;
    }
    public String GetPassword(){
        return Password;
    }
}