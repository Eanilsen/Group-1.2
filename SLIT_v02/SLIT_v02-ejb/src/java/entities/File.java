/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Jons
 */
@Entity
@Table(name = "file", catalog = "slit_v01", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "File.findAll", query = "SELECT f FROM File f"),
    @NamedQuery(name = "File.findByIdfile", query = "SELECT f FROM File f WHERE f.idfile = :idfile"),
    @NamedQuery(name = "File.findByName", query = "SELECT f FROM File f WHERE f.name = :name"),
    @NamedQuery(name = "File.findByUploadDate", query = "SELECT f FROM File f WHERE f.uploadDate = :uploadDate")})
public class File implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idfile")
    private Integer idfile;
    @Size(max = 45)
    @Column(name = "name")
    private String name;
    @Column(name = "uploadDate")
    @Temporal(TemporalType.DATE)
    private Date uploadDate;
    @JoinColumn(name = "progress", referencedColumnName = "idprogress")
    @ManyToOne
    private Progress progress;

    public File() {
    }

    public File(Integer idfile) {
        this.idfile = idfile;
    }

    public Integer getIdfile() {
        return idfile;
    }

    public void setIdfile(Integer idfile) {
        this.idfile = idfile;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getUploadDate() {
        return uploadDate;
    }

    public void setUploadDate(Date uploadDate) {
        this.uploadDate = uploadDate;
    }

    public Progress getProgress() {
        return progress;
    }

    public void setProgress(Progress progress) {
        this.progress = progress;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idfile != null ? idfile.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof File)) {
            return false;
        }
        File other = (File) object;
        if ((this.idfile == null && other.idfile != null) || (this.idfile != null && !this.idfile.equals(other.idfile))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.File[ idfile=" + idfile + " ]";
    }
    
}
