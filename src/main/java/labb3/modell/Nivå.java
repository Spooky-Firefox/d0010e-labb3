package labb3.modell;

import java.util.ArrayList;
import labb3.vy.Målarduk;

// TODO: Gör så att klassen Nivå ärver Observable i paketet java.util. 
public class Nivå {

    private Rum startRum;
    private ArrayList<Rum> rum;
    private Rum nuvarandeRum;
    // TODO: Lägg till tillståndsvariabler för att hålla reda på nivåns rum och
    // i vilket rum som användaren "är".

    public Nivå(Rum startRum, ArrayList<Rum> rum) {
        this.startRum = startRum;
        this.rum = rum;
        if (!rum.contains(startRum)) {
            throw new Error("Arraylis rum does not contain startrum");
        }
        for (Rum r : rum) {
            // TODO: Kontrollera att inga rum överlappar varandra. Om det ändå är
            // fallet, kasta undantag med lämpligt felmeddelande.
        }

    }

    public ArrayList<Rum> getAllRums(Målarduk målarduk) {
        // TODO: Skriv en instansmetod som returnerar alla rummen. Denna behöver
        // Målarduk för att veta vilka rum som finns på nivån och som ska ritas ut.
        return null;
    }

    public Rum getCurentRum() {
        // TODO Skriv en instansmetod som returnerar en referens till det rum som
        // användaren "är i".
        return null;
    }

    public void hoppaÅt(Väderstreck väderstreck) {
        // TODO: Skriv klar instansmetoden hoppaÅt nedan så att den ändrar det rum
        // som användaren "är i" om det är möjligt genom att följa en gång från
        // rummet och i riktning väderstreck.

        // Om väderstreck inte är en riktning i vilken det finns en gång, så ändras
        // inte rummet användaren "är i" (och inte heller kastas undantag). (Denna
        // metod använder kontrolldelen av programmet för att begära ett hopp till
        // angränsande rum efter att användaren tryckt på en tangent.)
    }
}
