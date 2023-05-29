package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SILab2 {

    public static boolean function (User user, List<User> allUsers) { //1
        if (user==null || user.getPassword()==null || user.getEmail()==null){//1
            throw new RuntimeException("Mandatory information missing!"); //2
        }

        if (user.getUsername()==null){//3
            user.setUsername(user.getEmail());//4
        }

        int same = 1;//5
        if (user.getEmail().contains("@") && user.getEmail().contains(".")) {//5
            same = 0;//6
            for (int i=0;i<allUsers.size();i++) {//6.1
                User existingUser = allUsers.get(i);//7
                if (existingUser.getUsername() == user.getUsername()) {//7
                    same += 1; //8
                }
                if (existingUser.getPassword() == user.getPassword()) {//9
                    same += 1; //10
                }
            }//11
        }

        String specialCharacters="!#$%&'()*+,-./:;<=>?@[]^_`{|}"; //12
        String password = user.getPassword(); //12
        String passwordLower = password.toLowerCase();//12

        if (passwordLower.contains(user.getUsername().toLowerCase()) || password.length()<8) { //12
            return false; //13
        }
        else { //14
            if (!passwordLower.contains(" ")) { //15
                for (int i = 0; i < specialCharacters.length(); i++) { //16
                    if (password.contains(String.valueOf(specialCharacters.charAt(i)))) { //17
                        return same == 0; //18
                    }
                }//19
            }
        }
        if(same == 2){ //20
            return true; //21
        } else { //22
            return false; //22
        }
    } //23

}
