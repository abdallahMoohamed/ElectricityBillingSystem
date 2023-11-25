package home;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;


public abstract class getData {
      
    public static String readString(String target,File file) throws FileNotFoundException{
        String targ = "";
        
        try(Scanner input = new Scanner(file)){
            
            while(input.hasNext()){
                String test = input.next();
                if(test.equals(target+":"))
                    targ = input.nextLine();                   
            }
        }
        return targ;
    }


    public static String ID(File file) throws FileNotFoundException{
        String name = readString("id",file);
        return name;
    }

    public static String Name(File file) throws FileNotFoundException{
        String name = readString("name",file);
        return name;
    }
    public static String Phone(File file) throws FileNotFoundException{
        String phone = readString("phone",file);
        return phone;
    }
    public static String Email(File file) throws FileNotFoundException{
        String email = readString("email",file);
        return email;
    }
    public static String Password(File file) throws FileNotFoundException{
        String password = readString("password",file);
        return password;
    }
    public static String Reigon(File file) throws FileNotFoundException{
        String reigon= readString("reigon",file);
        return reigon;
    }
    public static String Adderss(File file) throws FileNotFoundException{
        String adderss = readString("adderss",file);
        return adderss;
    }


    
    
    private static int readInt(String target,File file) throws FileNotFoundException{
        int targ = 0;
        try(Scanner input = new Scanner(file)){
            while(input.hasNext()){
                String test = input.next();
                if(test.equals(target+":"))
                    targ = input.nextInt();
            }
        }
        return targ;
    }
    public static int ReadingMeter(int i,File file) throws FileNotFoundException{
        int reading = readInt("readingMeter"+i,file);
        return reading;
    }    
    public static int Consumption(int i ,File file) throws FileNotFoundException{
        int cons = readInt("consumption"+i,file);
        return cons;
    }
    public static int DateMonth(int i ,File file) throws FileNotFoundException{
        int month = readInt("dateMonth"+i,file);
        return month;
    }
    public static int DateYear(int i ,File file) throws FileNotFoundException{
        int year = readInt("dateYear"+i,file);
        return year;
    }


    private static double readDouble(String target,File file) throws FileNotFoundException{
        double targ = 0.0;
        try(Scanner input = new Scanner(file)){
            while(input.hasNext()){
                String test = input.next();
                if(test.equals(target+":"))
                    targ = input.nextDouble();
            }
        }
        return targ;
    }
    public static double Billing(int i ,File file) throws FileNotFoundException{
        double bill = readDouble("billing"+i,file);
        return bill;
    }    
    
    private static boolean readBoolean(String target,File file) throws FileNotFoundException{
        boolean targ = false;
        try(Scanner input = new Scanner(file)){
            while(input.hasNext()){
                String test = input.next();
                if(test.equals(target+":"))
                    targ = input.nextBoolean();
            }
        }
        return targ;
    }
    public static boolean Check(int i,File file) throws FileNotFoundException{
        boolean ch = readBoolean("check"+i,file);
        return ch;
    }

    public static void AllData(ArrayList<String> list, File file) throws FileNotFoundException{
        try(Scanner input = new Scanner(file)){
            while(input.hasNext()){
                String x = input.nextLine();
                list.add(x);
            }
        }
    }
}
