package labb3.vy;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;
import javax.swing.JPanel;
import labb3.GlobalaKonstanter;

import labb3.modell.Gång;
import labb3.modell.Nivå;
import labb3.modell.Rum;
import labb3.modell.Väderstreck;
import static labb3.verktyg.Grafik.drawThickLine;
import labb3.verktyg.Punkt;

// TODO: Ändra nästa rad så att en Målarduk "är-en" JPanel. 
public class Målarduk extends JPanel {

    private final Nivå enNivå;

    public Målarduk(Nivå enNivå) {
        this.enNivå = enNivå;
        this.setBackground(GlobalaKonstanter.MARKFÄRG);
        // TODO: Sätt bakgrundsfärgen på this till MARKFÄRG.
        this.setFocusable(true);
        // TODO: Anropa metoden setFocusable på this och med argumentet true.
        // Detta behövs för att lyssnaren i programmet ska reagera.
    }

    // TODO: Lätt till @Override på metoden nedan.
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        ArrayList<Rum> rumen = enNivå.getAllRums();
        for (Rum rum : rumen) {
            ritaRum(g, rum);
        }
        for (Rum rum : rumen) {
            ritaGångarFrånRum(g, rum);
        }
        for (Rum rum : rumen) {
            for (Gång gång : rum.getGångar()) {
                ritaGång(g, gång);
            }
        }

        ritaMarkörFörVarAnvändarenÄr(g);
        // Lägg till ett anrop till paintComponent i omedelbara
        // överklassen (JPanel). Skicka med g som argument.

        // TODO: Lägg till kod som ritar ut en grafisk labb3.vy av enNivå.
        //
        // För att underlätta finns hjälpmetoder som ska skrivas klara. Studera
        // noga bilderna i labbinstruktionen för att få fram formlerna för
        // bas- och pivotpunkternas koordinater. Använd ritmetoderna i klassen
        // labb3.labb3.verktyg.Grafik. Anropa hjälpmetoderna från paintComponent.
    }

    private void ritaRum(Graphics g, Rum ettRum) {
        g.setColor(ettRum.getFloorColor());
        int x1 = ettRum.getX();
        int y1 = ettRum.getY();
        g.fillRect(x1, y1, ettRum.getWith(), ettRum.getHeight());
        g.setColor(GlobalaKonstanter.VÄGGFÄRG);
        g.fillRect(x1, y1, ettRum.getWith(), ettRum.getHeight());
    }

    private void ritaGångarFrånRum(Graphics g, Rum ettRum) {
        g.setColor(Color.PINK);
//g.setColor(GlobalaKonstanter.VÄGGFÄRG);
        if (ettRum.finnsUtgångÅt(Väderstreck.VÄSTER)) {
            Punkt startPunkt = new Punkt(ettRum.getX(), ettRum.getYCentrum());
            Punkt slutPunkt = new Punkt(startPunkt.x() + GlobalaKonstanter.VÄGGTJOCKLEK, startPunkt.y());
            drawThickLine(g, startPunkt, slutPunkt, GlobalaKonstanter.DUBBEL_VÄGGTJOCKLEK, Color.PINK);
        }
        if (ettRum.finnsUtgångÅt(Väderstreck.NORR)) {
            Punkt startPunkt = new Punkt(ettRum.getXCentrum(), ettRum.getY());
            Punkt slutPunkt = new Punkt(startPunkt.x(), startPunkt.y() + GlobalaKonstanter.VÄGGTJOCKLEK);
            drawThickLine(g, startPunkt, slutPunkt, GlobalaKonstanter.DUBBEL_VÄGGTJOCKLEK, Color.PINK);
        }

        if (ettRum.finnsUtgångÅt(Väderstreck.SÖDER)) {
            Punkt startPunkt = new Punkt(ettRum.getXCentrum(), ettRum.getY());
            Punkt slutPunkt = new Punkt(startPunkt.x(), startPunkt.y() - GlobalaKonstanter.VÄGGTJOCKLEK);
            drawThickLine(g, startPunkt, slutPunkt, GlobalaKonstanter.DUBBEL_VÄGGTJOCKLEK, Color.PINK);
        }

        if (ettRum.finnsUtgångÅt(Väderstreck.ÖSTER)) {
            Punkt startPunkt = new Punkt(ettRum.getX() + ettRum.getWith(), ettRum.getYCentrum());
            Punkt slutPunkt = new Punkt(startPunkt.x() - GlobalaKonstanter.VÄGGTJOCKLEK, startPunkt.y());
            drawThickLine(g, startPunkt, slutPunkt, GlobalaKonstanter.DUBBEL_VÄGGTJOCKLEK, Color.PINK);
        }
    }

    private Punkt baspunkt(Rum ettRum, Väderstreck enRiktning) {
        return null;
        /* endast här för att Eclipse inte ska klaga */
    }

    private Punkt pivotpunkt(Rum ettRum, Väderstreck enRiktning) {
        return null;
        /* endast här för att Eclipse inte ska klaga */
    }

    private void ritaGång(Graphics g, Gång gång) {
        Rum aRum = gång.getTill();
        Rum bRum = gång.getFrån();
        Väderstreck aVäder = gång.getRiktningInITill();
        Väderstreck bVäder = gång.getRiktningUtUrFrån();
        Punkt aPunkt = new Punkt(0, 0);
        Punkt bPunkt = new Punkt(0, 0);
        if (null != aVäder) switch (aVäder) {
            case NORR -> aPunkt = new Punkt(aRum.getXCentrum(), aRum.getY());
            case SÖDER -> aPunkt = new Punkt(aRum.getXCentrum(), aRum.getY() + aRum.getHeight());
            case VÄSTER -> aPunkt = new Punkt(aRum.getX(),aRum.getYCentrum());
            case ÖSTER -> aPunkt = new Punkt(aRum.getX()+aRum.getWith(),aRum.getYCentrum());
            default -> {
            }
        }
        if (null != bVäder) switch (bVäder) {
            case NORR -> bPunkt = new Punkt(bRum.getXCentrum(), bRum.getY());
            case SÖDER -> bPunkt = new Punkt(bRum.getXCentrum(), bRum.getY() + bRum.getHeight());
            case VÄSTER -> bPunkt = new Punkt(bRum.getX(),aRum.getYCentrum());
            case ÖSTER -> bPunkt = new Punkt(bRum.getX()+bRum.getWith(),bRum.getYCentrum());
            default -> {
            }
        }
        drawThickLine(g, aPunkt, bPunkt, GlobalaKonstanter.VÄGGTJOCKLEK, Color.red);
    }

    private void ritaMarkörFörVarAnvändarenÄr(Graphics g) {
        Punkt punkt = new Punkt(enNivå.getCurentRum().getXCentrum(), enNivå.getCurentRum().getYCentrum());
        g.fillOval(punkt.x(), punkt.y(), GlobalaKonstanter.ANVÄNDARRADIE, GlobalaKonstanter.ANVÄNDARRADIE);
    }
}
