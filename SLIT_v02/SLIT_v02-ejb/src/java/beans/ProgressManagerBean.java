/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import DTOs.ModuleDTO;
import DTOs.ProgressDTO;
import DTOs.UserDTO;
import basicBeans.ModuleFacade;
import basicBeans.ProgressFacade;
import basicBeans.UsersFacade;
import entities.Progress;
import entities.Users;
import java.util.ArrayList;
import java.util.Collection;
import javax.ejb.EJB;
import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Jorgen, Jons
 */
@Stateful
public class ProgressManagerBean implements ProgressManagerBeanRemote {

    @PersistenceContext(unitName = "SLIT_v02-ejbPU")
    private EntityManager em;

    @EJB
    private UsersFacade userFacade;

    @EJB
    private ModuleFacade moduleFacade;
    
    @EJB
    private ProgressFacade progressFacade;

    private Users user;

    /**
     * author: Jorgen
     *
     * @param studentID
     * @return Stats for user 7
     */
    @Override
    public double getUserProgress(int studentID) {

        double progressPercentage = (double)getApprovedModules(studentID).size() / (double)moduleFacade.count();

        return progressPercentage;
    }

    /**
     * author: Jorgen, Jonas 
     * returns a list with all approved modules of given
     * student
     *
     * @param studentID Which user you want to get the list for
     * @return
     */
    @Override
    public Collection<ModuleDTO> getApprovedModules(int studentID) {
        user = em.find(Users.class, studentID);
        Collection<ModuleDTO> approvedList = new ArrayList<>();

        Collection<Progress> progress = user.getProgressCollection();
        // for each data in table:progress, find all approved = true
        if (progress == null) {
            System.out.println("No progress found");
            return null;
        } else {
                System.out.println("Found " + progress.size() + " modules for user " + user.getFirstname() + " " + user.getLastname());
            for (Progress p : progress) {
                if (p.getApproved() != null && p.getApproved()) {
                    ModuleDTO module = createModuleDTO(p);
                    approvedList.add(module);
                }
            }
            return approvedList;
        }
    }

    /**
     * author: Jorgen, Jonas returns a list with all failed modules of given
     * student
     *
     * @param studentID Which user you want to get the list for
     * @return
     */
    @Override
    public Collection<ModuleDTO> getFailedModules(int studentID) {
        user = em.find(Users.class, studentID);
        Collection<ModuleDTO> failedProgress = new ArrayList<>();

        Collection<Progress> progress = user.getProgressCollection();
        // for each data in table:progress, find all approved = true
        if (progress == null) {
            return null;
        } else {
            for (Progress p : user.getProgressCollection()) {
                if (p.getApproved() != null && !p.getApproved()) {
                    ModuleDTO module = createModuleDTO(p);
                    failedProgress.add(module);
                }
            }
            return failedProgress;
        }
    }

    /**
     * author: Jorgen, Jonas returns a list with all failed modules of given
     * student
     *
     * @param studentID Which user you want to get the list for
     * @return
     */
    @Override
    public Collection<ProgressDTO> getAllPendingProgress() {

        Collection<ProgressDTO> pendingProgress = new ArrayList<>();

        Collection<Progress> progress = progressFacade.findAll();
        // for each data in table:progress, find all approved = null
        if (progress == null) {
            return null;
        } else {
            for (Progress p : progress) {
                if (p.getApproved() == null) {
                    
                    pendingProgress.add(createProgressDTO(p));
                }
            }
            return pendingProgress;
        }
    }
    
    /**
     * author: Jorgen, Jonas returns a list with all unreviewed modules of given
     * student
     *
     * @param studentID Which user you want to get the list for
     * @return
     */
    @Override
    public Collection<ModuleDTO> getPendingModules(int studentID) {
        user = em.find(Users.class, studentID);
        Collection<ModuleDTO> unreviewedProgress = new ArrayList<>();

        Collection<Progress> progress = user.getProgressCollection();
        // for each data in table:progress, find all approved = true
        if (progress == null) {
            return null;
        } else {
            for (Progress p : user.getProgressCollection()) {
                if (p.getApproved() == null) {
                    ModuleDTO module = createModuleDTO(p);
                    unreviewedProgress.add(module);
                }
            }
            return unreviewedProgress;
        }
    }

    private ModuleDTO createModuleDTO(Progress p) {
        ModuleDTO module = new ModuleDTO(p.getModule().getIdmodule(), p.getModule().getName());
        return module;
    }
    
    private ProgressDTO createProgressDTO(Progress p) {
        Users u =p.getUser();
        ModuleDTO module = createModuleDTO(p);
        UserDTO user = new UserDTO(u.getIduser(), u.getFirstname() + " " + u.getLastname(), u.getEmail());      
        return new ProgressDTO(p.getIdprogress(), "" , user, module);
    }

    @Override
    public double getCurrentUserProgress() {
        return getUserProgress(3);
    }

}
