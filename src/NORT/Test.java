package NORT;

import java.util.Scanner;

/**
 * Created by Supakarn on 11/6/2016.
 */
public class Test {

    public static void main(String[] args) {
        GameUser player1 = new User();
        System.out.println(player1.getUsername());
        System.out.println(player1.getPassword());
        player1.createUser("Com","hello");
        player1.userLogin("Com","hello");
        player1.createUser("OOP","200");
        player1.userLogin("OOP1","217");
        player1.createUser("OOP","217");
        player1.userLogin("OOP","217");
        player1.userLogin("OOP","200");
    }


}
