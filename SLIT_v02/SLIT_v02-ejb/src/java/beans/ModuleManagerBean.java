/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import DTOs.ModuleDTO;
import basicBeans.ModuleFacade;
import entities.Module;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateful;

/**
 *
 * @author Jons
 * @authon Even
 */
@Stateful
public class ModuleManagerBean implements ModuleManagerBeanRemote {
    @EJB
    private ModuleFacade mf;

    /**
     * Finds a module by its primary key and returns its name.
     * @param id primary key
     * @return module key
     */
    @Override
    public String getName(int id) {
        Module m = mf.find(id);
        return m.getName();
    }

    /**
     * Finds a module by its primary key and returns its description.
     * @param id primary key
     * @return module description
     */
    @Override
    public String getDescription(int id) {
        Module m = mf.find(id);
        return m.getDescription();
    }
    
    /**
     * Gets all the modules stored in the database and creates DTOs for the
     * client to access.
     * @return List of moduleDTOs
     */
    @Override
    public List<ModuleDTO> getAllModules(){
        ArrayList<ModuleDTO> moduleList = new ArrayList<>();
        for (Module m : mf.findAll()) {
            ModuleDTO mdto = new ModuleDTO(m.getIdmodule(), m.getName());
            moduleList.add(mdto);
        }
        return moduleList;
    }

    /**
     * Creates a new module and persists it.
     * @param name module name
     * @param description module description
     */
    @Override
    public void createModule(String name, String description) {
        Module m = new Module();
        m.setName(name);
        m.setDescription(description);
        mf.create(m);
    }
}
