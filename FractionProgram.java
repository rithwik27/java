import java.util.Scanner;

class Fraction {
    /* private for numerator and denominator so that they cannot be directly accessed outside Fraction */
    private int numerator;
    private int denominator;
    static int count = 0; //To get count of total Fractions in the programme, by default public (Even though not specified).
    private int nonStatic =0;
    /* Default constructor that does not initialize this Fraction */
    public Fraction() {

    }

    public Fraction(int n , int d) {
        this.numerator = n;
        this.denominator = d;
        count++;
    }

    /* To get the value of denominator outside Fraction */
    public int getDenominator() {
        return denominator;
    }

    /* To get the value of numerator outside Fraction */
    public int getNumerator() {
        return numerator;
    }

    /* To set the value of numerator from outside Fraction */
    public void setNumerator(int n) {
        this.numerator = n;
    }

    /* To set the value of denominator from outside Fraction */
    public void setDenominator(int d) {
        this.denominator = d;
    }

    /* Gets inherited by MixedFraction */
    public void printFraction() {
        System.out.println(numerator + "/" + denominator);
    }

    public static void printCount() {
        System.out.println(count);
    }


    public static Fraction add(Fraction a , Fraction b) {
        Fraction fraction = new Fraction();
        if (a.getDenominator() == b.getDenominator()) {
            fraction.setDenominator(a.getDenominator()); //Any one of a or b will work
            fraction.setNumerator(a.getNumerator() + b.getNumerator());
        }
        else {
            fraction.setDenominator(a.getDenominator() * b.getDenominator());
            fraction.setNumerator(a.getNumerator() * b.getDenominator() + b.getNumerator() * a.getDenominator());
        }
        return fraction;
    }
    public static Fraction sub(Fraction a , Fraction b) {
        Fraction fraction = new Fraction();
        if (a.getDenominator() == b.getDenominator()) {
            fraction.setDenominator(a.getDenominator()); //Any one of a or b will work
            fraction.setNumerator(a.getNumerator() - b.getNumerator());
        }
        else {
            fraction.setDenominator(a.getDenominator() * b.getDenominator());
            fraction.setNumerator(a.getNumerator() * b.getDenominator() - b.getNumerator() * a.getDenominator());
        }
        return fraction;
    }
    public static Fraction mul(Fraction a , Fraction b) {
        Fraction fraction = new Fraction();
        fraction.setDenominator(a.getDenominator() * b.getDenominator());
        fraction.setNumerator(a.getNumerator() * b.getNumerator());
        return fraction;
    }
    public static Fraction red(Fraction a) {
        Fraction fraction = new Fraction();
        fraction.setDenominator(a.getDenominator());
        fraction.setNumerator(a.getNumerator());
        int min =(a.getDenominator() < a.getNumerator()) ? a.getDenominator() : a.getNumerator();
        for(int i = min; i >=2; i--){
          if (fraction.getNumerator()%i==0 && fraction.getDenominator()%i==0){
          fraction.setDenominator(a.getDenominator()/i);
          fraction.setNumerator(a.getNumerator()/i);
          break;
        }

        }
        return fraction;
    }


    public static void mix(Fraction a) {
        Fraction fraction = new Fraction();
        int j =a.getNumerator()/a.getDenominator();
        fraction.setDenominator(a.getDenominator());
        fraction.setNumerator(a.getNumerator() % a.getDenominator());
        System.out.println(j+" "+(a.getNumerator() % a.getDenominator())+"/"+(a.getDenominator()));


    }



    public static Fraction div(Fraction a , Fraction b) {
        Fraction fraction = new Fraction();
        fraction.setDenominator(a.getDenominator() * b.getNumerator());
        fraction.setNumerator(a.getNumerator() * b.getDenominator());
        return fraction;
    }

}

class MixedFraction extends Fraction {
    private int wholenumber;

    public MixedFraction(int n , int d , int w) {
        //super(n,d); This way we can initialize the Fraction inside the MixedFraction by simply calling the constructor of Fraction(n,d)
        this.wholenumber = w;
        setNumerator(n);
        setDenominator(d);
    }

    // Overriden function. When you call printFraction() from object of MixedFraction, it will use only this one, and not the one set in Fraction.
    public void printFraction() {
        System.out.println(this.wholenumber + " " + getNumerator() + "/" + getDenominator());
    }
}

public class FractionProgram {
    public static void main(String[] args) {
        int n , d , w;
        Scanner scan = new Scanner(System.in);
        Fraction.add(new Fraction(4,5) , new Fraction(3,4)).printFraction();
        Fraction.sub(new Fraction(4,5) , new Fraction(3,4)).printFraction();
        Fraction.mul(new Fraction(4,5) , new Fraction(3,4)).printFraction();
        Fraction.div(new Fraction(4,5) , new Fraction(3,4)).printFraction();
        System.out.println("Enter Numerator, Denominator: ");
        n = scan.nextInt();
        d = scan.nextInt();
        Fraction.red(new Fraction(n,d)).printFraction();
        Fraction.mix(new Fraction(n,d));
    }
}
