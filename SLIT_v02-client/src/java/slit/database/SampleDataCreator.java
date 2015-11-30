/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package slit.database;

import slit.main.Main;

/**
 *
 * @author Jons
 */
public class SampleDataCreator {
//    @EJB
//    private static InitializeDatabaseBeanRemote dataCreator;
//
//    public static InitializeDatabaseBeanRemote getDataCreator() {
//        return dataCreator;
//    }

    /**
     * Creates some sample Data in the database using ejb
     *
     * @param args
     */
    public static void main(String args[]) {
        System.out.println("Create sample Data now..... Look at server output for more details");
        Main.getDataCreator().createDatabase(100, 10, 30, 30); //students, teachers, progress, files
//        Main.getDataCreator().createStudents(10);
//        Main.getDataCreator().createTeachers(100);
    }
}
