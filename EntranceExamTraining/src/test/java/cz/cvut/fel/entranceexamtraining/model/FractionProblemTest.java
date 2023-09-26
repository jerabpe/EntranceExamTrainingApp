package cz.cvut.fel.entranceexamtraining.model;

import cz.cvut.fel.entranceexamtraining.model.fractions.Fraction;
import cz.cvut.fel.entranceexamtraining.model.fractions.FractionProblem;
import org.junit.jupiter.api.Test;

import java.util.List;

import static cz.cvut.fel.entranceexamtraining.model.Operator.ADD;
import static org.junit.jupiter.api.Assertions.*;

class FractionProblemTest {

    @Test
    public void simplifyTest1(){
        Fraction f = new Fraction(6,3);

        f.simplify();

        assertEquals(2,f.getNumerator());
        assertEquals(1,f.getDenominator());
    }
    @Test
    public void simplifyTest2(){
        Fraction f = new Fraction(5,2);

        f.simplify();

        assertEquals(5,f.getNumerator());
        assertEquals(2,f.getDenominator());
    }
    @Test
    public void simplifyTest3(){
        Fraction f = new Fraction(20,12);

        f.simplify();

        assertEquals(5,f.getNumerator());
        assertEquals(3,f.getDenominator());
    }

    @Test
    public void solveTest(){
        List<Fraction> fractions = List.of(new Fraction(5,2), new Fraction(2,3));
        List<Operator> operators = List.of(ADD);

        Fraction result = FractionProblem.solve(fractions, operators);

        assertEquals(19, result.getNumerator());
        assertEquals(6, result.getDenominator());
    }
}