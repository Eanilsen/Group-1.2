/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import entities.AvailableRoles;
import entities.Progress;
import entities.Users;
import enums.RolesEnum;
import java.util.ArrayList;
import java.util.Collection;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Jorgen
 */
@Stateless
public class ProgressManagerBean implements ProgressManagerBeanRemote {

    @PersistenceContext(unitName = "SLIT_v02-ejbPU")
    private EntityManager em;
    private Users user;
    private Progress progress;
    private RolesEnum roles;
    
    /**
     * @author Jorgen L.
     * @return 
     */
    @Override
    public double theProgress(){
        System.out.println("theProgress");
        double modules = 5.0;
        double modulesCompleted = 1.0;
        double prog = modulesCompleted / modules; //replace 1 with modules completed
        //everything inside entity Progress is completed modules. Find the user 
        //and then look for how many modules he has completed. Then divide on 14.
        System.out.println(prog);
        return prog;
    }
    /**
     * @author JH
     * returns a list of users that are in the specified role
     * @param role
     * @return 
     */
    public Collection<Users> findUserByRole(RolesEnum role){
        return em.find(AvailableRoles.class, role.ordinal()).getUsersCollection();        
    }
    
    /**
     * @author Jorgen Lybeck
     * @return allStudents a list of all students in the database
     */
    public Collection<Users> getStudents(){
        Collection<Users> allStudents = new ArrayList<>();
        
        //for each user in Collection<Users> that is students
        for (Users u : findUserByRole(em.find(RolesEnum.class, 4))){
            allStudents.add(u);
        }
        return allStudents;
    }
    
    @Override
    public void getStudentProgress(){
        progress.getModule();
        for (Users u : getStudents()){
             //u = all individual students
             
        }

    }
}
