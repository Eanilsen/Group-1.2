/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import DTOs.ModuleDTO;
import basicBeans.ModuleFacade;
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

    private Users user;

    /**
     * author: Jorgen
     *
     * @return Stats for user 7
     */
    @Override
    public double getUserProgress(int studentID) {

        double progressPercentage = getApprovedModules(studentID).size() / moduleFacade.count();

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
            return null;
        } else {

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
     * author: Jorgen, Jonas returns a list with all unreviewed modules of given
     * student
     *
     * @param studentID Which user you want to get the list for
     * @return
     */
    @Override
    public Collection<ModuleDTO> getUnreviewedModules(int studentID) {
        user = em.find(Users.class, studentID);
        Collection<ModuleDTO> failedProgress = new ArrayList<>();

        Collection<Progress> progress = user.getProgressCollection();
        // for each data in table:progress, find all approved = true
        if (progress == null) {
            return null;
        } else {
            for (Progress p : user.getProgressCollection()) {
                if (p.getApproved() == null) {
                    ModuleDTO module = createModuleDTO(p);
                    failedProgress.add(module);
                }
            }
            return failedProgress;
        }
    }

    private ModuleDTO createModuleDTO(Progress p) {
        ModuleDTO module = new ModuleDTO(p.getModule().getIdmodule(), p.getModule().getName());
        return module;
    }

    @Override
    public double getCurrentUserProgress() {
        return getUserProgress(3);
    }

}
