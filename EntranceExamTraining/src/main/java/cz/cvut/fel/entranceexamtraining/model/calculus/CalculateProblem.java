package cz.cvut.fel.entranceexamtraining.model.calculus;

import cz.cvut.fel.entranceexamtraining.model.Operator;
import lombok.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Getter
@Setter
@AllArgsConstructor
@ToString
@NoArgsConstructor
public class CalculateProblem {
    private int solution;
    private List<Integer> operands;
    private List<Operator> operators;


    public static CalculateProblem generateRandom(){
        Random r = new Random();

        CalculateProblem problem = new CalculateProblem();
        problem.operators = List.of(Operator.SUBTRACT, Operator.MULTIPLY, Operator.ADD, Operator.DIVIDE);
        problem.operands = new ArrayList<>();

        int a = r.nextInt(69)+30;
        problem.operands.add(a);
        int b = r.nextInt(8)+1;
        int c = r.nextInt(8)+1;
        while(c*b > problem.operands.get(0)){
            b = r.nextInt(8)+1;
            c = r.nextInt(8)+1;
        }
        problem.operands.add(b);
        problem.operands.add(c);
        int d = r.nextInt(7)+2;
        int e = d * (r.nextInt(7)+2);
        problem.operands.add(e);
        problem.operands.add(d);
        int solution = a - b * c + e/d;
        problem.setSolution(solution);
        return problem;
    }

    /*private static int solve(List<Integer> operands,  List<Operator> operators){
        int tmp = operands.get(0);
        for(int i=1; i<operands.size(); i++){
            switch(operators.get(i-1)){
                case ADD -> tmp += operands.get(i);
                case SUBTRACT -> tmp -= operands.get(i);
                case MULTIPLY -> tmp *= operands.get(i);
                case DIVIDE -> tmp /= operands.get(i);
            }
        }
        return tmp;
    }*/

}
