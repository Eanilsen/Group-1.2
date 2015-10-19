/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package slit.ejb.plan;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author even
 */
public class PlanItem implements Serializable
{

    public static final long serialVersionUID = 42L;

    public int module;
    public Date plannedDate;
    public Date approvedDate;

    public PlanItem(int module, Date plannedDate, Date approvedDate) {
        this.module = module;
        this.plannedDate = plannedDate;
        this.approvedDate = approvedDate;
    }

}
