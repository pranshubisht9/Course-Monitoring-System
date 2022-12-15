package com.dao;

import com.model.Batch;
import com.model.Course;
import com.model.CoursePlan;
import com.model.Faculty;

public interface AdminDao {
String createCourse(Course course);
String createFaculty(Faculty faculty);
String createBatch(Batch faculty);
String createCoursePlan(CoursePlan cp);
String updateCourse();

}
