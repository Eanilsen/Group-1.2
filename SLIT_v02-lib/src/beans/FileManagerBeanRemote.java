/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.util.Date;
import javax.ejb.Remote;

/**
 *
 * @author Jons
 */
@Remote
public interface FileManagerBeanRemote {

    public String getName(int id);
    public void createFile();
    
//    public void create(File file);
//    public void edit(File file);
//    public void remove(File file);
//    
//    public File find (object id);
//    public List<File> findAll();
//    public List<File> findRange(int[] range);
//    public int count();

    public byte[] getContent(int id);

    public Date getUploadDate(int id);
}