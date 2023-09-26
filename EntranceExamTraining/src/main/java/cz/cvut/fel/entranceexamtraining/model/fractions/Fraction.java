package cz.cvut.fel.entranceexamtraining.model.fractions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Random;

@Getter
@Setter
@AllArgsConstructor
public class Fraction {
    private int numerator;
    private int denominator;

    public static Fraction generateRandom(int maxDenominator){
        Random r = new Random();
        int denominator = r.nextInt(maxDenominator) + 1; // 1-maxDenominator
        int numerator = r.nextInt(2*denominator) + 1; // 1-denominator
        while(numerator == denominator){
            numerator = r.nextInt(2*denominator) + 1; // 1-denominator
        }
        return new Fraction(numerator, denominator);
    }

    private int gcd(int a, int b){
        if(b == 0){
            return a;
        }
        return gcd(b, a%b);
    }

    public void simplify(){
        int gcd = gcd(this.numerator, this.denominator);
        this.numerator /= gcd;
        this.denominator /= gcd;
        //return new Fraction(numerator/gcd, denominator/gcd);
    }

    @Override
    public String toString() {
        return numerator +"/"+ denominator;
    }
}
