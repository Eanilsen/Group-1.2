/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTOs;

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
    
    public FileDTO(int idfile, String name, Date uploadDate){
        this.idfile = idfile;
        this.name = name;
        this.uploadDate = uploadDate;
    }
}