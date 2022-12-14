package com.authentication;

import com.exceptions.AdminException;
import com.model.Course;

public interface Authentic {
    String loginAdmin(String username, String password) throws AdminException;
    String courseCreate(Course course);
}
