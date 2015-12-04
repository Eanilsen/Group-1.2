/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import basicBeans.FileFacade;
import basicBeans.ModuleFacade;
import basicBeans.ProgressFacade;
import basicBeans.UsersFacade;
import entities.File;
import entities.Module;
import entities.Progress;
import static entities.Progress_.module;
import java.util.Date;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Jons
 */
@Stateless
public class FileManagerBean implements FileManagerBeanRemote {

    @EJB
    private FileFacade ff;
    @EJB
    private ProgressFacade pf;
    @EJB
    private ModuleFacade mf = new ModuleFacade();
    @PersistenceContext(unitName = "SLIT_v02-ejbPU")
    private EntityManager em;
    @EJB
    private UsersFacade uf;
    
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
    public void addFilesDatabase(String name, byte[] content, Date uploadDate, 
                            int moduleID, int userID){
        
        //TODO Something is wrong here, looks like line 66
        System.out.println("--Userid "+ userID);
//        System.out.println("Creating Progress with user "+ mf.find(userID).getName());
        Progress progress = new Progress();
        Module module = new Module();
       
        progress.setModule(mf.find(moduleID));
        em.persist(module);
        progress.setUser(uf.find(userID));
        em.persist(progress);
        
        System.out.println("Creating File.....");
        File file = new File();
        file.setName(name);
        file.setContent(content);
        file.setUploadDate(uploadDate);
        //might need to em.flush() here
        file.setProgress(progress);
        em.persist(file);
    }   
    
    public void getContent(){
        File file = new File();
        file.getContent();
    }
    
//    public List<FileDTO> getAllFiles

    public void persist(Object object) {
        em.persist(object);
    }
}