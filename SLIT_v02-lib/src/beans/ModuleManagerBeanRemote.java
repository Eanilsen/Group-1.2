/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import DTOs.ModuleDTO;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author Jons
 * @author Even
 */
@Remote
public interface ModuleManagerBeanRemote {
    
    public String getName(int id);

    public String getDescription(int id);

    public List<ModuleDTO> getAllModules();

    public void createModule(String name, String description);

    public Boolean getApproved(int i);
}
