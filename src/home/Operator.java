package home;


public class Operator extends Person{
    private String Reigon;
    
    
    public Operator(String name, String email, String phone, String password, String reigon){
        super(name, email, phone,password);
        this.Reigon = reigon;
    }

    public void setReigon(String Reigon) {
        this.Reigon = Reigon;
    }

    public String getReigon() {
        return Reigon;
    }

    
    public static double CalculationOfBill(int cons){
        
        double bill=0;
        if(cons >=0 && cons<= 50){
            bill = (cons*0.48)+1;
        }
        else if(cons >= 51 && cons<=100 )        
            bill = (50 * 0.48) + ( (cons-50)*0.58) + 2; 
        
        else if(cons < 200 )
            bill = (cons*0.77) + 6;
        
        else if(cons >=201 && cons <= 350)
            bill = (200*0.77) + ((cons-200)*1.06) + 11;
        
        else if(cons >=351 && cons <= 650)
            bill = (200*0.77) + (150*1.06) + ((cons-350)*1.28) + 15;        
        
        else if(cons < 1000)
            bill = (cons * 1.28) + 25;
        
        else 
            bill = (cons * 1.45) + 40;
        
        return bill;
    }
    
//    public boolean validateReading(File file ) throws FileNotFoundException{
//        long reading1=0, reading2=0;
//        int size = (int) getData.readSize(file);
//        reading1 = getData.readMeterReading(size-1, file);
//        reading2 = getData.readMeterReading(size, file);
//
//        if(reading2 > reading1)
//            return true;
//        else
//            return false;
//    }
    
}
