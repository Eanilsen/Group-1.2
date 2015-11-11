/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Jons
 */
@Entity
@Table(name = "user_role_collection", catalog = "slit_v01", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UserRoleCollection.findAll", query = "SELECT u FROM UserRoleCollection u"),
    @NamedQuery(name = "UserRoleCollection.findByIdroles", query = "SELECT u FROM UserRoleCollection u WHERE u.userRoleCollectionPK.idroles = :idroles"),
    @NamedQuery(name = "UserRoleCollection.findByUser", query = "SELECT u FROM UserRoleCollection u WHERE u.userRoleCollectionPK.user = :user"),
    @NamedQuery(name = "UserRoleCollection.findByRole", query = "SELECT u FROM UserRoleCollection u WHERE u.userRoleCollectionPK.role = :role")})
public class UserRoleCollection implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected UserRoleCollectionPK userRoleCollectionPK;

    public UserRoleCollection() {
    }

    public UserRoleCollection(UserRoleCollectionPK userRoleCollectionPK) {
        this.userRoleCollectionPK = userRoleCollectionPK;
    }

    public UserRoleCollection(int idroles, int user, int role) {
        this.userRoleCollectionPK = new UserRoleCollectionPK(idroles, user, role);
    }

    public UserRoleCollectionPK getUserRoleCollectionPK() {
        return userRoleCollectionPK;
    }

    public void setUserRoleCollectionPK(UserRoleCollectionPK userRoleCollectionPK) {
        this.userRoleCollectionPK = userRoleCollectionPK;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (userRoleCollectionPK != null ? userRoleCollectionPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UserRoleCollection)) {
            return false;
        }
        UserRoleCollection other = (UserRoleCollection) object;
        if ((this.userRoleCollectionPK == null && other.userRoleCollectionPK != null) || (this.userRoleCollectionPK != null && !this.userRoleCollectionPK.equals(other.userRoleCollectionPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.UserRoleCollection[ userRoleCollectionPK=" + userRoleCollectionPK + " ]";
    }
    
}
