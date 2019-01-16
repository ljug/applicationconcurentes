package net.cofares.ljug;

import ljug.util.JDBCUtil;
import ljug.util.JDBCUtilFactory;

/**
 *
 * @author ppfar
 */
public class Main {
    
    public static void main(String args[]) throws Exception {
        JDBCUtil jdt = JDBCUtilFactory.create();
        jdt.startStatement();
        jdt.executeSQLCommand("create database IF NOT EXISTS newDatabase");
        jdt.executeSQLCommand("create table IF NOT EXISTS newDatabase.Persons ("
                + "    PersonID int,"
                + "    LastName varchar(255),"
                + "    FirstName varchar(255),"
                + "    Address varchar(255),"
                + "    City varchar(255)"
                + ")");
        jdt.executeSQLCommand("INSERT INTO newDatabase.Persons ("
                + "    PersonID,"
                + "    LastName,"
                + "    FirstName,"
                + "    Address,"
                + "    City) VALUES (1,\'Fares\',\'Pascal\',\'Une adresse\',\'Baino\')");
        jdt.checkData("select * from newDatabase.Persons");
        jdt.endStatement();
    }
}
