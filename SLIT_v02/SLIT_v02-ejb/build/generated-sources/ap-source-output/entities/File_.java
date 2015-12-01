package entities;

import entities.Progress;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-12-01T04:32:56")
@StaticMetamodel(File.class)
public class File_ { 

    public static volatile SingularAttribute<File, Date> uploadDate;
    public static volatile SingularAttribute<File, String> name;
    public static volatile SingularAttribute<File, Progress> progress;
    public static volatile SingularAttribute<File, Integer> idfile;

}