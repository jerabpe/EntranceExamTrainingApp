package cz.cvut.fel.entranceexamtraining.model.wordProblem;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class TreeNodeProblemDTO {
    private String fullText;

    private String Q1;
    private String Q2;
    private String Q3;

    private int Q1Result;
    private int Q2Result;
    private int Q3Result;
}
