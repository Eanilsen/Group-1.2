/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package slit.ejb.module;

import java.util.List;
import javax.ejb.Remote;
import slit.ejb.filetransfer.Resource;

/**
 *
 * @author even
 */
@Remote
public interface ModuleBeanRemote
{

    String getDescription(long moduleId);

    List<Resource> getResourceInfo(int moduleId);
}
