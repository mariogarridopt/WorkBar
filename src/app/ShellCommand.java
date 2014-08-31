package app;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class ShellCommand {
    public static ArrayList<String> exec(String command) {
        ArrayList<String> arr = new ArrayList<String>();
        
        try{
        Process p = Runtime.getRuntime().exec(command);
        p.waitFor();
        
        BufferedReader reader = 
             new BufferedReader(new InputStreamReader(p.getInputStream()));
        
        String line = "";			
        while ((line = reader.readLine())!= null) {
            arr.add(line);
        }
        }catch(Exception e){
            System.out.println("ERROR on ShellCommand: "+ e.getMessage());
        }
        
        return arr;
    }
}
