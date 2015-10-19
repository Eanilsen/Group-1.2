/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package slit.ejb;

import javax.ejb.Stateless;

/**
 *
 * @author even
 */
@Stateless
public class TestBean implements TestBeanRemote
{

    public String echo(String msg) {
        return "TestBean.echo(" + msg + ")";
    }
}
