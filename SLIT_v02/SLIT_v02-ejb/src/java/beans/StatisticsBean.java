/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import DTOs.ModuleDTO;
import basicBeans.UsersFacade;
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
public class StatisticsBean implements StatisticsBeanRemote {
    @PersistenceContext(unitName = "SLIT_v02-ejbPU")
    private EntityManager em;
    private UsersFacade userFacade = new UsersFacade();   
    
    

    public void persist(Object object) {
        em.persist(object);
    }

    
    
}
