package cz.cvut.fel.entranceexamtraining.model;

import org.apache.commons.lang3.tuple.Pair;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SimultaneousLinearEquationSolverTest {

    @Test
    void solveTest() {
        Pair<Integer, Integer> result = SimultaneousLinearEquationSolver.solve(1,-1,8,1,1,28);

        assertEquals(18, result.getLeft());
        assertEquals(10, result.getRight());
    }

    @Test
    void solveTest2() {
        Pair<Integer, Integer> result = SimultaneousLinearEquationSolver.solve(1,-1,30,-3,5,0);

        assertEquals(75, result.getLeft());
        assertEquals(45, result.getRight());
    }

    @Test
    void solveTest3() {
        Pair<Integer, Integer> result = SimultaneousLinearEquationSolver.solve(7,3,1,1,-1,3);

        assertEquals(1, result.getLeft());
        assertEquals(-2, result.getRight());
    }
}