package com.usecases;

import com.dao.AdminDao;
import com.dao.AdminDaoImpl;

import java.util.Scanner;

import static com.authentication.AuthenticImpl.BLACK_BACKGROUND;
import static com.authentication.AuthenticImpl.WHITE_BOLD_BRIGHT;
import static com.usecases.CreateBatch.TEXT_RESET;

public class UpdateCoursePlan {
    public void updateCoursePlan() {

        Scanner sc = new Scanner(System.in);
        Scanner sc2 = new Scanner(System.in);
        System.out.println(BLACK_BACKGROUND+WHITE_BOLD_BRIGHT+"_________________________Update Course Plan________________________________"+TEXT_RESET);
        System.out.println();

        System.out.print("Enter Plan Id : "); int planId = sc.nextInt();
        System.out.println();
        System.out.println("Enter Updated Value");
        System.out.println();

        System.out.print("Enter Batch Id : "); int batchId = sc.nextInt();
        System.out.print("Enter Day Number : "); int dayNumber = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter Topic : "); String topic = sc.nextLine();
        System.out.print("Enter Status(completed/pending) : " ); String status = sc2.next();


        AdminDao dao = new AdminDaoImpl();
        String result =dao.updateCoursePlan(planId,batchId,dayNumber,topic, status);
        System.out.println(result);

    }
}
