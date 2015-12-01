/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTOs;

/**
 *
 * @author Jons
 */
public class ProgressDTO extends DTO{
    
    public ModuleDTO module;
    public UserDTO user;
    
    public ProgressDTO(int id, String name) {
        super(id, name);
    }
    public ProgressDTO(int id, String name, UserDTO user, ModuleDTO module){
        super(id, name);
        this.module=module;
        this.user=user;
    }
    
}
