package entities;

import entities.AvailableRoles;
import entities.Comment;
import entities.Progress;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-11-30T22:46:52")
@StaticMetamodel(Users.class)
public class Users_ { 

    public static volatile CollectionAttribute<Users, AvailableRoles> availableRolesCollection;
    public static volatile SingularAttribute<Users, Date> lastLogin;
    public static volatile SingularAttribute<Users, Integer> iduser;
    public static volatile SingularAttribute<Users, String> firstname;
    public static volatile CollectionAttribute<Users, Comment> commentCollection;
    public static volatile SingularAttribute<Users, String> email;
    public static volatile CollectionAttribute<Users, Progress> progressCollection;
    public static volatile SingularAttribute<Users, String> lastname;

}