package cz.cvut.fel.entranceexamtraining.model.fractions;

import cz.cvut.fel.entranceexamtraining.model.Operator;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Math.abs;

@Getter
@Setter
@AllArgsConstructor
@ToString
@NoArgsConstructor
public class FractionProblem {
    private Fraction solution;
    private List<Fraction> operands;
    private List<Operator> operators;

    public static FractionProblem generateRandom(int numOfOperands, int maxDenominator){
        List<Fraction> operands = new ArrayList<>();
        List<Operator> operators = new ArrayList<>();
        Fraction solution;
        do {
            operands.clear();
            operators.clear();
            for(int i=0; i<numOfOperands; i++){
                operands.add(Fraction.generateRandom(maxDenominator));
                if(i>0){
                    operators.add(Operator.getRandom());
                }
            }
            solution = solve(operands, operators);
        } while(abs(solution.getNumerator()) >= 100 || abs(solution.getDenominator()) >= 100);
        return new FractionProblem(solution, operands, operators);
    }

    public static Fraction solve(List<Fraction> operands, List<Operator> operators){
        Fraction tmp = new Fraction(operands.get(0).getNumerator(), operands.get(0).getDenominator());
        for(int i=1; i<operands.size(); i++){
            Fraction op = operands.get(i);
            Operator s = operators.get(i-1);
            switch (s) {
                case ADD -> {
                    tmp.setNumerator(tmp.getNumerator() * op.getDenominator() + tmp.getDenominator() * op.getNumerator());
                    tmp.setDenominator(tmp.getDenominator() * op.getDenominator());
                }
                case SUBTRACT -> {
                    tmp.setNumerator(tmp.getNumerator() * op.getDenominator() - tmp.getDenominator() * op.getNumerator());
                    tmp.setDenominator(tmp.getDenominator() * op.getDenominator());
                }
                case MULTIPLY -> {
                    tmp.setNumerator(tmp.getNumerator() * op.getNumerator());
                    tmp.setDenominator(tmp.getDenominator() * op.getDenominator());
                }
                case DIVIDE -> {
                    tmp.setNumerator(tmp.getNumerator() * op.getDenominator());
                    tmp.setDenominator(tmp.getDenominator() * op.getNumerator());
                }
            }
            tmp.simplify();
        }
        return tmp;
    }
}
