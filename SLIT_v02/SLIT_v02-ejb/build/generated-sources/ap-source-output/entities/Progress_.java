package entities;

import entities.Comment;
import entities.File;
import entities.Module;
import entities.Users;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-11-12T21:39:05")
@StaticMetamodel(Progress.class)
public class Progress_ { 

    public static volatile CollectionAttribute<Progress, File> fileCollection;
    public static volatile SingularAttribute<Progress, Date> dateApproved;
    public static volatile SingularAttribute<Progress, Integer> difficultyRating;
    public static volatile SingularAttribute<Progress, Integer> idprogress;
    public static volatile SingularAttribute<Progress, Module> module;
    public static volatile CollectionAttribute<Progress, Comment> commentCollection;
    public static volatile SingularAttribute<Progress, Users> user;

}