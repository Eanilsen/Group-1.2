/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTOs;

import java.io.File;
import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author Jorgen
 */
public class FileDTO implements Serializable {

    private int idfile;
    private String name;
    private Date uploadDate;
    private File file;
    
    public FileDTO(File file, int idfile, String name, 
                        byte[] content,  Date uploadDate){
        this.file = file;
        this.idfile = idfile;
        this.name = name;
        this.uploadDate = uploadDate;
    }
}