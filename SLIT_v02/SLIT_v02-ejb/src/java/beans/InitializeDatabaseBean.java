/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import entities.*;
import enums.RolesEnum;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Jons
 */
@Stateless
public class InitializeDatabaseBean implements InitializeDatabaseBeanRemote {

    @PersistenceContext(unitName = "SLIT_v02-ejbPU")
    private EntityManager em;

    public void createModule(String name, String description) {
        Module myModule = new Module();
        myModule.setDescription(description);
        myModule.setName(name);
        em.persist(myModule);
    }

    public void createRole(int id, String name, String description) {
        AvailableRoles myRole = new AvailableRoles(id);
        myRole.setDescription(description);
        myRole.setName(name);
        em.persist(myRole);
    }

    public void createUser(String firstName, String lastName, String email) {
        Users myUser = new Users();
        myUser.setEmail(email);
        myUser.setFirstname(firstName);
        myUser.setLastname(lastName);
        em.persist(myUser);
    }

    public void createRessource(String name, byte[] blob) {
        Ressource myRessource = new Ressource();
        myRessource.setFile(blob);
        myRessource.setName(name);
        em.persist(myRessource);
    }

    public void persist(Object object) {
        em.persist(object);
    }

    @Override
    public void createDatabase() {
        createRoles();
        createUsers();
        createModules();
        createRessources();
        em.flush();
        addRoleToUser();

    }

    private void addRoleToUser() {
        Users testUser = em.find(Users.class, 7);
        AvailableRoles role = em.find(AvailableRoles.class, RolesEnum.Teacher.ordinal());
        AvailableRoles role2 = em.find(AvailableRoles.class, RolesEnum.Admin.ordinal());
        
        testUser.getAvailableRolesCollection().add(role2);
        testUser.getAvailableRolesCollection().add(role);
        
        em.persist(testUser);
    }

    private void createModules() {
        for (int i = 1; i <= 14; i++) {
            createModule("Module " + i, "Description of Module " + i + " here.");
        }
    }

    private void createUsers() {
        createUser("Jonas", "Hinrichs", "jh@mail.de");
        createUser("Peter", "G", "PG@mail.de");
        createUser("Simen", "F", "SF@mail.de");
        createUser("Jørgen", "W", "JW@mail.de");
        createUser("Gabi", "H", "GH@mail.de");
        createUser("Helle", "D", "HD@mail.de");
        createUser("Helle", "S", "HS@mail.de");
        createUser("Lena", "D", "LD@mail.de");
        createUser("Olaf", "V", "OV@mail.de");
        createUser("Niels", "S", "NS@mail.de");
        createUser("Even", "A", "EA@mail.de");
    }

    private void createRoles() {
        for (RolesEnum e : RolesEnum.values()){
            createRole(e.ordinal(), e.name(), e.getDescription() );
        }
    }

    private void createRessources() {
        createRessource("The Story of everything", "www.wikipedia.de".getBytes());
        createRessource("little Ressource text", "This ressource was written by Jonas H. and is probably the best ressource in the world wide web.".getBytes());
        createRessource("Grammas Apple Pie", ("Put a layer of paper towels on a large baking sheet. Quarter, core, peel and slice the apples about 5mm thick and lay evenly on the baking sheet. Put paper towels on top and set aside while you make and chill the pastry.\n"
                + "    For the pastry, beat the butter and sugar in a large bowl until just mixed. Break in a whole egg and a yolk (keep the white for glazing later). Beat together for just under 1 min – it will look a bit like scrambled egg. Now work in the flour with a wooden spoon, a third at a time, until it’s beginning to clump up, then finish gathering it together with your hands. Gently work the dough into a ball, wrap in cling film, and chill for 45 mins. Now mix the 140g/5oz sugar, the cinnamon and flour for the filling in a bowl that is large enough to take the apples later.\n"
                + "    After the pastry has chilled, heat the oven to 190C/fan 170C/gas 5. Lightly beat the egg white with a fork. Cut off a third of the pastry and keep it wrapped while you roll out the rest, and use this to line a pie tin – 20-22cm round and 4cm deep – leaving a slight overhang. Roll the remaining third to a circle about 28cm in diameter. Pat the apples dry with kitchen paper, and tip them into the bowl with the cinnamon-sugar mix. Give a quick mix with your hands and immediately pile high into the pastry-lined tin.\n"
                + "    Brush a little water around the pastry rim and lay the pastry lid over the apples pressing the edges together to seal. Trim the edge with a sharp knife and make 5 little slashes on top of the lid for the steam to escape. (Can be frozen at this stage.) Brush it all with the egg white and sprinkle with caster sugar. Bake for 40-45 mins, until golden, then remove and let it sit for 5-10 mins. Sprinkle with more sugar and serve while still warm from the oven with softly whipped cream.").getBytes());

    }

}
