/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import DTOs.ModuleDTO;
import DTOs.ProgressDTO;
import java.util.Collection;
import javax.ejb.Remote;

/**
 *
 * @author Jorgen
 */
@Remote
public interface ProgressManagerBeanRemote {

    public double getCurrentUserProgress();
    
    public double getUserProgress(int studentID);

    public Collection<ModuleDTO> getPendingModules(int studentID);

    public Collection<ModuleDTO> getApprovedModules(int studentID);

    public Collection<ModuleDTO> getFailedModules(int studentID);

    public Collection<ProgressDTO> getAllPendingProgress();

    public void setProgress(int ID, boolean approved);

    
    
    
}
