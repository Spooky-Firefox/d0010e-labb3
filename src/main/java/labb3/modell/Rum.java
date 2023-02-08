package labb3.modell;

import java.awt.Color;

public class Rum {
    private Color golvfärg;
    private int bredd, höjd, övX, övY;
    // TODO: Lägg till tillståndsvariabler.
    public Rum(Color golvfärg, int bredd, int höjd, int övX, int övY) {
        this.golvfärg = golvfärg;
        this.bredd = bredd;
        this.höjd=höjd;
        this.övX = övX;
        this.övY = övY;
        // TODO: (övX,övY) är
        // koordinaten för rummets övre vänstra hörn och lagras lämpligen som en
        // instans av klassen Punkt i paketet labb3.verktyg.
    }

    public Color getGolvfärg() {
        return golvfärg;
    }

    public int getBredd() {
        return bredd;
    }

    public int getHöjd() {
        return höjd;
    }

    public int getÖvX() {
        return övX;
    }

    public int getÖvY() {
        return övY;
    }

    
    // TODO: Skriv "getters", metoder som returnerar tillståndsvariablernas
    // värden.
    
    public boolean finssUtgångÅt(Väderstreck väderstreck) {
        // TODO: Skriv instansmetoden
        //
        // finnsUtgångÅt(Väderstreck väderstreck)
        //
        // som ska kontrollera om det från ett rum finns en utgång åt visst
        // väderstreck.
        return true;
    }

    public Gång gångetÅt(Väderstreck väderstreck) {
        // TODO: Skriv instansmetoden
        //
        // Gång gångenÅt(Väderstreck väderstreck) som
        //
        // returnerar den gång som leder från ett rum i riktning väderstreck. Om
        // sådan gång saknas ska ett undantag kastas med lämpligt felmeddelande.
        return null;
    }
   

    public static void kopplaIhop(Rum från, Väderstreck riktningUtUrFrån, Rum till, Väderstreck riktningInITill) {
         // TODO: Skrivklar metoden nedan som kopplar ihop två rum med en gång.
    }
}
