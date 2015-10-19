/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package slit.ejb.plan;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;

/**
 *
 * @author even
 */
@Stateless
public class PlanBean implements PlanBeanRemote
{

    @Override
    public List<PlanItem> getPlan(String student) {
        List<PlanItem> plan = new ArrayList<>();
        plan.add(new PlanItem(1, new Date(2015, 1, 31), new Date(2015, 1, 30)));
        plan.add(new PlanItem(2, new Date(2015, 2, 15), new Date(2015, 2, 28)));
        plan.add(new PlanItem(3, new Date(2015, 3, 3), new Date(2015, 3, 1)));
        plan.add(new PlanItem(4, new Date(2015, 3, 21), null));
        plan.add(new PlanItem(5, new Date(2015, 4, 4), null));

        return plan;
    }

    public String getComment(String student) {
        return "Your next deadline for approval of a module is\nModule 4 at 21st April";
    }

}
