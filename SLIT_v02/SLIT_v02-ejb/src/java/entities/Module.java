/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Jons
 */
@Entity
@Table(name = "module")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Module.findAll", query = "SELECT m FROM Module m"),
    @NamedQuery(name = "Module.findByIdmodule", query = "SELECT m FROM Module m WHERE m.idmodule = :idmodule"),
    @NamedQuery(name = "Module.findByName", query = "SELECT m FROM Module m WHERE m.name = :name")})
public class Module implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idmodule")
    private Integer idmodule;
    @Size(max = 45)
    @Column(name = "name")
    private String name;
    @Lob
    @Size(max = 65535)
    @Column(name = "description")
    private String description;
    @JoinTable(name = "module_has_ressource", joinColumns = {
        @JoinColumn(name = "module_idmodule", referencedColumnName = "idmodule")}, inverseJoinColumns = {
        @JoinColumn(name = "ressource_idressource", referencedColumnName = "idressource")})
    @ManyToMany
    private Collection<Ressource> ressourceCollection;
    @OneToMany(mappedBy = "module")
    private Collection<Progress> progressCollection;

    public Module() {
    }

    public Module(Integer idmodule) {
        this.idmodule = idmodule;
    }

    public Integer getIdmodule() {
        return idmodule;
    }

    public void setIdmodule(Integer idmodule) {
        this.idmodule = idmodule;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @XmlTransient
    public Collection<Ressource> getRessourceCollection() {
        return ressourceCollection;
    }

    public void setRessourceCollection(Collection<Ressource> ressourceCollection) {
        this.ressourceCollection = ressourceCollection;
    }

    @XmlTransient
    public Collection<Progress> getProgressCollection() {
        return progressCollection;
    }

    public void setProgressCollection(Collection<Progress> progressCollection) {
        this.progressCollection = progressCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idmodule != null ? idmodule.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Module)) {
            return false;
        }
        Module other = (Module) object;
        if ((this.idmodule == null && other.idmodule != null) || (this.idmodule != null && !this.idmodule.equals(other.idmodule))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Module[ idmodule=" + idmodule + " ]";
    }
    
}
