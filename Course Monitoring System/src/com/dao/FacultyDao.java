package com.dao;

import com.exceptions.AdminException;
import com.exceptions.FacultyException;

public interface FacultyDao {
    boolean loginFaculty(String username, String password) throws FacultyException;

}
