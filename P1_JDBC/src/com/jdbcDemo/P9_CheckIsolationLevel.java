package com.jdbcDemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class P9_CheckIsolationLevel {

    public static void main(String[] args) throws Exception {

        Class.forName("com.mysql.cj.jdbc.Driver");

        Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/knowit", "root", "root");

        Statement stmt = con.createStatement();

        ResultSet rs1 = stmt.executeQuery("SELECT @@session.transaction_isolation");
        if (rs1.next()) {
            System.out.println("Session Isolation Level : " + rs1.getString(1));
        }

        ResultSet rs2 = stmt.executeQuery("SELECT @@global.transaction_isolation");
        if (rs2.next()) {
            System.out.println("Global Isolation Level  : " + rs2.getString(1));
        }

        System.out.println("\nJDBC Isolation Level Constants:");
        System.out.println("TRANSACTION_NONE              = " + Connection.TRANSACTION_NONE);
        System.out.println("TRANSACTION_READ_UNCOMMITTED  = " + Connection.TRANSACTION_READ_UNCOMMITTED);
        System.out.println("TRANSACTION_READ_COMMITTED    = " + Connection.TRANSACTION_READ_COMMITTED);
        System.out.println("TRANSACTION_REPEATABLE_READ   = " + Connection.TRANSACTION_REPEATABLE_READ);
        System.out.println("TRANSACTION_SERIALIZABLE      = " + Connection.TRANSACTION_SERIALIZABLE);

        con.close();
    }
}
