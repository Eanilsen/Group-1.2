/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTOs;

import java.io.Serializable;

/**
 *
 * @author Jons
 */
public class UserDTO implements Serializable{
    
    public int id;
    public String name;
    private RolesEnum role;
    
    public UserDTO(int id, String name){
        this.id=id;
        this.name=name;
        this.role = role;
        
    }
    
}
