/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.io.File;
import java.util.Date;
import javax.ejb.Remote;

/**
 *
 * @author Jons
 */
@Remote
public interface FileManagerBeanRemote {

    public String getName(int id);
    
    public void addFilesDatabase(String name, byte[] content, Date uploadDate, 
                            int moduleID, int userID);

    
    public byte[] getContent(int id);

    public Date getUploadDate(int id);
}