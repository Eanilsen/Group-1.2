/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package slit.jorgen;

import beans.ProgressManagerBeanRemote;
import javax.ejb.EJB;

/**
 *
 * @author Jorgen
 */
public class EjbTest {
    
    @EJB
    private static ProgressManagerBeanRemote usb;
    
    public static void main(String[] args){
        System.out.println(usb.theProgress());
    }      
    
    
}
