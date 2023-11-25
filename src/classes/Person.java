package classes;

public class Person {
    private  String Name;
    private  String Phone;
    private  String E_mail;
    private  String Password;
    private  Meter meter ;

    public Person(String Name, String Phone, String E_mail, String Password, Meter meter) {
        this.Name = Name;
        this.Phone = Phone;
        this.E_mail = E_mail;
        this.Password = Password;
        this.meter = meter;
    }
    
    

    
    public void setName(String Name) {
        this.Name = Name;
    }

    public void setPhone(String Phone) {
        this.Phone = Phone;
    }

    public void setE_mail(String E_mail) {
        this.E_mail = E_mail;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    public void setMeter(Meter meter) {
        this.meter = meter;
    }


    public String getName() {
        return Name;
    }

    public String getPhone() {
        return Phone;
    }

    public String getE_mail() {
        return E_mail;
    }

    public String getPassword() {
        return Password;
    }

    public Meter getMeter() {
        return meter;
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