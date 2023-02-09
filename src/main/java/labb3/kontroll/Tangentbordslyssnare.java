package labb3.kontroll;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import labb3.modell.Nivå;
import labb3.modell.Väderstreck;

public class Tangentbordslyssnare implements KeyListener {

    private final Nivå enNivå;

    public Tangentbordslyssnare(Nivå enNivå) {
        this.enNivå = enNivå;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        char c = e.getKeyChar();
        switch (c) {
            case 'w' -> enNivå.hoppaÅt(Väderstreck.NORR);
            case 'a' -> enNivå.hoppaÅt(Väderstreck.VÄSTER);
            case 's' -> enNivå.hoppaÅt(Väderstreck.SÖDER);
            case 'd' -> enNivå.hoppaÅt(Väderstreck.ÖSTER);         
        }
        System.out.println("keyPressed: " + c);
        
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // Används inte men måste implementeras eftersom keyTyped finns i
        // gränssnittet KeyListener.
    }

    @Override
    public void keyReleased(KeyEvent e) {
        // Används inte men måste implementeras eftersom keyReleased finns is
        // gränssnittet KeyListener.
    }
}
