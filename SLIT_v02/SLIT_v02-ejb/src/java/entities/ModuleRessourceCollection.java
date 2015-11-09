/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Jons
 */
@Entity
@Table(name = "module_ressource_collection", catalog = "slit_v01", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ModuleRessourceCollection.findAll", query = "SELECT m FROM ModuleRessourceCollection m"),
    @NamedQuery(name = "ModuleRessourceCollection.findByIdressources", query = "SELECT m FROM ModuleRessourceCollection m WHERE m.idressources = :idressources")})
public class ModuleRessourceCollection implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idressources")
    private Integer idressources;
    @JoinColumn(name = "module", referencedColumnName = "idmodule")
    @ManyToOne
    private Module module;
    @JoinColumn(name = "ressource", referencedColumnName = "idressource")
    @ManyToOne
    private Ressource ressource;

    public ModuleRessourceCollection() {
    }

    public ModuleRessourceCollection(Integer idressources) {
        this.idressources = idressources;
    }

    public Integer getIdressources() {
        return idressources;
    }

    public void setIdressources(Integer idressources) {
        this.idressources = idressources;
    }

    public Module getModule() {
        return module;
    }

    public void setModule(Module module) {
        this.module = module;
    }

    public Ressource getRessource() {
        return ressource;
    }

    public void setRessource(Ressource ressource) {
        this.ressource = ressource;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idressources != null ? idressources.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ModuleRessourceCollection)) {
            return false;
        }
        ModuleRessourceCollection other = (ModuleRessourceCollection) object;
        if ((this.idressources == null && other.idressources != null) || (this.idressources != null && !this.idressources.equals(other.idressources))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.ModuleRessourceCollection[ idressources=" + idressources + " ]";
    }
    
}
