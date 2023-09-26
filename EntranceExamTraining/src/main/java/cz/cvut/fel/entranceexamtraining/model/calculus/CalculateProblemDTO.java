package cz.cvut.fel.entranceexamtraining.model.calculus;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class CalculateProblemDTO {
    private int solution;
    private String problem;
}
