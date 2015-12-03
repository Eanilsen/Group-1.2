/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import DTOs.RolesEnum;
import basicBeans.ModuleFacade;
import basicBeans.ProgressFacade;
import basicBeans.UsersFacade;
import entities.*;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.List;
import java.util.Random;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import util.ModuleText;

/**
 *
 * @author Jons
 */
@Stateless
public class InitializeDatabaseBean implements InitializeDatabaseBeanRemote {

    @EJB
    private ModuleFacade moduleFacade;

    @EJB
    private UsersFacade usersFacade;

    @EJB
    private ProgressFacade progressFacade;

    @PersistenceContext(unitName = "SLIT_v02-ejbPU")
    private EntityManager em;
    private Random rand = new Random();


    
    public void persist(Object object) {
        em.persist(object);
    }

    public void createModule(int id, String name, String description) {
        Module myModule = new Module(id);
        myModule.setDescription(description);
        myModule.setName(name);
        em.persist(myModule);
        em.flush();
    }

    public void createRole(int id, String name, String description) {
        AvailableRoles myRole = new AvailableRoles(id);
        myRole.setDescription(description);
        myRole.setName(name);
        em.persist(myRole);
        em.flush();
    }

    public void createUser(String firstName, String lastName, String email, AvailableRoles role) {
        Users myUser = new Users(); //TODO add function that displays users lastLogin.
        myUser.setEmail(email);
        myUser.setFirstname(firstName);
        myUser.setLastname(lastName);
        em.persist(myUser);
        em.flush();
        myUser.getAvailableRolesCollection().add(role);
        em.persist(myUser);
        em.flush();
    }

    public void createRessource(String name, byte[] blob) {
        Ressource myRessource = new Ressource();
        myRessource.setFile(blob);
        myRessource.setName(name);
        em.persist(myRessource);
        em.flush();
    }

    public void createFiles(String name, Date uploadDate, Progress progress) {
        File file = new File();
        file.setName(name);
        file.setUploadDate(uploadDate);
        file.setProgress(progress);
        em.persist(file);
        em.flush();
    }

    /**
     * Bool true for approved module. False for dispproved. Null for not reviewed
     * @param bool
     * @param module
     * @param user 
     */
    public void createProgress(int bool, Module module, Users user) {
        Progress progress = new Progress();
        if (bool == 1) {    // approved
            progress.setApproved(true);
        }
        if (bool == 0) { // disapproved
            progress.setApproved(false);
        }
//        progress.setDifficultyRating(Integer.MIN_VALUE);
//        progress.setDateApproved(dateApproved);
        progress.setModule(module);
        progress.setUser(user);
        em.persist(progress);
        em.flush();
    }

    /**
     * Add data to our database
     *
     * @param students how many students to add
     * @param teachers how many teachers to add
     * @param progress how many progresses to add
     */
    @Override
    public void createDatabase(int students, int teachers, int files) {
//        createUsers();   //create teachers and students alone   todo implement function to create standard users with roles
        addRoles();
        addModules();
        addRessources();
        em.flush();
        addBasicUsers();
        addStudents(students);
        addTeachers(teachers);
        em.flush();        
        addProgress();
        em.flush();
        addFiles(files);

        System.out.println("We have Students = " + usersFacade.findUserByRole(RolesEnum.Student));
    }

    private void addModules() {
        for (int i = 0; i <= 4; i++) {
                createModule(i,"Module " + (i+1), ModuleText.list[i]);
            em.flush();
            if (i == 4) {
                for (int j = 5; j <= 13; j++) {
                    createModule(j,"Module " + (j+1), "Description of module" + (j+1));
                    em.flush();
                }
            }
        }
        
    }

    public void generateUsers(int amount, AvailableRoles role) {

        String[] firstNames = {"Åge", "Åse", "Jonas", "Jørgen", "Simen", "Joergen", "Lars",
            "Jons", "John", "Robert", "Richard", "William", "Charles", "Thomas",
            "Paul", "Barbara", "Patricia", "Champagne", "Crystal", "Cheryl",
            "Jane", "Shaquila", "Sensation", "Tracy", "Edward", "Brandy", "Sandra",
            "Jason", "Peter", "Gabi", "Helle", "Lena", "Olaf", "Tiffany", "Candy",
            "Lena", "Brianna", "ShaniquaPapriqua", "Niels", "Ben", "Olaf", "Angela",
            "Østein", "Ægir", "Ørjan", "Æspen"};

        String[] lastNames = {"Dover", "Smith", "Jones", "Collins", "Jackson",
            "Dearsley", "Trump", "Carr", "O'Connell", "Dyer", "Furstzwangler",
            "Wilson", "Davis", "Miller", "White", "Black", "Orange", "Thompson",
            "Allen", "Martin", "Hall", "Adams", "Dam", "Hinrichs", "Nilsen", "Larsen",
            "Hansen", "Gramstad", "Haraldseid", "Fuglestad", "Lee", "Vader", "Kenobi"};

        String[] mails = {"hotmail", "gmail", "fakemail"};

        for (int j = 0; j < amount; j++) {
            String first = firstNames[rand.nextInt(firstNames.length)];
            String last = lastNames[rand.nextInt(lastNames.length)];
            String mail = mails[rand.nextInt(mails.length)];
            String mailAddress = first + "." + last + "@" + mail + ".com";

            createUser(first, last, mailAddress, role);
        }
    }

    private void addBasicUsers() {
        System.out.println("Creating basic users.....");
        createUser("Admin", "Adminson", "admin@uia.com", em.find(AvailableRoles.class, RolesEnum.Admin.ordinal()));
        createUser("Teacher", "Teacherson", "teacher@uia.com", em.find(AvailableRoles.class, RolesEnum.Teacher.ordinal()));
        createUser("Student", "Studentson", "student@uia.no", em.find(AvailableRoles.class, RolesEnum.Student.ordinal()));
    }

    @Override
    public void addStudents(int amount) {
        System.out.println("Creating students.....");
        generateUsers(amount, em.find(AvailableRoles.class, RolesEnum.Student.ordinal()));
    }

    @Override
    public void addTeachers(int amount) {
        System.out.println("Creating teachers.....");
        generateUsers(amount, em.find(AvailableRoles.class, RolesEnum.Teacher.ordinal()));
    }

    private void addRoles() {
        System.out.println("Creating roles.....");
        for (RolesEnum e : RolesEnum.values()) {
            createRole(e.ordinal(), e.name(), e.getDescription());
        }
    }

    private void addRessources() {
        System.out.println("Creating ressources.....");
        createRessource("The Story of everything", "www.wikipedia.de".getBytes());
        createRessource("little Ressource text", "This ressource was written by Jonas H. and is probably the best ressource in the world wide web.".getBytes());
        createRessource("Grammas Apple Pie", ("Put a layer of paper towels on a large baking sheet. Quarter, core, peel and slice the apples about 5mm thick and lay evenly on the baking sheet. Put paper towels on top and set aside while you make and chill the pastry.\n"
                + "    For the pastry, beat the butter and sugar in a large bowl until just mixed. Break in a whole egg and a yolk (keep the white for glazing later). Beat together for just under 1 min – it will look a bit like scrambled egg. Now work in the flour with a wooden spoon, a third at a time, until it’s beginning to clump up, then finish gathering it together with your hands. Gently work the dough into a ball, wrap in cling film, and chill for 45 mins. Now mix the 140g/5oz sugar, the cinnamon and flour for the filling in a bowl that is large enough to take the apples later.\n"
                + "    After the pastry has chilled, heat the oven to 190C/fan 170C/gas 5. Lightly beat the egg white with a fork. Cut off a third of the pastry and keep it wrapped while you roll out the rest, and use this to line a pie tin – 20-22cm round and 4cm deep – leaving a slight overhang. Roll the remaining third to a circle about 28cm in diameter. Pat the apples dry with kitchen paper, and tip them into the bowl with the cinnamon-sugar mix. Give a quick mix with your hands and immediately pile high into the pastry-lined tin.\n"
                + "    Brush a little water around the pastry rim and lay the pastry lid over the apples pressing the edges together to seal. Trim the edge with a sharp knife and make 5 little slashes on top of the lid for the steam to escape. (Can be frozen at this stage.) Brush it all with the egg white and sprinkle with caster sugar. Bake for 40-45 mins, until golden, then remove and let it sit for 5-10 mins. Sprinkle with more sugar and serve while still warm from the oven with softly whipped cream.").getBytes());
    }

    /**
     * @author Lybeck
     * @author Jons
     */
    public void addFiles(int amount) {
        System.out.println("Creating files.....");
        List<Progress> progressList = progressFacade.findAll();

        String[] fileNames = {"modulEn.txt", "Jorgensmodule.crazydoc", "newFile.doc"
            + "resource.txt", "module.pdf", "module3.pdf", "tst.dmg"
            + "new-file.gdoc", "module.doc", "arraylists.pdf"
            + "java-interfaces.doc", "testing.txt", "readme.txt"};

        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss"); //29/11/2015 23:27:59
        Date currentDate = new Date(System.currentTimeMillis());
//        System.out.println(dateFormat.format(currentDate)); 
        int progressCount = progressList.size();
        for (int i = 0; i < amount; i++) {
            String randomFile = fileNames[rand.nextInt(fileNames.length)];
            createFiles(randomFile, currentDate, 
                    progressFacade.find(rand.nextInt(progressCount)));

        }
    }

    /**
     * @author Lybeck
     * @author Jons
     */
    private void addProgress() {
        System.out.println("Creating progress.....");

            Collection<Users> userCollection = usersFacade.findAll();
            System.out.println(userCollection.size());
            int moduleCount = moduleFacade.count();
            for (Users u : userCollection) {
                
            int passedModules = rand.nextInt(moduleCount);

            for (int j = 1; j <= passedModules+1; j++) {
                Module module = moduleFacade.find(j);
                
                int notPassedModules = rand.nextInt(2);
                for (int k = 0; k < notPassedModules ; k++) {
                    createProgress(0, module, u); 
                }                
                module = moduleFacade.find(j);
                createProgress(1, module, u);
            }
            if (0 < passedModules && passedModules < moduleFacade.count()) {
                createProgress(2, moduleFacade.find(passedModules), u);
            }
            
        }

    }

    @Override
    public boolean databaseEmpty() {
        return usersFacade.count()==0;
    }
}
