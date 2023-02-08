package labb3.modell;

import labb3.verktyg.Punkt;

import java.awt.Color;

import static labb3.GlobalaKonstanter.ANTAL_VÄDERSTRECK;

public class Rum {

    private final Punkt pos;
    private final Gång[] exits = new Gång[ANTAL_VÄDERSTRECK];
    private final int with, height;
    private final Color floorColor;

    public Rum(Color golvfärg, int bredd, int höjd, int övX, int övY) {
        pos = new Punkt(övX, övY);
        with = bredd;
        height = höjd;
        floorColor = golvfärg;
    }

    public int getX() {
        return this.pos.x();
    }

    public int getXCentrum() {
        return this.pos.x() + this.with / 2;
    }

    public int getYCentrum() {
        return this.pos.y() + this.height / 2;
    }

    public int getY() {
        return this.pos.y();
    }

    public int getWith() {
        return this.with;
    }

    public int getHeight() {
        return this.height;
    }

    public Color getFloorColor() {
        return floorColor;
    }

    // finnsUtgångÅt(Väderstreck väderstreck)
    //
    // som ska kontrollera om det från ett rum finns en utgång åt visst
    // väderstreck.
    public boolean finnsUtgångÅt(Väderstreck väderstreck) {
        return this.exits[väderstreck.index()] != null;
    }

    // Gång gångenÅt(Väderstreck väderstreck) som
    //
    // returnerar den gång som leder från ett rum i riktning väderstreck. Om
    // sådan gång saknas ska ett undantag kastas med lämpligt felmeddelande.
    public Gång gångÅt(Väderstreck väderstreck) {
        if (this.exits[väderstreck.index()] == null) {
            throw new IllegalArgumentException("en fång åt väderstrecket existerar inte, använd finnsUtgång först");
        }
        return this.exits[väderstreck.index()];
    }

    public static void kopplaIhop(Rum från, Väderstreck riktningUtUrFrån,
                                  Rum till, Väderstreck riktningInITill) {
        Gång path = new Gång(från, riktningUtUrFrån, till, riktningInITill);
        från.exits[riktningUtUrFrån.index()] = path;
        till.exits[riktningInITill.index()] = path;
    }

}
