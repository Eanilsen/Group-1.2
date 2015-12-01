/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTOs;

import beans.ProgressManagerBeanRemote;
import java.io.Serializable;
import javax.ejb.EJB;

/**
 *
 * @author Jons
 */
public class UserDTO implements Serializable{
    
    @EJB
    ProgressManagerBeanRemote progressBean;
    
    public int id;
    public String name;
    public String mail;
    
    public UserDTO(int id, String name, String mail){
        this.id=id;
        this.name=name;
        this.mail = mail;
    }
    public double getProgress(){
        return progressBean.getUserProgress(id);
    }
    
}
