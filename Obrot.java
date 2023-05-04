package pl.edu.pg.eti.ksg.po.lab1.transformacje;
import static java.lang.Math.*;
public class Obrot implements Transformacja{
    private final double alfa;
    public Obrot(double alfa) {
        this.alfa = alfa;
    }
    @Override
    public Punkt transformuj(Punkt p) {
        return new Punkt(p.getX() * cos(alfa) - p.getY() * sin(alfa), p.getX() * sin(alfa) + p.getY() * cos(alfa));
    }

    @Override
    public Transformacja getTransformacjaOdwrotna() {
        return new Obrot(-alfa);
    }
    public double getAlfa() {
        return alfa;
    }
    @Override
    public String toString() {
        return "Obrot " + alfa;
    }
}
