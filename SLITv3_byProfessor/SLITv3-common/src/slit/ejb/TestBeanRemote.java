/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package slit.ejb;

import javax.ejb.Remote;

/**
 *
 * @author even
 */
@Remote
public interface TestBeanRemote
{

    String echo(String msg);
}
