package com.dao;

import com.exceptions.AdminException;

public interface AdminDao {
    boolean loginAdmin(String username, String password) throws AdminException;

}
