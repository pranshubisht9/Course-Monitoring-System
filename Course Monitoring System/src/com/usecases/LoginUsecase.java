package com.usecases;

import com.authentication.Authentic;
import com.authentication.AuthenticImpl;
import com.exceptions.AdminException;

import java.util.Scanner;

import static com.authentication.AuthenticImpl.BLACK_BACKGROUND;
import static com.authentication.AuthenticImpl.WHITE_BOLD_BRIGHT;
import static com.usecases.CreateBatch.TEXT_RESET;

public class LoginUsecase {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println(BLACK_BACKGROUND+WHITE_BOLD_BRIGHT+"_________________________Login Screen_______________________________"+TEXT_RESET);
        System.out.println();
        System.out.print("Enter Username : "); String username = sc.next();
        System.out.print("Enter Password : "); String password = sc.next();
        System.out.println();
        System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        Authentic auth = new AuthenticImpl();

        try {
            String x = auth.login(username,password);
            if(x == null){}
            else{
                System.out.println(x);
            }

        } catch (AdminException e) {
            throw new RuntimeException(e);
        }
    }

    public void loginBack() {
        Scanner sc = new Scanner(System.in);
        System.out.println(BLACK_BACKGROUND+WHITE_BOLD_BRIGHT+"_________________________Login Screen_______________________________"+TEXT_RESET);
        System.out.println();
        System.out.print("Enter Username : "); String username = sc.next();
        System.out.print("Enter Password : "); String password = sc.next();
        System.out.println();
        System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");


        Authentic auth = new AuthenticImpl();

        try {
            String x = auth.login(username,password);
            if(x == null){}
            else{
                System.out.println(x);
            }

        } catch (AdminException e) {
            throw new RuntimeException(e);
        }
    }
}
