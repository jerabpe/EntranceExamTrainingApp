package cz.cvut.fel.entranceexamtraining.controller;

import cz.cvut.fel.entranceexamtraining.model.fractions.FractionProblem;
import cz.cvut.fel.entranceexamtraining.model.fractions.FractionProblemDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/fraction")
@CrossOrigin
public class FractionController {

    private static final Logger log = LoggerFactory.getLogger(FractionController.class);

    @GetMapping(value = "/problem",produces = MediaType.APPLICATION_JSON_VALUE)
    public FractionProblemDTO getFractionProblem(){
        FractionProblem problem = FractionProblem.generateRandom(4,100);
        log.info(problem.toString());
        return fractionProblemToDTO(problem);
    }

    private FractionProblemDTO fractionProblemToDTO(FractionProblem problem){
        List<String> fractions = new ArrayList<>();
        problem.getOperands().forEach(o -> fractions.add(o.toString()));
        List<String> operators = new ArrayList<>();
        problem.getOperators().forEach(o -> operators.add(o.getSymbol()));
        return new FractionProblemDTO(
                fractions,
                operators,
                problem.getSolution().toString()
        );
    }

}
