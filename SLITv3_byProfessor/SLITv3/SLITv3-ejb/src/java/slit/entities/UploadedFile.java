/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package slit.entities;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import slit.ejb.filetransfer.FileTransfer;



/**
 *
 * @author even
 */
@Entity
public class UploadedFile implements Serializable
{

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String filename;
    private String purpose;
    @Lob
    private byte[] content;

    public UploadedFile() {
        this(null, null, null);
    }

    public UploadedFile(String filename, String purpose, byte[] content) {
        this.filename = filename;
        this.purpose = purpose;
        this.content = content;
    }

    public UploadedFile(FileTransfer ft) {
        this(ft.getFilename(), ft.getPurpose(), ft.getFileContent());
        id = ft.getId();
    }

    public Long getId() {
        return id;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getFilename() {
        return filename;
    }

    public String getPurpose() {
        return purpose;
    }

    public byte[] getContent() {
        return content;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UploadedFile)) {
            return false;
        }
        UploadedFile other = (UploadedFile) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id)))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "slit.entities.UploadedFile[ id=" + id + " ]";
    }

}
