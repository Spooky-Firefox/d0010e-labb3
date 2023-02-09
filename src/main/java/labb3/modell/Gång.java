package labb3.modell;
/**
 * 
 * @author Viktor Magnusson & Olle Ronstad
 */
public class Gång {

    private Rum från;
    private Rum till;
    private Väderstreck riktningUtUrFrån;
    private Väderstreck riktningInITill;

    public Gång(Rum från, Väderstreck riktningUtUrFrån, Rum till,Väderstreck riktningInITill) {
        this.från = från;
        this.till = till;
        this.riktningUtUrFrån = riktningUtUrFrån;
        this.riktningInITill = riktningInITill;
    }

    public Rum getFrån() {
        return från;
    }

    public Rum getTill() {
        return till;
    }

    public Väderstreck getRiktningUtUrFrån() {
        return riktningUtUrFrån;
    }

    public Väderstreck getRiktningInITill() { return riktningInITill; }

    public Rum frånRum(Rum rum){
        if (this.från == rum) {
            return this.till;
        } else {
            return this.från;
        }
    }
}
