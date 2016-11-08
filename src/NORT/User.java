package NORT;

import java.io.*;
import java.util.ArrayList;

/**
 * Created by Supakarn on 11/6/2016.
 */
public class User implements GameUser {
    private String username;        //after logged in can use this.username
    private String password;        //after logged in can use this.password
    private ArrayList<Bike> ownedBike = new ArrayList<>(50);    //bike that player have
    private static RandomAccessFile fileStore;

    public User(){
        username = "Anonymous";
        password = "";
    }

    @Override
    public void createUser(String username,String password){
        if(!existUsername(username)){
            setUser(username);
            writeDat(password,0,username);       //write password
            System.out.println("Sign up completed.");
        }else System.out.println("Username already taken.");
    }
    @Override
    public boolean userLogin(String username,String password){
        if (!existUsername(username)) {
            System.out.println("User not found!");
            return false;
        }
        if(checkPassword(username,password)){
            System.out.println("Login successful!");
            setUsername(username);
            setPassword(password);
            return true;                                //access the game from this function
        }else {
            System.out.println("Wrong password!");
            return false;
        }
    }

    @Override
    public String getUsername(){
        return this.username;
    }
    @Override
    public String getPassword(){
        return this.password;
    }

    public void setUsername(String username){
        this.username = username;
    }

    public void setPassword(String password){
        this.password = password;
    }


    //----------------------------------------------------------------------------------------------------//

    public boolean existUsername(String username){
        File f = new File("bin\\"+ username +".dat");
        if (f.exists()){
            return true;
        }else{
            return false;
        }
    }

    public boolean checkPassword(String username,String password){
        if(readDat(0,username).equals(password)){
            return true;
        }else {
            return false;
        }
    }

    public void setUser(String username){
        try {
            fileStore = new RandomAccessFile("bin\\"+ username +".dat","rw");
            fileStore.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public void writeDat(String text,int position,String username){
        try {
            fileStore = new RandomAccessFile("bin\\"+ username +".dat","rw");
            fileStore.seek(position);
            fileStore.writeUTF(text);
            fileStore.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public String readDat(int position,String username){
        String temp = null;
        try {
            fileStore = new RandomAccessFile("bin\\"+ username +".dat","r");
            fileStore.seek(position);
            temp = fileStore.readUTF();
        }catch (IOException e){
            e.printStackTrace();
        }
        return temp;
    }

}
