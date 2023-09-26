package cz.cvut.fel.entranceexamtraining.controller;

import cz.cvut.fel.entranceexamtraining.model.calculus.CalculateProblem;
import cz.cvut.fel.entranceexamtraining.model.calculus.CalculateProblemDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/calculate")
@CrossOrigin
public class CalculateProblemController {

    private static final Logger log = LoggerFactory.getLogger(CalculateProblemController.class);

    @GetMapping(value = "/problem",produces = MediaType.APPLICATION_JSON_VALUE)
    public CalculateProblemDTO getCalculateProblem(){
        return calculateProblemToDTO(CalculateProblem.generateRandom());
    }

    private CalculateProblemDTO calculateProblemToDTO(CalculateProblem problem){
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<problem.getOperands().size(); i++){
            sb.append(problem.getOperands().get(i)).append(" ");
            if(i<problem.getOperators().size()){
                sb.append(problem.getOperators().get(i).getSymbol()).append(" ");
            } else {
                sb.append("= ");
            }
        }
        return new CalculateProblemDTO(problem.getSolution(), sb.toString());
    }
}
