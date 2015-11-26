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
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "progress")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Progress.findAll", query = "SELECT p FROM Progress p"),
    @NamedQuery(name = "Progress.findByIdprogress", query = "SELECT p FROM Progress p WHERE p.idprogress = :idprogress"),
    @NamedQuery(name = "Progress.findByDateApproved", query = "SELECT p FROM Progress p WHERE p.dateApproved = :dateApproved"),
    @NamedQuery(name = "Progress.findByDifficultyRating", query = "SELECT p FROM Progress p WHERE p.difficultyRating = :difficultyRating")})
public class Progress implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idprogress")
    private Integer idprogress;
    @Column(name = "dateApproved")
    @Temporal(TemporalType.DATE)
    private Date dateApproved;
    @Column(name = "difficultyRating")
    private Integer difficultyRating;
    @OneToMany(mappedBy = "progress")
    private Collection<File> fileCollection;
    @JoinColumn(name = "module", referencedColumnName = "idmodule")
    @ManyToOne
    private Module module;
    @JoinColumn(name = "user", referencedColumnName = "iduser")
    @ManyToOne
    private Users user;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "progressIdprogress")
    private Collection<Comment> commentCollection;
    @Column(name = "approved")
    private Boolean approved;

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

    public Date getDateApproved() {
        return dateApproved;
    }

    public void setDateApproved(Date dateApproved) {
        this.dateApproved = dateApproved;
    }

    public Integer getDifficultyRating() {
        return difficultyRating;
    }

    public void setDifficultyRating(Integer difficultyRating) {
        this.difficultyRating = difficultyRating;
    }

    @XmlTransient
    public Collection<File> getFileCollection() {
        return fileCollection;
    }

    public void setFileCollection(Collection<File> fileCollection) {
        this.fileCollection = fileCollection;
    }

    public Module getModule() {
        return module;
    }

    public void setModule(Module module) {
        this.module = module;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    public Boolean getApproved() {
        if(approved == null)
            return false;
        return approved;
    }

    public void setApproved(Boolean approved) {
        this.approved = approved;
    }
    
    @XmlTransient
    public Collection<Comment> getCommentCollection() {
        return commentCollection;
    }

    public void setCommentCollection(Collection<Comment> commentCollection) {
        this.commentCollection = commentCollection;
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
