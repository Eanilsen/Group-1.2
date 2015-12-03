/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import basicBeans.FileFacade;
import entities.File;
import java.util.Date;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author Jons
 */
@Stateless
public class FileManagerBean implements FileManagerBeanRemote {

    @EJB
    private FileFacade ff;
    
    /**
     * Finds the name of the file
     * @param id
     * @return 
     */
    @Override
    public String getName(int id){
        File file = ff.find(id);
        return file.getName();
    }
    @Override    
    public byte[] getContent(int id){
        File file = ff.find(id);
        return file.getContent();
    }
    @Override   
    public Date getUploadDate(int id){
        File file = ff.find(id);
        return file.getUploadDate();
    }
    @Override
    public void createFile(java.io.File file){
        File f = new File();
//        f.setContent(file);
//        ff.create(file);
    }
    
    public void getContent(){
        File file = new File();
        file.getContent();
    }
    
//    public List<FileDTO> getAllFiles
}