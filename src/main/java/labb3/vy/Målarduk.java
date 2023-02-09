package labb3.vy;

import java.awt.*;
import java.util.ArrayList;
import javax.swing.JPanel;

import labb3.GlobalaKonstanter;

import labb3.modell.Gång;
import labb3.modell.Nivå;
import labb3.modell.Rum;
import labb3.modell.Väderstreck;

import static labb3.GlobalaKonstanter.*;
import static labb3.verktyg.Grafik.drawThickLine;
import static labb3.verktyg.Grafik.fillCircle;

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
    protected void paintComponent(Graphics tmp_g) {
        super.paintComponent(tmp_g);
        Graphics2D g = (Graphics2D) tmp_g;

        ArrayList<Rum> rumen = enNivå.getAllRums();
        for (Rum rum : rumen) {
            ritaRum(g, rum);
        }
        for (Rum rum : rumen) {
            ritaGångarFrånRum(g, rum);
        }
        for (Rum rum : rumen) {
            for (Gång gång : rum.getGångar()) {
                if (gång != null) {
                    ritaGång(g, gång);
                }
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

    private void ritaRum(Graphics2D g, Rum ettRum) {
        int x1 = ettRum.getX();
        int y1 = ettRum.getY();
        g.setColor(GlobalaKonstanter.VÄGGFÄRG);
        g.fillRect(x1, y1, ettRum.getWith(), ettRum.getHeight());
        g.setColor(ettRum.getFloorColor());
        g.fillRect(x1 + VÄGGTJOCKLEK, y1 + VÄGGTJOCKLEK, ettRum.getWith() - DUBBEL_VÄGGTJOCKLEK, ettRum.getHeight() - DUBBEL_VÄGGTJOCKLEK);
    }

    private void ritaGångarFrånRum(Graphics2D g, Rum ettRum) {
        ArrayList<Punkt> startPunkter = new ArrayList<Punkt>(4);
        ArrayList<Punkt> slutPunkter = new ArrayList<Punkt>(4);

        if (ettRum.finnsUtgångÅt(Väderstreck.VÄSTER)) {
            Punkt startPunkt = new Punkt(ettRum.getX()+VÄGGTJOCKLEK, ettRum.getYCentrum());
            startPunkter.add(startPunkt);
            slutPunkter.add( new Punkt(startPunkt.x() - HALV_VÄGGTJOCKLEK-VÄGGTJOCKLEK, startPunkt.y()));
        }
        if (ettRum.finnsUtgångÅt(Väderstreck.NORR)) {
            Punkt startPunkt = new Punkt(ettRum.getXCentrum(), ettRum.getY()+VÄGGTJOCKLEK);
            startPunkter.add(startPunkt);
            slutPunkter.add( new Punkt(startPunkt.x(), startPunkt.y() - VÄGGTJOCKLEK - HALV_VÄGGTJOCKLEK));
        }

        if (ettRum.finnsUtgångÅt(Väderstreck.SÖDER)) {
            Punkt startPunkt = new Punkt(ettRum.getXCentrum(), ettRum.getY() + ettRum.getHeight()-VÄGGTJOCKLEK);
            startPunkter.add(startPunkt);
            slutPunkter.add( new Punkt(startPunkt.x(), startPunkt.y() + VÄGGTJOCKLEK+ HALV_VÄGGTJOCKLEK));
        }

        if (ettRum.finnsUtgångÅt(Väderstreck.ÖSTER)) {
            Punkt startPunkt = new Punkt(ettRum.getX() + ettRum.getWith() - VÄGGTJOCKLEK, ettRum.getYCentrum());
            startPunkter.add(startPunkt);
            slutPunkter.add( new Punkt(startPunkt.x() + VÄGGTJOCKLEK + HALV_VÄGGTJOCKLEK, startPunkt.y()));
        }
        for (int i = 0; i < startPunkter.size(); i++) {
            drawThickLine(g, startPunkter.get(i), slutPunkter.get(i), VÄGGTJOCKLEK, GÅNGFÄRG);
        }
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
        for (int i = 0; i < startPunkter.size(); i++) {
            fillCircle(g,slutPunkter.get(i),HALV_VÄGGTJOCKLEK,GÅNGFÄRG);
        }
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_OFF);

    }

    private Punkt baspunkt(Rum ettRum, Väderstreck enRiktning) {
        return null;
        /* endast här för att Eclipse inte ska klaga */
    }

    private Punkt pivotpunkt(Rum ettRum, Väderstreck enRiktning) {
        return null;
        /* endast här för att Eclipse inte ska klaga */
    }

    private void ritaGång(Graphics2D g, Gång gång) {
        Rum aRum = gång.getTill();
        Rum bRum = gång.getFrån();
        Väderstreck aVäder = gång.getRiktningInITill();
        Väderstreck bVäder = gång.getRiktningUtUrFrån();
        Punkt aPunkt = new Punkt(0, 0);
        Punkt bPunkt = new Punkt(0, 0);
        if (null != aVäder) switch (aVäder) {
            case NORR -> aPunkt = new Punkt(aRum.getXCentrum(), aRum.getY()-HALV_VÄGGTJOCKLEK);
            case SÖDER -> aPunkt = new Punkt(aRum.getXCentrum(), aRum.getY() + aRum.getHeight()+HALV_VÄGGTJOCKLEK);
            case VÄSTER -> aPunkt = new Punkt(aRum.getX()-HALV_VÄGGTJOCKLEK, aRum.getYCentrum());
            case ÖSTER -> aPunkt = new Punkt(aRum.getX() + aRum.getWith()+HALV_VÄGGTJOCKLEK, aRum.getYCentrum());
            default -> {
            }
        }
        if (null != bVäder) switch (bVäder) {
            case NORR -> bPunkt = new Punkt(bRum.getXCentrum(), bRum.getY()-HALV_VÄGGTJOCKLEK);
            case SÖDER -> bPunkt = new Punkt(bRum.getXCentrum(), bRum.getY() + bRum.getHeight()+HALV_VÄGGTJOCKLEK);
            case VÄSTER -> bPunkt = new Punkt(bRum.getX()-HALV_VÄGGTJOCKLEK, aRum.getYCentrum());
            case ÖSTER -> bPunkt = new Punkt(bRum.getX() + bRum.getWith()+HALV_VÄGGTJOCKLEK, bRum.getYCentrum());
            default -> {
            }
        }
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
        drawThickLine(g, aPunkt, bPunkt, VÄGGTJOCKLEK, GÅNGFÄRG);
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_OFF);
    }

    private void ritaMarkörFörVarAnvändarenÄr(Graphics2D g) {
        Punkt punkt = new Punkt(enNivå.getCurentRum().getXCentrum(), enNivå.getCurentRum().getYCentrum());
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
        fillCircle(g,punkt,ANVÄNDARRADIE,ANVÄNDARFÄRG);
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_OFF);
    }
}
