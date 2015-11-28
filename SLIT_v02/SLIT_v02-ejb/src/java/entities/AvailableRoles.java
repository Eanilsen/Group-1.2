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
@Table(name = "available_roles")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AvailableRoles.findAll", query = "SELECT a FROM AvailableRoles a"),
    @NamedQuery(name = "AvailableRoles.findByIdrole", query = "SELECT a FROM AvailableRoles a WHERE a.idrole = :idrole"),
    @NamedQuery(name = "AvailableRoles.findByName", query = "SELECT a FROM AvailableRoles a WHERE a.name = :name"),
    @NamedQuery(name = "AvailableRoles.findByDescription", query = "SELECT a FROM AvailableRoles a WHERE a.description = :description")})
public class AvailableRoles implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idrole")
    private Integer idrole;
    @Size(max = 45)
    @Column(name = "name")
    private String name;
    @Size(max = 45)
    @Column(name = "description")
    private String description;
    @JoinTable(name = "available_roles_has_users", joinColumns = {
        @JoinColumn(name = "available_roles_idrole", referencedColumnName = "idrole")}, inverseJoinColumns = {
        @JoinColumn(name = "users_iduser", referencedColumnName = "iduser")})
    @ManyToMany
    private Collection<Users> usersCollection;

    public AvailableRoles() {
    }

    public AvailableRoles(Integer idrole) {
        this.idrole = idrole;
    }

    public Integer getIdrole() {
        return idrole;
    }

    public void setIdrole(Integer idrole) {
        this.idrole = idrole;
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
    public Collection<Users> getUsersCollection() {
        return usersCollection;
    }

    public void setUsersCollection(Collection<Users> usersCollection) {
        this.usersCollection = usersCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idrole != null ? idrole.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AvailableRoles)) {
            return false;
        }
        AvailableRoles other = (AvailableRoles) object;
        if ((this.idrole == null && other.idrole != null) || (this.idrole != null && !this.idrole.equals(other.idrole))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.AvailableRoles[ idrole=" + idrole + " ]";
    }

//    @XmlTransient
//    public Collection<Users> getUsersCollection() {
//        return usersCollection;
//    }
//
//    public void setUsersCollection(Collection<Users> usersCollection) {
//        this.usersCollection = usersCollection;
//    }
    
}
