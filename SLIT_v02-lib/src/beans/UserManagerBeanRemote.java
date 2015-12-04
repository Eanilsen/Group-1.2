
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import DTOs.RolesEnum;
import DTOs.UserDTO;
import java.util.List;
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

    public List<UserDTO> getUserList();

    public void Login(int ID);

    public RolesEnum getCurrentUserRole();

    public UserDTO getCurrentUserDTO();
    
}
