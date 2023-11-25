package classes;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        
        File file = SpecialMethods.getPathFile("Operators", "3");
        insertData.OperatorInformation("abdallah", "01558300196", "abdallh@gmail.com", "321", "Maadi", 3, file);
        
    }
    
}
