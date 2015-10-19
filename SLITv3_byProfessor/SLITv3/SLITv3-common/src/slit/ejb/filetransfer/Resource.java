/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package slit.ejb.filetransfer;

import java.io.Serializable;

/**
 *
 * @author even
 */
public class Resource implements Serializable
{

    long fileId;
    String fileName;
    String description;

    public Resource(long fileId, String fileName, String description) {
        this.fileId = fileId;
        this.fileName = fileName;
        this.description = description;
    }

    public long getFileId() {
        return fileId;
    }

    public String getFileName() {
        return fileName;
    }

    public String getDescription() {
        return description;
    }

}
