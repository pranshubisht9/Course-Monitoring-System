package com.usecases;

import com.dao.FacultyDao;
import com.dao.FacultyDaoImpl;

import java.sql.SQLOutput;
import java.util.Scanner;

public class SetFacultyPassword {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println();
        System.out.print("Enter Updated Password : ");

        System.out.print("Enter New Password : "); String newPassword = sc.next();
        System.out.println("Confirm Password : "); String confirmPassword = sc.next();

        FacultyDao dao = new FacultyDaoImpl();

        if(newPassword.equals(confirmPassword)){
            dao.updatePassword(newPassword);
        }

    }
}
