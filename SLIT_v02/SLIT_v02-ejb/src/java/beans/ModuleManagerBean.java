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
    private final ModuleFacade mf;
    private List<Module> modules;
    private Users currentUser;

    public ModuleManagerBean() {
        this.mf = new ModuleFacade();
    }

    ModuleManagerBean(Users user) {
        currentUser = user;
        this.mf = new ModuleFacade();
    }

    public String getName(int id) {
        Module m = mf.find(id);
        return m.getName();
    }

    public String getDescription(int id) {
        Module m = mf.find(id);
        return m.getDescription();
    }
    
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
