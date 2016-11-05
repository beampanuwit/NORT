package NORT;

/**
 * Created by Supakarn on 11/5/2016.
 */

import java.io.*;

public class User {
    static File file = new File("bin\\user.txt");
    static String line;

    public static void main(String[] args) {
        userImport("John","123");
        userImport("John","...");
        userImport("J","hello");
        userImport("Jo","HBD");

    }

    public static void userImport(String username, String password){
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            while ((line = br.readLine()) != null) {
                if(line.equals("User:"+username)){
                    if(passCheck(password,br.readLine())){
                        System.out.println(br.readLine());
                    }else {
                        System.out.println("Wrong Password!");
                    }
                    break;
                }
            }
            if(line == null){
                System.out.println("User Not Found!");
            }
            br.close();
        } catch (IOException e) {
            System.out.println(e);
            e.printStackTrace();
        }
    }


    public static boolean passCheck(String passcode, String password){
        if(passcode.equals(password)){
            return true;
        }else return false;
    }



}