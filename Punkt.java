package pl.edu.pg.eti.ksg.po.lab1.transformacje;
import java.util.Scanner;
public class Punkt {
    /*
     * Słowo kluczowe final oznacza, że po pierwszym przypisaniu
     * zawartość pól x oraz y nie może zostać zmieniona
     * w tym miejscu jest to odpowiednik słowa kluczowego const
     * z języka C++.
     */
    private final double x,y;
    private final int id;
    private static int nextId = 0;
    private static int pointsNumber = 0;
    public Punkt(double x, double y) {
        this.x = x;
        this.y = y;
        this.id = nextId;
        nextId++;
        pointsNumber++;
    }
    protected void finalize() {
        pointsNumber--;
    }
    public double getX() {
        return x;
    }
    public double getY() {
        return y;
    }
    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Punkt) {
            Punkt other = (Punkt)obj;
            return x == other.x && y == other.y;
        }
        return false;
    }
    @Override
    public int hashCode() {
        double result = x;
        result = 31 * result + y;
        return (int) result;
    }
    @Override
    public String toString() {
        return "Instancja klasy Punkt zawierająca liczby x: " + x + ", y: " + y;
    }
    /**
     * Początek układu współrzędnych.
     * W tym miejscu słowo kluczowe final oznacza, że statyczne
     * pole klasy Punkt nie może zostać zmienione.
     * Dotyczy to jednak samej referencji, a nie obiektu, na który
     * wskazuje.
     */
    public static final Punkt O = new Punkt(0, 0);
    /**
     * Punkt (1,0) w układzie współrzędnych
     */
    public static final Punkt E_X = new Punkt(1, 0);

    /**
     * Punkt (0,1) w układzie współrzędnych
     */
    public static final Punkt E_Y = new Punkt(0, 1);

    public static void main(String[] args)
    {
        Punkt a = new Punkt(3,5);
        System.out.println("Wszytane liczby do Punktu a: ");
        System.out.println(a.getX());
        System.out.println(a.getY());

        System.out.println();
        Punkt b = new Punkt(10,6);
        System.out.println(b.toString());

        System.out.println();
        System.out.println("Porównywanie referencji: a == a");
        System.out.println(a == a);
        System.out.println("Porównywanie referencji: a == b");
        System.out.println(a == b);
        System.out.println("Metoda equals: a.equals(a)");
        System.out.println(a.equals(a));
        System.out.println("Metoda equals: a.equals(b)");
        System.out.println(a.equals(b));
        System.out.println("Metoda hashCode: a.hashCode()");
        System.out.println(a.hashCode());
        System.out.println("Metoda hashCode: b.hashCode()");
        System.out.println(b.hashCode());

        System.out.println();
        Punkt c = new Punkt(3,5);
        System.out.println(c.toString());

        System.out.println();
        System.out.println("Porównywanie referencji: a == c");
        System.out.println(a == c);
        System.out.println("Metoda equals: a.equals(c)");
        System.out.println(a.equals(c));
        System.out.println("Metoda hashCode: c.hashCode()");
        System.out.println(c.hashCode());
    }
}