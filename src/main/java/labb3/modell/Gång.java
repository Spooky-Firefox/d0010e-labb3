package labb3.modell;

public class Gång {

    private Rum från;
    private Rum till;
    private Väderstreck riktningUtUrFrån;

    public Gång(Rum från, Väderstreck riktningUtUrFrån, Rum till,Väderstreck riktningInITill) {
        this.från = från;
        this.till = till;
        this.riktningUtUrFrån = riktningUtUrFrån;
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
}
