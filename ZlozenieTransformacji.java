package pl.edu.pg.eti.ksg.po.lab1.transformacje;

public class ZlozenieTransformacji implements Transformacja{
    private final Transformacja[] tab;
    public ZlozenieTransformacji(Transformacja[] transformacja) {
        this.tab = transformacja;
    }
    @Override
    public Punkt transformuj(Punkt p) {
        Punkt copy = p;
        for(int i=0; i<tab.length; i++) copy = tab[i].transformuj(copy);
        return copy;
    }

    @Override
    public Transformacja getTransformacjaOdwrotna() throws BrakTransformacjiOdwrotnejException {
        Transformacja[] copy = new Transformacja[tab.length];
        for(int i=0; i<tab.length; i++) copy[tab.length-1-i] = tab[i].getTransformacjaOdwrotna();
        return new ZlozenieTransformacji(copy);
    }
    public double getN() {
        return tab.length;
    }
    @Override
    public String toString() {
        String kolejnosctrans = "";
        for(int i=0; i < tab.length; i++) {
            kolejnosctrans = kolejnosctrans + tab[i] + ", ";
        }
        return "ZlozenieTransformacji w ilosci: " + tab.length + ", gdzie wystepuja nastepujace transformacje: " + kolejnosctrans;
    }
}
