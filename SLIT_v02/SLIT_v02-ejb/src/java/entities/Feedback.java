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
@Table(name = "feedback", catalog = "slit_v01", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Feedback.findAll", query = "SELECT f FROM Feedback f"),
    @NamedQuery(name = "Feedback.findByIdfeedback", query = "SELECT f FROM Feedback f WHERE f.idfeedback = :idfeedback"),
    @NamedQuery(name = "Feedback.findByCreatedBy", query = "SELECT f FROM Feedback f WHERE f.createdBy = :createdBy"),
    @NamedQuery(name = "Feedback.findByDateCreated", query = "SELECT f FROM Feedback f WHERE f.dateCreated = :dateCreated")})
public class Feedback implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idfeedback")
    private Integer idfeedback;
    @Column(name = "createdBy")
    private Integer createdBy;
    @Column(name = "dateCreated")
    @Temporal(TemporalType.DATE)
    private Date dateCreated;
    @Lob
    @Column(name = "text")
    private byte[] text;
    @JoinColumn(name = "progress", referencedColumnName = "idprogress")
    @ManyToOne
    private Progress progress;

    public Feedback() {
    }

    public Feedback(Integer idfeedback) {
        this.idfeedback = idfeedback;
    }

    public Integer getIdfeedback() {
        return idfeedback;
    }

    public void setIdfeedback(Integer idfeedback) {
        this.idfeedback = idfeedback;
    }

    public Integer getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Integer createdBy) {
        this.createdBy = createdBy;
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

    public Progress getProgress() {
        return progress;
    }

    public void setProgress(Progress progress) {
        this.progress = progress;
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
        if (!(object instanceof Feedback)) {
            return false;
        }
        Feedback other = (Feedback) object;
        if ((this.idfeedback == null && other.idfeedback != null) || (this.idfeedback != null && !this.idfeedback.equals(other.idfeedback))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Feedback[ idfeedback=" + idfeedback + " ]";
    }
    
}
