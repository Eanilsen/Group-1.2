/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package enums;

/**
 *
 * @author Jons
 */
public enum RolesEnum {

    Admin,
    Teacher,
    HelpTeacher,
    Student;

    public String getDescription() {
        switch (this) {
            case Admin:
                return "GOD";
            case Teacher:
                return "Plain old teacher dude";
            case HelpTeacher:
                return "Santas little helper";
            case Student:
                return "last victim in the food chain";

        }
        return null;
    }

}
