package entities;

import entities.Module;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-11-28T17:52:45")
@StaticMetamodel(Ressource.class)
public class Ressource_ { 

    public static volatile SingularAttribute<Ressource, byte[]> file;
    public static volatile SingularAttribute<Ressource, String> name;
    public static volatile SingularAttribute<Ressource, Integer> idressource;
    public static volatile CollectionAttribute<Ressource, Module> moduleCollection;

}