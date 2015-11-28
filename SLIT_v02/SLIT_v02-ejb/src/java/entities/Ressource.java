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
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Jons
 */
@Entity
@Table(name = "ressource")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ressource.findAll", query = "SELECT r FROM Ressource r"),
    @NamedQuery(name = "Ressource.findByIdressource", query = "SELECT r FROM Ressource r WHERE r.idressource = :idressource"),
    @NamedQuery(name = "Ressource.findByName", query = "SELECT r FROM Ressource r WHERE r.name = :name")})
public class Ressource implements Serializable {
    @Lob
    @Column(name = "file")
    private byte[] file;
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idressource")
    private Integer idressource;
    @Size(max = 45)
    @Column(name = "name")
    private String name;
    @ManyToMany(mappedBy = "ressourceCollection")
    private Collection<Module> moduleCollection;

    public Ressource() {
    }

    public Ressource(Integer idressource) {
        this.idressource = idressource;
    }

    public Integer getIdressource() {
        return idressource;
    }

    public void setIdressource(Integer idressource) {
        this.idressource = idressource;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    @XmlTransient
    public Collection<Module> getModuleCollection() {
        return moduleCollection;
    }

    public void setModuleCollection(Collection<Module> moduleCollection) {
        this.moduleCollection = moduleCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idressource != null ? idressource.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ressource)) {
            return false;
        }
        Ressource other = (Ressource) object;
        if ((this.idressource == null && other.idressource != null) || (this.idressource != null && !this.idressource.equals(other.idressource))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Ressource[ idressource=" + idressource + " ]";
    }

    public byte[] getFile() {
        return file;
    }

    public void setFile(byte[] file) {
        this.file = file;
    }
    
}
