package home;

public class Customer {
        
    private String region;
    private String adderss;
    private String name;
    private String email;
    private String phone;
    private String password;


    //private int meter_code;
    
    public  Customer (){
        
    }
    
    public Customer (String name , String email , String password ,String phone ,String reigon ,String adderss){
        this.name = name;
        this.email = email;
        this.password = password;
        this.phone = phone;
        this.region = region;
        this.adderss = adderss;
        
    } 
   

    public void setRegion(String region) {
        this.region = region;
    }

    public void setAdderss(String adderss) {
        this.adderss = adderss;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    /*public void setMeter_code(int meter_code) {
     *  this.meter_code = meter_code;
   }
      */

    public String getRegion() {
        return region;
    }

    public String getAdderss() {
        return adderss;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getPhone() {
        return phone;
    }

//    public int getMeter_code() {
//        return meter_code;
//    }
    
//    public boolean pay_bill() {
//    }
    

}
