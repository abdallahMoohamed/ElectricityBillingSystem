package home;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;

public abstract class updateData {
    
    public static void repalce(String target, String newData, File file) throws FileNotFoundException{
        if(!newData.equals("")){
            ArrayList<String> list = new ArrayList<>();
            getData.AllData(list, file);

            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).matches(target + ".*")) {
                    list.set(i, target + ": " + newData);
                }
            }

            try (PrintWriter output = new PrintWriter(file)) {
                for (int i = 0; i < list.size(); i++) {
                    output.println(list.get(i));
                }
            }
        }
    }
    
    
}
