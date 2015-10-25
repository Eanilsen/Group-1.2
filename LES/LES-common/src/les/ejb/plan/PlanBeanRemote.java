/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package les.ejb.plan;

import javax.ejb.Remote;

/**
 *
 * @author Tyrion
 */
@Remote
public interface PlanBeanRemote {
    
    public String testTheEJB(String input);
     
    public void testDataSource();
    
}
