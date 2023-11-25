package home;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;


public abstract class insertData extends Person{

    public static void CustomerInformation(String name, String phone, String email, String password, String reigon, String adderss, String file) throws FileNotFoundException{

        try(PrintWriter output = new PrintWriter(file)){
            output.println("name: "+name);
            output.println("phone: "+phone);
            output.println("email: "+email);
            output.println("password: "+password);
            output.println("reigon: "+reigon);
            output.println("adderss: "+adderss);
        }
    }

    public static void MonthlyDataOfCusomter(int i, int dateMon, int dateYear, int readingMeter, int consumption, double billing, boolean check,  File file) throws FileNotFoundException{
        ArrayList<String> list = new ArrayList<>();
        home.getData.AllData(list, file);
        int count = list.size()/6;

        int zero=0 , one=1, two=2 , three=3, four=4, five=5;
        
        try(PrintWriter output = new PrintWriter(file)){
            for(int x=1 ; x<=count ; x++){
                if(x==1){
                    output.println(list.get(zero));
                    output.println(list.get(one));
                    output.println(list.get(two));
                    output.println(list.get(three));
                    output.println(list.get(four));
                    output.println(list.get(five));
                }
                
                if(x>1){
                    zero+=6;
                    one+=6;
                    two+=6;
                    three+=6;
                    four+=6;
                    five+=6;
                    output.println(list.get(zero));
                    output.println(list.get(one));
                    output.println(list.get(two));
                    output.println(list.get(three));
                    output.println(list.get(four));
                    output.println(list.get(five));
                }
                
            }
            
            output.println("dateMonth"+i+": "+dateMon);
            output.println("dateYear"+i+": "+dateYear);
            output.println("readingMeter"+i+": "+readingMeter);
            output.println("consumption"+i+": "+consumption);
            output.println("billing"+i+": "+billing);
            output.println("check"+i+": "+check);
        }
    } 
    
    public static void OperatorInformation(String name, String phone, String email, String password, String reigon, long id, File file) throws FileNotFoundException{
        try(PrintWriter output = new PrintWriter(file)){
            output.println("id: "+id);
            output.println("name: "+name);
            output.println("phone: "+phone);
            output.println("email: "+email);
            output.println("password: "+password);
            output.println("reigon: "+reigon);
        }
    }
    
    public static void AdminInformation(String name, String phone, String email, String password, File file) throws FileNotFoundException{
        try(PrintWriter output = new PrintWriter(file)){
            output.println("name: "+name);
            output.println("phone: "+phone);
            output.println("email: "+email);
            output.println("password: "+password);
        }
    }
        
}
