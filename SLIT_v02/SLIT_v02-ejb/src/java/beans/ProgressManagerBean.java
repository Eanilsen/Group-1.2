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
import java.util.Date;
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

        double approved = (double) getApprovedModules(studentID).size();
        System.out.println("approved modules = " + approved);
        double moduleCount = (double) moduleFacade.count();
        System.out.println("all modules = " + moduleCount);
        
        double progressPercentage =  approved/moduleCount;
        System.out.println("return = " + progressPercentage);
        return progressPercentage;
    }
    
    /**
     *
     * @param ID
     * @param approved
     */
    @Override
    public void setProgress(int ID, boolean approved){
        progressFacade.find(ID).setApproved(approved);
        progressFacade.find(ID).setDateApproved(new Date(System.currentTimeMillis()));
        
    }

    /**
     * author: Jorgen, Jonas returns a list with all approved modules of given
     * student
     *
     * @param studentID Which user you want to get the list for
     * @return
     */
    @Override
    public Collection<ModuleDTO> getApprovedModules(int studentID) {
        Users users = em.find(Users.class, studentID);
        Collection<ModuleDTO> approvedList = new ArrayList<>();

        Collection<Progress> progress = users.getProgressCollection();
        // for each data in table:progress, find all approved = true
        if (progress == null) {
            System.out.println("No progress found");
            return null;
        } else {
            System.out.println("Found " + progress.size() + " modules for user " + users.getFirstname() + " " + users.getLastname());
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
        Users users = em.find(Users.class, studentID);
        Collection<ModuleDTO> failedProgress = new ArrayList<>();

        Collection<Progress> progress = users.getProgressCollection();
        // for each data in table:progress, find all approved = true
        if (progress == null) {
            return null;
        } else {
            for (Progress p : users.getProgressCollection()) {
                if (p.getApproved() != null && !p.getApproved()) {
                    ModuleDTO module = createModuleDTO(p);
                    failedProgress.add(module);
                }
            }
            return failedProgress;
        }
    }

    /**
     * author: Jonas
     *
     * @return
     */
    @Override
    public Collection<ProgressDTO> getAllPendingProgress() {

        Collection<ProgressDTO> pendingProgress = new ArrayList<>();

        Collection<Progress> progress = progressFacade.findAll();
        System.out.println("Recieved progress. count = " + progress.size());
        // for each data in table:progress, find all approved = null
        if (progress == null) {
            return null;
        } else {
            for (Progress p : progress) {

                if (p.getApproved() != null && p.getApproved()) {
                    System.out.println("progress is approved: " + p.getIdprogress());
                } else if (p.getApproved() != null && !p.getApproved()) {
                    System.out.println("progress is not approved: " + p.getIdprogress());

                } else {
                    System.out.println("progress is not reviewed: " + p.getIdprogress());
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
        Users users = em.find(Users.class, studentID);
        Collection<ModuleDTO> unreviewedProgress = new ArrayList<>();

        Collection<Progress> progress = users.getProgressCollection();
        // for each data in table:progress, find all approved = true
        if (progress == null) {
            return null;
        } else {
            for (Progress p : users.getProgressCollection()) {
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
        Users u = p.getUser();
        ModuleDTO module = createModuleDTO(p);
        UserDTO userDTO = new UserDTO(u.getIduser(), u.getFirstname() + " " + u.getLastname(), u.getEmail());
        return new ProgressDTO(p.getIdprogress(), "", userDTO, module);
    }

    @Override
    public double getCurrentUserProgress() {
        return getUserProgress(3);
    }

}
