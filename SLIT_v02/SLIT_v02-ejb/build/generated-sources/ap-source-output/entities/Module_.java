package entities;

import entities.ModuleRessourceCollection;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-11-11T12:34:12")
@StaticMetamodel(Module.class)
public class Module_ { 

    public static volatile SingularAttribute<Module, Integer> idmodule;
    public static volatile SingularAttribute<Module, String> name;
    public static volatile SingularAttribute<Module, String> description;
    public static volatile CollectionAttribute<Module, ModuleRessourceCollection> moduleRessourceCollectionCollection;

}