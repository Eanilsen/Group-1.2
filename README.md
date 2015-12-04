##Group 1.2.0 Project Repository

####Group members
- Jørgen H. Gramstad
- Jørgen L. Hansen
- Jonas Hinrichs
- Jonas Dam
- Simen Fuglestad
- Even A. Nilsen

####Initializing database
Group 1.2 is using an ejb class to initialize the database and fill it with test data. This is run through the main method and will not run if the database if already filled.

####For a stable run
To stably run SLIT, clean and build from > SLIT-lib > SLIT-ejb > SLIT-client > SLIT. Then you can either deploy SLIT or deploy SLIT-lib and then SLIT-client. 

For the database to be safely initialized, create an empty schema in MySQL Workbench called 'slit', then just run the main in netbeans once and it should all work. --We did this so that all group members would have exactly the same database.

We've been able to run the project multiple times but it might still be unstable.
