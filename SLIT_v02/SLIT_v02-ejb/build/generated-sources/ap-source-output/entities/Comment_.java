package entities;

import entities.Progress;
import entities.Users;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-12-03T19:04:25")
@StaticMetamodel(Comment.class)
public class Comment_ { 

    public static volatile SingularAttribute<Comment, Integer> idfeedback;
    public static volatile SingularAttribute<Comment, Date> dateCreated;
    public static volatile SingularAttribute<Comment, Users> createdBy;
    public static volatile SingularAttribute<Comment, Progress> progressIdprogress;
    public static volatile SingularAttribute<Comment, byte[]> text;

}