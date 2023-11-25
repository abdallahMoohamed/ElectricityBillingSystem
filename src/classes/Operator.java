package classes;

import java.io.File;
import java.io.FileNotFoundException;


public class Operator extends Person{
    private String Reigon;

    public Operator(String Reigon, String Name, String Phone, String E_mail, String Password, Meter meter) {
        super(Name, Phone, E_mail, Password, meter);
        this.Reigon = Reigon;
    }
    
    public void setReigon(String Reigon) {
        this.Reigon = Reigon;
    }

    public String getReigon() {
        return Reigon;
    }

    
    
    public static double CalcOfBill(int cons){
        
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
    
    public static int CalcOfConsumption(File file ,int reading2) throws FileNotFoundException{
        int cons=0, reading1=0;  
        int size = getData.countMonthlyBills(file);
        if(size !=0 )
            reading1 = getData.ReadingMeter(size, file);
        cons = (reading2 - reading1);
        return cons;
    }
    public static boolean validateReading(File file, int reading2 ) throws FileNotFoundException{
        return (CalcOfConsumption(file, reading2) >= 0 );
    }
    
}
