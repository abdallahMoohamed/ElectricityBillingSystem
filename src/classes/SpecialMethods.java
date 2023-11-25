package classes;

import java.io.File;
import java.io.FileNotFoundException;

public class SpecialMethods {
    
    public static boolean includeLetter(String s){
        boolean flag = false;
        for(int i=0 ; i<s.length() ; i++)
            if(Character.isLetter(s.charAt(i)))
                flag = true;
        Character.isLetter(123);
        return flag;
    }
    
    public static File getPathFile(String folder, String file){
        return new File("G:\\computer science\\My Projects\\Electricity Billing System\\ElectricityBillingSystem\\src\\Files\\"+folder+"\\"
                +file+".txt");
    }
    public static boolean searchOfMeterCode(String code) throws FileNotFoundException{
        boolean flag;
        File file = SpecialMethods.getPathFile("Customers",code);

        if(file.exists())
            flag = true;
        else
            flag = false;
        
        return flag;
    }
    
//    public static String getReigonByMeterCode(String code){
//        String reig="";
//        File file = SpecialMethods.getPathFile(code);
//
//        
//        if(file.exists())
//            reig = getData.Reigon(file);
//
//
//        return reig;
//    }
}
