package cz.cvut.fel.entranceexamtraining.model.fractions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class FractionProblemDTO {
    private List<String> fractions;
    private List<String> operators;
    private String solution;
}
