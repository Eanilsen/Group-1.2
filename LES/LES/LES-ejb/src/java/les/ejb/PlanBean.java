/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package les.ejb;

import les.ejb.plan.PlanBeanRemote;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import les.entities.plan.Plan;

/**
 *
 * @author Jorgen
 */
@Stateless
public class PlanBean implements PlanBeanRemote {
    
    //Retrieving data from db to ejb
    //Add EntityManager field in an ejb, add @PersistenceContext annotation
    @PersistenceContext
    private EntityManager em;
    
    
    //These methods are overriden from PlanBeanRemote with sigs.
    @Override
    public String testTheEJB(String input) {
        return "The input was: " + input;
    }
    
    //Something we did with Even to test our code
    @Override
    public void testDataSource() {
        TypedQuery<Plan> query 
                = em.createNamedQuery("select p from Plan p", 
                        Plan.class);
        List<Plan> plans = query.getResultList();
        System.out.println(""+plans.size()+ " hits");
        for (Plan p : plans){
            System.out.println(p);
        }
    }
}
