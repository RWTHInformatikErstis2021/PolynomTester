

public class Polynom {
    private int[] polynom;
    private int raum;

    public Polynom(int[] pol, int raum) {
        this.polynom = pol;
        this.raum = raum;
        for (int i = 0; i < pol.length; i++) {
            pol[i] = pol[i] % raum;
        }
    }

    public boolean isReduceable() {
        for (int i = 0; i < raum; i++) {
            int j = value(i);
            System.out.println("Tested f(" + i + ") = " + j);
            if (j == 0)
                return true;
        }
        return false;
    }

    public int value(int x) {
        x = x % raum;
        int sum = 0;
        for (int i = 0; i < polynom.length; i++) {
            sum += polynom[i] * Math.pow(x, i);
        }
        return sum % raum;
    }

    public String toString() {
        String s = "f(x) = ";
        for (int i = polynom.length-1; i >= 0; i--) {
            s += polynom[i] + (i == 0 ? "" : ("x^" + i + " + "));
        }
        return s;
    }

}