package classes;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public abstract class updateData {
    
    private static void repalce(String target, String newData, File file) throws FileNotFoundException{
        if(!newData.equals("")){
            ArrayList<String> list = new ArrayList<>();
            getData.AllData(list, file);

            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).matches(target + ".*")) {
                    list.set(i, target  + newData);
                }
            }

            try (PrintWriter output = new PrintWriter(file)) {
                for (int i = 0; i < list.size(); i++) {
                    output.println(list.get(i));
                }
            }
        }
    }
    
    public static void Name(File file, String newName) throws FileNotFoundException{
        repalce("name: ",newName,file);
    }
    public static void Phone(File file, String newPhone) throws FileNotFoundException{
        repalce("phone: ",newPhone,file);
    }
    public static void Email(File file, String newEmail) throws FileNotFoundException{
        repalce("email: ",newEmail,file);
    }
    public static void Password(File file, String newPassword) throws FileNotFoundException{
        repalce("password: ",newPassword,file);
    }
    public static void Reigon(File file, String newReigon) throws FileNotFoundException{
        repalce("reigon: ",newReigon,file);
    }
    public static void Adderss(File file, String newAdderss) throws FileNotFoundException{
        repalce("adderss: ",newAdderss,file);
    }
    
    public static void Check(File file, String newCheck, int i) throws FileNotFoundException{
        repalce("check"+i+": ",newCheck,file);
    }
    
}
