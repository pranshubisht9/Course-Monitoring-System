package com.authentication;
import com.dao.AdminDao;
import com.dao.AdminDaoImpl;
import com.exceptions.AdminException;
import com.model.Course;
import com.screens.BatchScreen;
import com.screens.CoursePlanScreen;
import com.screens.CourseSreen;
import com.screens.FacultyScreen;
import com.usecases.*;
import com.utility.DBUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;


public class AuthenticImpl implements Authentic {
    public static final String TEXT_RED = "\u001B[31m";
    public static final String TEXT_RESET = "\u001B[0m";

    public static final String ANSI_YELLOW_BACKGROUND = "\u001B[43m";
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
                    System.out.println("Please Wait...");

                    Thread.sleep(3000);


                    System.out.println("Admin Login Sucessfully");
                    Thread.sleep(2000);
                    AdminLoginScreen();
                    return null;

                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }


            }
            else if(fa_rs.next()){
//               here i have to make a further funtion as per as flow for faculti
//                return true;
                msg = "Faculty Login";
//                Faculty f = new Faculty();
//                String x = f.getUsername();


                updateFacPass(username);



               FacultyLoginScreen();

            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return msg;
    }

    private static void updateFacPass(String username) {
        SetFacultyPassword sfp = new SetFacultyPassword();
       String password = sfp.setFacultyPassword();

       try(Connection con = DBUtil.provideConnection()) {

//           PreparedStatement ps =


       }catch (SQLException e){
           e.printStackTrace();
       }



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
        System.out.println();
        System.out.print("Enter Your Selected Number -> ");
        int val = sc.nextInt();
        System.out.println("*****************************************************************");
        
        switch (val){

            //to achieve the nested method here i have been using lambda expression


            case 1: // course Section

                CourseSreen cs = () -> {

                    System.out.println("Add New Course : "+TEXT_RED+"ENTER-1"+TEXT_RESET);
                    System.out.println("Update Course : "+TEXT_RED+"ENTER-2"+TEXT_RESET);
                    System.out.println("View Course : "+TEXT_RED+"ENTER-3"+TEXT_RESET);


                    System.out.println();
                    System.out.print("Enter Your Selected Number -> ");
                    int c = sc.nextInt();

                    switch (c) {
                        case 1: //this is for adding new course
                            CreateCourse cc = new CreateCourse();
                            cc.createCourse();

                            break;
                        case 2: // this is for updating course

                            UpdateCourse uc = new UpdateCourse();
                            uc.updateCourse();

                            break;
                        case 3: // this is for view course

                        AdminDao ad = new AdminDaoImpl();
                        ad.viewCourse();
                            break;
                    }

                };

                cs.courseSection();

                break;






            case 2: // Faculty Screen

                FacultyScreen fs = () -> {
                    System.out.println("Add New Course : "+TEXT_RED+"ENTER-1"+TEXT_RESET);
                    System.out.println("Update Course : "+TEXT_RED+"ENTER-2"+TEXT_RESET);
                    System.out.println("View Course : "+TEXT_RED+"ENTER-3"+TEXT_RESET);


                    System.out.println();
                    System.out.print("Enter Your Selected Number -> ");
                    int c = sc.nextInt();

                    switch (c) {
                        case 1: //this is for adding new faculty

                            CreateFaculty cf = new CreateFaculty();
                            cf.createFaculty();

                            break;
                        case 2: // this is for updating faculty

                            UpdateFaculty uf = new UpdateFaculty();
                            uf.updateFaculty();
                            break;

                        case 3: // this is for view faculty

                            AdminDao dao = new AdminDaoImpl();
                            dao.viewFaculty();

                            break;
                    }

                };

                fs.facultySectionScreen();

                break;






            case 3: //Batch Screen

                BatchScreen bs = () -> {
                    System.out.println("Add New Course : "+TEXT_RED+"ENTER-1"+TEXT_RESET);
                    System.out.println("Update Course : "+TEXT_RED+"ENTER-2"+TEXT_RESET);
                    System.out.println("View Course : "+TEXT_RED+"ENTER-3"+TEXT_RESET);


                    System.out.println();
                    System.out.print("Enter Your Selected Number -> ");
                    int c = sc.nextInt();

                    switch (c) {
                        case 1: //this is for adding new batch

                            CreateBatch cb = new CreateBatch();
                            cb.createBatch();
                            break;

                        case 2: // this is for updating batch

                            UpdateBatch ub = new UpdateBatch();
                            ub.updateBatch();
                            break;

                        case 3: // this is for view batch
                            AdminDao ad = new AdminDaoImpl();
                            ad.viewBatch();
                            break;
                    }

                };

            bs.batchSection();
                break;





            case 4: //Course Planner Screen
                CoursePlanScreen cps = () -> {

                    System.out.println("Add New Course : "+TEXT_RED+"ENTER-1"+TEXT_RESET);
                    System.out.println("Update Course : "+TEXT_RED+"ENTER-2"+TEXT_RESET);
                    System.out.println("View Course : "+TEXT_RED+"ENTER-3"+TEXT_RESET);


                    System.out.println();
                    System.out.print("Enter Your Selected Number -> ");
                    int c = sc.nextInt();

                    switch (c) {
                        case 1: //this is for adding new coursePlanner
                            CreateCoursePlan ccp = new CreateCoursePlan();
                            ccp.createCoursePlan();
                            break;

                        case 2: // this is for updating coursePlanner
                            UpdateCoursePlan ucp = new UpdateCoursePlan();
                            ucp.updateCoursePlan();
                            break;

                        case 3: // this is for view coursePlanner
                            AdminDao dao = new AdminDaoImpl();
                            dao.viewCoursePlan();
                            break;
                    }
                };
                cps.coursePlanSection();
                break;
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
        switch (val){
        case 1: // this is for create coursePlanner
            CreateCoursePlan ccp = new CreateCoursePlan();
            ccp.createCoursePlan();
            break;

        case 2: // this is for Course Plan Update
            UpdateCoursePlan ucp = new UpdateCoursePlan();
            ucp.updateCoursePlan();
            break;

        case 3: // this is for course plan view
            AdminDao dao = new AdminDaoImpl();
            dao.viewCoursePlan();
            break;

        case 4:
            System.out.println(4);
            break;
    }
    }


}


