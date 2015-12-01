/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;


import javax.ejb.Remote;

/**
 *
 * @author Jons
 */
@Remote
public interface InitializeDatabaseBeanRemote {
    
    public void createDatabase(int students, int teachers, int files);

    public void addStudents(int amount);

    public void addTeachers(int amount);
    
}
