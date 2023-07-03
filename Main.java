package password_generator;

import java.io.FileOutputStream;
import java.util.Properties;
import java.io.IOException;
import java.lang.Thread.State;
import java.util.Scanner;

public class Main{
    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter the length of Password");

        int digit = input.nextInt();
            

        String lower = "qwertyuiopasdfghjklzxcvbnm!}{[];:/?.>,<";
        String upper = "QWERTYUIOPASDFGHJKLZXCVBNM@#$%^&*()_+";

        String password = "";

        for(int i = 0; i < digit; i++) {
            int rand = (int)(3 * Math.random());

            switch(rand) {
                case 0:
                    password += String.valueOf((int)(10 * Math.random()));
                    break;
                
                case 1:
                    rand = (int)(lower.length() *  Math.random());
                    password += String.valueOf(lower.charAt(rand));
                    break;
                
                case 2:
                    rand = (int)(upper.length() *  Math.random());
                    password += String.valueOf(upper.charAt(rand));
                    break;

            }
        }
        Properties s = new Properties();
        
        try (FileOutputStream file = new FileOutputStream("properties\\xml.properties", true)) {
            s.storeToXML(file, password);
        }
         

        System.out.println("Generated password is: " + password);
        System.out.println("File Created and password saved");

    }

}