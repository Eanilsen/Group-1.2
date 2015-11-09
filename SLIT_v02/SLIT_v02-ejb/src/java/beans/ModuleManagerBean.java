/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import entities.Module;
import entities.Users;
import java.util.List;
import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Jons
 */
@Stateful
public class ModuleManagerBean implements ModuleManagerBeanRemote {
    @PersistenceContext(unitName = "SLIT_v02-ejbPU")
    private EntityManager em;
    
    private List<Module> modules;
    private Users currentUser;

    public ModuleManagerBean() {
    }

    ModuleManagerBean(Users user) {
        currentUser = user;
    }
    
    public List<Module> getAllModules(){
        return Module
    }
    
    

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    public void persist(Object object) {
        em.persist(object);
    }
    
}
