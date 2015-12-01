package entities;

import entities.Users;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-12-01T05:38:29")
@StaticMetamodel(AvailableRoles.class)
public class AvailableRoles_ { 

    public static volatile SingularAttribute<AvailableRoles, Integer> idrole;
    public static volatile SingularAttribute<AvailableRoles, String> name;
    public static volatile SingularAttribute<AvailableRoles, String> description;
    public static volatile CollectionAttribute<AvailableRoles, Users> usersCollection;

}