package classes;

public class Customer {
        
    private String region;
    private String adderss;
    private String name;
    private String email;
    private String phone;
    private String password;
    private Meter meter;

    public Customer(String region, String adderss, String name, String email, String phone, String password) {
        this.region = region;
        this.adderss = adderss;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.password = password;
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

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setMeter(Meter meter) {
        this.meter = meter;
    }

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

    public String getPhone() {
        return phone;
    }

    public String getPassword() {
        return password;
    }

    public Meter getMeter() {
        return meter;
    }
    
    
   

}
