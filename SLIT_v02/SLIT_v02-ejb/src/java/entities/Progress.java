/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Jons
 */
@Entity
@Table(name = "progress", catalog = "slit_v01", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Progress.findAll", query = "SELECT p FROM Progress p"),
    @NamedQuery(name = "Progress.findByIdprogress", query = "SELECT p FROM Progress p WHERE p.idprogress = :idprogress"),
    @NamedQuery(name = "Progress.findByUser", query = "SELECT p FROM Progress p WHERE p.user = :user"),
    @NamedQuery(name = "Progress.findByModule", query = "SELECT p FROM Progress p WHERE p.module = :module"),
    @NamedQuery(name = "Progress.findByDateApproved", query = "SELECT p FROM Progress p WHERE p.dateApproved = :dateApproved")})
public class Progress implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idprogress")
    private Integer idprogress;
    @Column(name = "user")
    private Integer user;
    @Column(name = "module")
    private Integer module;
    @Column(name = "dateApproved")
    @Temporal(TemporalType.DATE)
    private Date dateApproved;
    @OneToMany(mappedBy = "progress")
    private Collection<Feedback> feedbackCollection;
    @OneToMany(mappedBy = "progress")
    private Collection<File> fileCollection;

    public Progress() {
    }

    public Progress(Integer idprogress) {
        this.idprogress = idprogress;
    }

    public Integer getIdprogress() {
        return idprogress;
    }

    public void setIdprogress(Integer idprogress) {
        this.idprogress = idprogress;
    }

    public Integer getUser() {
        return user;
    }

    public void setUser(Integer user) {
        this.user = user;
    }

    public Integer getModule() {
        return module;
    }

    public void setModule(Integer module) {
        this.module = module;
    }

    public Date getDateApproved() {
        return dateApproved;
    }

    public void setDateApproved(Date dateApproved) {
        this.dateApproved = dateApproved;
    }

    @XmlTransient
    public Collection<Feedback> getFeedbackCollection() {
        return feedbackCollection;
    }

    public void setFeedbackCollection(Collection<Feedback> feedbackCollection) {
        this.feedbackCollection = feedbackCollection;
    }

    @XmlTransient
    public Collection<File> getFileCollection() {
        return fileCollection;
    }

    public void setFileCollection(Collection<File> fileCollection) {
        this.fileCollection = fileCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idprogress != null ? idprogress.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Progress)) {
            return false;
        }
        Progress other = (Progress) object;
        if ((this.idprogress == null && other.idprogress != null) || (this.idprogress != null && !this.idprogress.equals(other.idprogress))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Progress[ idprogress=" + idprogress + " ]";
    }
    
}
