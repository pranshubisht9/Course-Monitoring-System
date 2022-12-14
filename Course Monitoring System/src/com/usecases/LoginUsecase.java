package com.usecases;

import com.authentication.Authentic;
import com.authentication.AuthenticImpl;
import com.exceptions.AdminException;

import java.util.Scanner;

public class LoginUsecase {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("*************************________Login_________************************************");
        System.out.println();
        System.out.print("Enter Username : "); String username = sc.next();
        System.out.print("Enter Password : "); String password = sc.next();
        System.out.println();
        System.out.println("************************************************************************************");

        Authentic auth = new AuthenticImpl();

        try {
            String x = auth.loginAdmin(username,password);
            System.out.println(x);

//            if(x){
//                System.out.println(true);
//            }else{
//                System.out.println(false);
//            }

        } catch (AdminException e) {
            throw new RuntimeException(e);
        }
    }
}
