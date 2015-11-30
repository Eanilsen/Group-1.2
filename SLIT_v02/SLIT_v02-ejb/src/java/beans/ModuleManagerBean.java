/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import DTOs.ModuleDTO;
import basicBeans.ModuleFacade;
import entities.Module;
import entities.Users;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateful;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Jons
 * @authon Even
 */
@Stateful
public class ModuleManagerBean implements ModuleManagerBeanRemote {
    @PersistenceContext(unitName = "SLIT_v02-ejbPU")
    @EJB
    private ModuleFacade mf;
    private List<Module> modules;
    private Users currentUser;

    /**
     * Finds a module by its primary key and returns its name.
     * @param id primary key
     * @return module key
     */
    public String getName(int id) {
        Module m = mf.find(id);
        return m.getName();
    }

    /**
     * Finds a module by its primary key and returns its description.
     * @param id primary key
     * @return module description
     */
    public String getDescription(int id) {
        Module m = mf.find(id);
        return m.getDescription();
    }
    
    /**
     * Gets all the 
     * @return 
     */
    public List<ModuleDTO> getAllModules(){
        ArrayList<ModuleDTO> moduleList = new ArrayList<>();
        for (Module m : mf.findAll()) {
            ModuleDTO mdto = new ModuleDTO(m.getIdmodule(), m.getName());
            moduleList.add(mdto);
        }
        return moduleList;
    }

    public void createModule(String name, String description) {
        Module m = new Module();
        m.setName(name);
        m.setDescription(description);
        mf.create(m);
    }
}
