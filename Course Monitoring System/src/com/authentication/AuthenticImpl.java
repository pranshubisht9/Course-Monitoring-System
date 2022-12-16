package com.authentication;
import com.dao.AdminDaoImpl;
import com.exceptions.AdminException;
import com.model.Course;
import com.utility.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;


public class AuthenticImpl implements Authentic {
    public static final String TEXT_RED = "\u001B[31m";
    public static final String TEXT_RESET = "\u001B[0m";
    @Override
    public String login(String username, String password) throws AdminException {

        String msg = "Wrong Credentials";

        try (Connection con = DBUtil.provideConnection()){

            PreparedStatement ad_ps = con.prepareStatement("select * from admin where username = ? and password = ?");

            ad_ps.setString(1,username);
           ad_ps.setString(2,password);

            PreparedStatement fa_ps = con.prepareStatement("select * from faculty where username = ? and password = ?");

            fa_ps.setString(1,username);
            fa_ps.setString(2,password);

            ResultSet ad_rs = ad_ps.executeQuery();
            ResultSet fa_rs = fa_ps.executeQuery();


            if(ad_rs.next()){
//               here i have to make a further funtion as per as flow for admin


                //for pausing some seconds

                try {
                    System.out.println("Please Wait");

                    TimeUnit.SECONDS.sleep(4);
//                    for()
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

                msg = "Admin Login Sucessfully...";


                AdminLoginScreen();
                return msg;
            }
            else if(fa_rs.next()){
//               here i have to make a further funtion as per as flow for faculti
//                return true;
                msg = "Faculty Login";

               FacultyLoginScreen();

            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return msg;
    }

    @Override
    public String courseCreate(Course course) {
        return null;
    }

    private void AdminLoginScreen() {
        System.out.println("***************************************************************");
//        System.out.println();
        System.out.println("___________Admin Login Screen____________");
        System.out.println("Course Section -> "+TEXT_RED+"ENTER-1"+TEXT_RESET);
        System.out.println("Faculty Section -> "+TEXT_RED+"ENTER-2"+TEXT_RESET);
        System.out.println("Batch Section -> "+TEXT_RED+"ENTER-3"+TEXT_RESET);
        System.out.println("Course Planner Section -> "+TEXT_RED+"ENTER-4"+TEXT_RESET);

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Your Selected Number -> ");
        int val = sc.nextInt();
        System.out.println("*****************************************************************");
        
        if(val == 1){

        }


    }



    private void FacultyLoginScreen() {
        System.out.println("*****************************************************************");
//        System.out.println();
        System.out.println("____________Faculty Login Screen______________");
        System.out.println("Create Course Plan -> "+TEXT_RED+"ENTER-1"+TEXT_RESET);
        System.out.println("Course Plan Update -> "+TEXT_RED+"ENTER-2"+TEXT_RESET);
        System.out.println("Course Plan View -> "+TEXT_RED+"ENTER-3"+TEXT_RESET);
        System.out.println("Reset Password -> "+TEXT_RED+"ENTER-4"+TEXT_RESET);
        Scanner sc = new Scanner(System.in);
        System.out.println();
        System.out.print("Enter Your Selected Number -> ");
        int val = sc.nextInt();
        System.out.println("*****************************************************************");
    }
    
    

}


