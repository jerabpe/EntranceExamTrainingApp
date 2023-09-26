package cz.cvut.fel.entranceexamtraining.model;

import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.Pair;

public class SimultaneousLinearEquationSolver {

    /**
    *    2 linear equations in this form
     *    ax + by = c
     *    px + qy = r
     *    code inspired by https://simple2code.com/c-programs/c-program-for-simultaneous-equations/
     */
    public static Pair<Integer, Integer> solve(double a, double b, double c, double p, double q, double r){
        Pair<Integer, Integer> result = null;
        if(((a*q - p *b) != 0) && ((b*p - q*a) != 0)){
            double x = (c*q - r*b) / (a*q - p*b);
            double y = (c*p - r*a) / (b*p - q*a);

            result = Pair.of((int) x,(int) y);
            //System.out.println(result);
        } else if(((a*q - p*b) == 0) && ((b*p - q*a) == 0) && ((c*q - r*b) == 0) && ((c*p - r*a) == 0)){
            System.out.println("Infinitely many solutions are possible");
        } else {
            System.out.println("No Possible solution");
        }
        return result;
    }
}
