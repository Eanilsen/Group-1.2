package entities;

import entities.Feedback;
import entities.File;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-11-11T12:34:12")
@StaticMetamodel(Progress.class)
public class Progress_ { 

    public static volatile CollectionAttribute<Progress, File> fileCollection;
    public static volatile SingularAttribute<Progress, Date> dateApproved;
    public static volatile SingularAttribute<Progress, Integer> idprogress;
    public static volatile SingularAttribute<Progress, Integer> module;
    public static volatile CollectionAttribute<Progress, Feedback> feedbackCollection;
    public static volatile SingularAttribute<Progress, Integer> user;

}