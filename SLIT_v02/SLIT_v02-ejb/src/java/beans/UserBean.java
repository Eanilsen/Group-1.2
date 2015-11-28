/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import basicBeans.UsersFacade;
import entities.Users;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Jons
 */ 
@Stateful
public class UserBean implements UserBeanRemote {

    private Users user;

    public UserBean() {
    }

    
    
    public UserBean(Users user){
        this.user = user;
    }
    /**
     * returns the combined First and Lastname
     *
     * @return
     */


    public String getLastname() {
        return user.getLastname();
    }

    public String getFirstname() {
        return user.getFirstname();
    }

}
