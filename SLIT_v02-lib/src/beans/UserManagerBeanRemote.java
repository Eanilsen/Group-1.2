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
public interface UserManagerBeanRemote {

    /**
     * if existing, returns the name of the user with given id
     * @param i
     * @return 
     */
    public String getUserName(int i);
    
    public void addUsers(int id);
    
}
