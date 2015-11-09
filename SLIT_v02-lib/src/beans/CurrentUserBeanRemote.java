/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import javax.ejb.Remote;

/**
 * This bean has control over the current user
 * @author Jons
 */
@Remote
public interface CurrentUserBeanRemote {

    public String getName();

    public ModuleManagerBeanRemote getModuleManager();
    
}
