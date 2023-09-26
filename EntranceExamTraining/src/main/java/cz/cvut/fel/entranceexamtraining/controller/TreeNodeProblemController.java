package cz.cvut.fel.entranceexamtraining.controller;

import cz.cvut.fel.entranceexamtraining.model.fractions.FractionProblem;
import cz.cvut.fel.entranceexamtraining.model.fractions.FractionProblemDTO;
import cz.cvut.fel.entranceexamtraining.model.wordProblem.TreeNodeProblem;
import cz.cvut.fel.entranceexamtraining.model.wordProblem.TreeNodeProblemDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tree")
@CrossOrigin
public class TreeNodeProblemController {

    private static final Logger log = LoggerFactory.getLogger(TreeNodeProblemController.class);

    @GetMapping(value = "/problem",produces = MediaType.APPLICATION_JSON_VALUE)
    public TreeNodeProblemDTO getTreeNodeProblem(){
        TreeNodeProblem problem = TreeNodeProblem.generateRandom();
        log.info(problem.toString());
        return treeNodeProblemToDTO(problem);
    }

    private TreeNodeProblemDTO treeNodeProblemToDTO(TreeNodeProblem treeNodeProblem){
        return new TreeNodeProblemDTO(
                treeNodeProblem.getFullText(),
                treeNodeProblem.getQ1(),
                treeNodeProblem.getQ2(),
                treeNodeProblem.getQ3(),
                treeNodeProblem.getQ1Result(),
                treeNodeProblem.getQ2Result(),
                treeNodeProblem.getQ3Result()
                );
    }
}
