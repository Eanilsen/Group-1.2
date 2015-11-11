package entities;

import entities.Progress;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-11-11T12:34:12")
@StaticMetamodel(Feedback.class)
public class Feedback_ { 

    public static volatile SingularAttribute<Feedback, Integer> idfeedback;
    public static volatile SingularAttribute<Feedback, Date> dateCreated;
    public static volatile SingularAttribute<Feedback, Integer> createdBy;
    public static volatile SingularAttribute<Feedback, Progress> progress;
    public static volatile SingularAttribute<Feedback, byte[]> text;

}