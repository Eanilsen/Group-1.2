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
 * @author Even
 */
public class ModuleDTO implements Serializable {
    private int id;
    private String name;    
    
    public ModuleDTO(int id, String name){
        this.id=id;
        this.name=name;
    }
}