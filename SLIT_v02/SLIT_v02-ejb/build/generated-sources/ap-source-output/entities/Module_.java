package entities;

import entities.Progress;
import entities.Ressource;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

<<<<<<< HEAD
@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-12-01T02:10:10")
=======
@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-11-30T22:46:52")
>>>>>>> origin/even
@StaticMetamodel(Module.class)
public class Module_ { 

    public static volatile SingularAttribute<Module, Integer> idmodule;
    public static volatile SingularAttribute<Module, String> name;
    public static volatile CollectionAttribute<Module, Ressource> ressourceCollection;
    public static volatile SingularAttribute<Module, String> description;
    public static volatile CollectionAttribute<Module, Progress> progressCollection;

}
