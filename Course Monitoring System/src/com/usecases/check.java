package com.usecases;

import com.dao.AdminDao;
import com.dao.AdminDaoImpl;

public class check {
    public static void main(String[] args) {
        AdminDao a = new AdminDaoImpl();
        a.viewBatch();
    }
}
