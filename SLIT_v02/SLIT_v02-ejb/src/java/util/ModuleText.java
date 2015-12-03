/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.util.ArrayList;

/**
 *
 * @author Even
 */
public class ModuleText {
    private static final String module1 = "I denne modulen skal du først og fremst lære å bruke verktøyene du skal bruke i resten av kurset. I tillegg skal du begynne å lære litt om objektorientert programmering og java.\n" +
"\n" +
"Læringsmål:\n" +
"Du har fullført modulen når du kan:\n" +
"\n" +
"Bruke BlueJ, for eksempel skal du kunne:\n" +
"Åpne, lagre, og lukke prosjekter.\n" +
"Lage objekter\n" +
"Kalle metoder i objektene, med og uten parametere\n" +
"Bruke editoren til å se på kildekoden til en klasse\n" +
"Kunne kompilere prosjektet\n" +
"Litt java, du skal f.eks.\n" +
"Kunne kjenne igjen en klassedefinisjon, og kunne finne navnet på klassen\n" +
"Kjenne til forskjellige typer data\n" +
"Kalle metoder med et objekt som parameter\n" +
"Kalle metoder som returnerer en verdi\n" +
"Kjenne forskjellen mellom klasser og objekter\n" +
"Godkjenning\n" +
"Det er ikke noen programmeringsoppgave i modul 1.\n" +
"\n" +
"Lag en video der du forklarer læringsmålene i modulen. Bruk Camtasia Relay eller annet egnet verktøy for skjermopptak. Link skal inn på bloggen. (PS: Max 5 min).\n" +
"\n" +
"Foreleser eller hjelpelærer godkjenner videoen.";
    
    private static final String module2 = "I denne modulen skal du lære å lese java klassedefinisjoner. Java programmer består av klasser, så du skal egentlig lære å lese javaprogrammer. Du skal også få prøve å skrive enkle programmer, men akkurat som når du skal lære andre språk, må du lære å lese før du kan begynne å skrive.\n" +
"\n" +
"Læringsmål:\n" +
"Du har fullført modulen når du kan:\n" +
"\n" +
"lese en klassedefinisjon, og kunne fortelle:\n" +
"hva klassen heter\n" +
"hvilke felt den har, hva de heter og hvilken type de har\n" +
"hvilke metoder den har, og hva metodene heter\n" +
"beskrive parametere (med navn og type) og returverdi for alle metodene\n" +
"forklare forskjellen på forskjellige slags metoder (constructors, getters, setters) og vet hva de brukes til\n" +
"Kan skrive en klassedefinisjon\n" +
"med felt og metoder i riktig rekkefølge\n" +
"med metoder som bruker tilordning, if-setninger og utskrifter\n" +
"Oppgave og godkjenning\n" +
"Skriv en klasse selv fra scratch. Lag noe annet enn en kopi av eksemplene i boka (som sjokoladeautomat og lignende)\n" +
"\n" +
"Godkjennes av foreleser eller hjelpelærer i intervju.";
    
    private static final String module3 = "Virkelige bruksområder for programmer er nesten alltid så kompliserte at programmene ikke kan skrives som en klasse. Den ville bli for komplisert. I denne modulen skal du lære om hvordan du kan bruke flere klasser og objekter i samme program. Du skal også lære litt om hvordan vi bruker klasser til å bryte ned store problemer i mindre og enklere delproblemer.\n" +
"\n" +
"Læringsmål:\n" +
"Du har fullført modulen når du kan:\n" +
"\n" +
"kan forklare hva som menes med abstraksjon og modularisering\n" +
"kan bruke debuggeren i BlueJ\n" +
"har lært litt mer java, og kan:\n" +
"forklare forskjellen på primitive typer og objekttyper\n" +
"kan skrive kode som lager nye objekter\n" +
"kan skrive kode som kaller metoder i samme objekt, og i andre objekter\n" +
"kan tegne klassediagrammer og objektdiagrammer\n" +
"Oppgave\n" +
"Lag et program fra scratch med flere klasser, der en klasse blir brukt av en annen klasse Programmet skal bruke if-setninger. Du skal bruke Checkstyle og PMD til å sjekke koden før du leverer. Lever prosjektet i innleveringsmappe i fronter.\n" +
"\n" +
"Lag en video der du går gjennom og forklarer programmet. Link til video legges på bloggen";
    
    private static final String module4 = "I de fleste systemer har vi mange objekter av samme type. Det er f.eks. mange studentobjekter og mange innleveringsobjekter i fronter. I denne modulen skal du lære å handtere mange objekter av samme type.\n" +
"\n" +
"Læringsmål:\n" +
"Du har fullført modulen når du:\n" +
"\n" +
"vet når du trenger samlinger av objekter\n" +
"kan bruke klassen ArrayList\n" +
"kan gjøre rede for de viktigste metodene i ArrayList\n" +
"vet hvordan du spesifiserer hvilken type objekter ei liste kan inneholde\n" +
"kan skrive metoder som setter inn, finner og fjerner objekter i ei liste\n" +
"kan bruke for-each løkker til å gå gjennom ei liste\n" +
"kan bruke while-løkker og iteratorer til å gå gjennom ei løkke\n" +
"vet hva en array er, og når det er fornuftig å bruke array\n" +
"vet om standardbibliotektet\n" +
"vet hvorfor vi bruker import-setninger\n" +
"Oppgave\n" +
"Lag ditt eget prosjekt fra bunnen av. Skriv all koden selv og bruk ting du har lært i modul 1-4. Bruk PMD og Checkstyle. De skal ikke rapportere feil eller mangler.\n" +
"\n" +
"Ta med prosjektet til intervjuet med foreleser";
    
    private static final String module5 = "Det er ikke så vanskelig å lære språket java. Du kan pugge det meste. Det som er vanskelig er å finne ut hvilke klasser du trenger, og hvilke felt og metoder disse klassene skal ha. I denne modulen skal du lære en teknikk for å finne ut dette. Denne jobben blir ofte kalt detaljdesign.\n" +
"\n" +
"Læringsmål:\n" +
"Du har fullført modulen når du :\n" +
"\n" +
"kan kan bruke verb/substantiv metoden til å finne ut\n" +
"hvilke klasser du trenger for å løse et problem\n" +
"og hvilke metoder klassene skal ha\n" +
"kan bruke scenarier (evt. med CRC kort) til å sjekke at du har funnet klassene og metodene du trenger\n" +
"vet hva et design pattern er\n" +
"Oppgave\n" +
"Ta utgangspunkt i en beskrivelse av et system, set fra brukerens perspektiv. Du kan bruke innledningen til et av eksemplene i læreboka, eller du kan lage noen brukerhistorier for et eksempel du velger sel\n" +
"\n" +
"Bruk substantiv-verb-metoden til finne ut hvilke klasser og metoder du må ha for at systemet skal fungere. Ta med systembeskrivelsen og dokumentasjon av designet til foreleser eller hjelpelærer for godkjenning\n" +
"\n" +
"Godkjenning\n" +
"Godkjennes av foreleser eller hjelpelærer i intervju";
    
    public static String[] list = {module1, module2, module3, module4, module5};
    
    public static String getModule1() {
        return module1;
    }
    
    public static String getModule2() {
        return module2;
    }
    
    public static String getModule3() {
        return module3;
    }
    
    public static String getModule4() {
        return module4;
    }
    
    public static String getModule5() {
        return module5;
    }
    
}
