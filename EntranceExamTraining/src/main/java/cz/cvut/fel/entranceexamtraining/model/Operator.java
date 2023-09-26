package cz.cvut.fel.entranceexamtraining.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Random;

@Getter
@AllArgsConstructor
public enum Operator {
    ADD("+"),
    SUBTRACT("-"),
    MULTIPLY("·"),
    DIVIDE(":"); //÷

    private final String symbol;

    public static Operator getRandom(){
        Random r = new Random();
        return values()[r.nextInt(values().length)];
    }
}
