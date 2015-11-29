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
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Jons
 */
@Entity
@Table(name = "comment")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Comment.findAll", query = "SELECT c FROM Comment c"),
    @NamedQuery(name = "Comment.findByIdfeedback", query = "SELECT c FROM Comment c WHERE c.idfeedback = :idfeedback"),
    @NamedQuery(name = "Comment.findByDateCreated", query = "SELECT c FROM Comment c WHERE c.dateCreated = :dateCreated")})
public class Comment implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idfeedback")
    private Integer idfeedback;
    @Column(name = "dateCreated")
    @Temporal(TemporalType.DATE)
    private Date dateCreated;
    @Lob
    @Column(name = "text")
    private byte[] text;
    @JoinColumn(name = "createdBy", referencedColumnName = "iduser")
    @ManyToOne
    private Users createdBy;
    @JoinColumn(name = "progress_idprogress", referencedColumnName = "idprogress")
    @ManyToOne(optional = false)
    private Progress progressIdprogress;

    public Comment() {
    }

    public Comment(Integer idfeedback) {
        this.idfeedback = idfeedback;
    }

    public Integer getIdfeedback() {
        return idfeedback;
    }

    public void setIdfeedback(Integer idfeedback) {
        this.idfeedback = idfeedback;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public byte[] getText() {
        return text;
    }

    public void setText(byte[] text) {
        this.text = text;
    }

    public Users getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Users createdBy) {
        this.createdBy = createdBy;
    }

    public Progress getProgressIdprogress() {
        return progressIdprogress;
    }

    public void setProgressIdprogress(Progress progressIdprogress) {
        this.progressIdprogress = progressIdprogress;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idfeedback != null ? idfeedback.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Comment)) {
            return false;
        }
        Comment other = (Comment) object;
        if ((this.idfeedback == null && other.idfeedback != null) || (this.idfeedback != null && !this.idfeedback.equals(other.idfeedback))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Comment[ idfeedback=" + idfeedback + " ]";
    }
    
}
