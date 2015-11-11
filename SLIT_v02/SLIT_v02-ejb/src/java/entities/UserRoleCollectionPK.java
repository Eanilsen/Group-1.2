/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Jons
 */
@Embeddable
public class UserRoleCollectionPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "idroles")
    private int idroles;
    @Basic(optional = false)
    @NotNull
    @Column(name = "user")
    private int user;
    @Basic(optional = false)
    @NotNull
    @Column(name = "role")
    private int role;

    public UserRoleCollectionPK() {
    }

    public UserRoleCollectionPK(int idroles, int user, int role) {
        this.idroles = idroles;
        this.user = user;
        this.role = role;
    }

    public int getIdroles() {
        return idroles;
    }

    public void setIdroles(int idroles) {
        this.idroles = idroles;
    }

    public int getUser() {
        return user;
    }

    public void setUser(int user) {
        this.user = user;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idroles;
        hash += (int) user;
        hash += (int) role;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UserRoleCollectionPK)) {
            return false;
        }
        UserRoleCollectionPK other = (UserRoleCollectionPK) object;
        if (this.idroles != other.idroles) {
            return false;
        }
        if (this.user != other.user) {
            return false;
        }
        if (this.role != other.role) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.UserRoleCollectionPK[ idroles=" + idroles + ", user=" + user + ", role=" + role + " ]";
    }
    
}
