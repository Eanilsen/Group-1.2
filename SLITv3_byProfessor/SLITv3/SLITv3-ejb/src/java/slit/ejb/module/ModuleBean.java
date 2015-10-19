/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package slit.ejb.module;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import slit.ejb.filetransfer.Resource;
import slit.entities.UploadedFile;

/**
 *
 * @author even
 */
@Stateless
public class ModuleBean implements ModuleBeanRemote
{

    @PersistenceContext
    EntityManager em;

    @Override
    public String getDescription(long moduleId) {
        StringBuilder buf = new StringBuilder();
        buf.append("<h1>Modul 1: BlueJ, Klasser og Objekter</h1>\n");
        buf.append("<p>I denne modulen skal du først og fremst lære å bruke\n");
        buf.append("verktøyene du skal bruke i resten av kurset. I tillegg\n");
        buf.append("skal du begynne å lære litt om objektorientert programmering\n");
        buf.append("og java.</p>\n");
        buf.append("\n");
        buf.append("<h2>Læringsmål:</h2>\n");
        buf.append("<p>Du har fullført modulen når du kan:</p>\n");
        buf.append("<ul>\n");
        buf.append("<li><strong>Bruke BlueJ</strong>, bl.a. til å: <ul>\n");
        buf.append("<li>Åpne, lagre, og lukke prosjekter.</li>\n");
        buf.append("<li>Lage objekter</li>\n");
        buf.append("<li>Kalle metoder i objektene, med og uten parametere</li>\n");
        buf.append("<li>Bruke editoren til å se på kildekoden til en klasse</li>\n");
        buf.append("<li>Kunne kompilere prosjektet</li>\n");
        buf.append("</ul></li>\n");
        buf.append("<li>Litt java, du skal f.eks.<ul>\n");
        buf.append("<li>Kunne kjenne igjen en klassedefinisjon, og kunne finne navnet på klassen</li>\n");
        buf.append("<li>Kjenne til forskjellige typer data</li>\n");
        buf.append("<li>Kalle metoder med et objekt som parameter</li>\n");
        buf.append("<li>Kalle metoder som returnerer en verdi</li>\n");
        buf.append("<li>Kjenne forskjellen mellom klasser og objekter</li>\n");
        buf.append("</ul></li>\n");
        buf.append("</ul>\n");
        buf.append("<h2>Oppgave</h2>\n");
        buf.append("<p>Lag en video der du forklarer læringsmålene i modulen. Bruk Camtasia Relay eller annet egnet\n");
        buf.append("verktøy for skjermopptak. Link skal inn på bloggen. (PS: Max 5 min). </p>\n");
        return buf.toString();
    }

    /**
     * This method is a bit optimistic, in that it returns info about every file
     * that has been uploaded. It should only include those that are
     * flagged/associated to a module as recourses.
     *
     * @param moduleId
     *
     * @return
     */
    public List<Resource> getResourceInfo(int moduleId) {
        // create a query to get file data
        TypedQuery<UploadedFile> q = em.createQuery("SELECT f FROM UploadedFile f",
                                                    UploadedFile.class);
        List<UploadedFile> ufl = q.getResultList();

        // create resource objects for each file, and add them
        //  them to the resource list
        List<Resource> rl = new ArrayList<>();
        for (UploadedFile uf : ufl) {
            Resource r = new Resource(uf.getId(), uf.getFilename(), uf.getPurpose());
            rl.add(r);
        }
        return rl;
    }
}
