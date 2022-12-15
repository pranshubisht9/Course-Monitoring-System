package com.dao;

import com.exceptions.AdminException;
import com.model.Batch;
import com.model.Course;
import com.model.CoursePlan;
import com.model.Faculty;
import com.utility.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AdminDaoImpl implements AdminDao{
    @Override
    public String createCourse(Course course) {
        String msg = "Not inserted...";

        try(Connection con = DBUtil.provideConnection()){
            PreparedStatement ps = con.prepareStatement("insert into course(courseName,fee,courseDescription) values (?,?,?)");
//            ps.setInt(1,course.getCourseId());
            ps.setString(1,course.getCourseName());
            ps.setInt(2,course.getFees());
            ps.setString(3,course.getCourseDescription());

            int x = ps.executeUpdate();

            if(x>0){
                msg = "Course Inserted Successfully...";
            }
        }catch (SQLException e) {

            throw new RuntimeException(e);
        }


        return msg;
    }

    @Override
    public String createFaculty(Faculty faculty) {
        String msg = "Not inserted...";

        try(Connection con = DBUtil.provideConnection()){
            PreparedStatement ps = con.prepareStatement("insert into faculty(facultyname,facultyaddress,mobile,email,username,password) values (?,?,?,?,?,?)");
            ps.setString(1,faculty.getFacultyName());
            ps.setString(2,faculty.getFacultyAddress());
            ps.setLong(3,faculty.getMobile());
            ps.setString(4,faculty.getEmail());
            ps.setString(5,faculty.getUsername());
            ps.setString(6,faculty.getPassword());


            int x = ps.executeUpdate();

            if(x>0){
                msg = "Faculty Inserted Successfully...";
            }
        }catch (SQLException e) {

            throw new RuntimeException(e);
        }


        return msg;
    }

    @Override
    public String createBatch(Batch batch) {
        String msg = "Not inserted...";

        try(Connection con = DBUtil.provideConnection()){
            PreparedStatement ps = con.prepareStatement("insert into batch(courseId,facultyId,numberofStudents,batchstartDate,duration) values (?,?,?,?,?)");
//            ps.setInt(1,batch.setBatchId());
            ps.setInt(1,batch.getCourseId());
            ps.setInt(2,batch.getFacultyId());
            ps.setInt(3,batch.getNumberOfStudents());
            ps.setString(4,batch.getBatchStartDate());
            ps.setLong(5,batch.getDuration());


            int x = ps.executeUpdate();

            if(x>0){
                msg = "Batch Inserted Successfully...";
            }
        }catch (SQLException e) {

            throw new RuntimeException(e);
        }
        return msg;
    }

    @Override
    public String createCoursePlan(CoursePlan cp) {
        String msg = "Not inserted...";

        try(Connection con = DBUtil.provideConnection()){
            PreparedStatement ps = con.prepareStatement("insert into courseplan(batchId,daynumber,topic,status) values (?,?,?,?)");
//            ps.setInt(1,batch.setBatchId());
            ps.setInt(1,cp.getBatchId());
            ps.setInt(2,cp.getDaynumber());
            ps.setString(3,cp.getTopic());
            ps.setString(4,cp.getStatus());


            int x = ps.executeUpdate();

            if(x>0){
                msg = "Batch Inserted Successfully...";
            }
        }catch (SQLException e) {

            throw new RuntimeException(e);
        }
        return msg;
    }
}
