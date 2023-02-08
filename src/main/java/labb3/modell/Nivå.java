package labb3.modell;

import java.util.ArrayList;
import java.util.Observable;

public class Nivå extends Observable {
    private ArrayList<Rum> rum;
    private Rum nuvarandeRum;

    public Nivå(Rum startRum, ArrayList<Rum> rum) {
        this.nuvarandeRum = startRum;
        this.rum = rum;
        if (!rum.contains(startRum)) {
            throw new Error("Arraylis rum does not contain startrum");
        }

        // loops through all roms and check if any one overlaps and throws error if so
        for (Rum i : rum) {
            for (Rum j : rum) {
                if (i != j) {
                    int x_dist = i.getX() - j.getX();
                    int y_dist = i.getY() - j.getY();
                    if (Math.abs(x_dist) < i.getWith() / 2 + j.getWith() / 2) {
                        throw new Error("rum överlappar");
                    } else if (y_dist < i.getHeight() / 2 + j.getHeight() / 2) {
                        throw new Error("rum överlappar");
                    }
                }

            }
        }

    }

    public ArrayList<Rum> getAllRums() {
        return this.rum;
    }

    public Rum getCurentRum() {
        return this.nuvarandeRum;
    }

    public void hoppaÅt(Väderstreck väderstreck) {
        // Om väderstreck inte är en riktning i vilken det finns en gång, så ändras
        // inte rummet användaren "är i" (och inte heller kastas undantag). (Denna
        // metod använder kontrolldelen av programmet för att begära ett hopp till
        // angränsande rum efter att användaren tryckt på en tangent.)
        if (this.nuvarandeRum.finnsUtgångÅt(väderstreck)) {
            Gång path = this.nuvarandeRum.gångÅt(väderstreck);
            Rum nextRum;
            if (path.getFrån() == this.nuvarandeRum) {
                nextRum = path.getTill();
            } else {
                nextRum = path.getFrån();
            }
            this.nuvarandeRum = nextRum;
        }
    }
}
