package cz.cvut.fel.entranceexamtraining.model.wordProblem;

import lombok.*;

import java.util.Random;

@Getter
@Setter
@AllArgsConstructor
@ToString
@NoArgsConstructor
public class TreeNodeProblem {

    //max 4 levels
    private int level1Nodes;
    private int level2Nodes;
    private int level3Nodes;
    private String fullText;

    private int Q1Result;
    private int Q2Result;
    private int Q3Result;

    private String text1 = "V rotě je jeden kapitán a má pod sebou ";
    private String text2 = "Každý poručík má pod sebou ";
    private String text3 = "a každý četař má pod sebou ";
    private String text4 = "Kapitán se rozhodl svolat celou rotu k nástupu. " +
            "Rozkaz k nástupu se předával tak, že kapitán vydal rozkaz všem poručíkům, " +
            "z nichž každý vydal tento rozkaz svým četařům a každý četař jej vydal svým vojínům. Poté celá rota nastoupila.";

    private String Q1 = "Kolik je v rotě vojínů?";
    private String Q2 = "Kolik osob v rotě vydalo rozkaz k nástupu?";
    private String Q3 = "Kolik osob v rotě dostalo rozkaz k nástupu?";

    public static TreeNodeProblem generateRandom(){
        Random r = new Random();

        TreeNodeProblem problem = new TreeNodeProblem();

        problem.setLevel1Nodes(r.nextInt(3) + 2); // 2-5
        problem.setLevel2Nodes(r.nextInt(3) + 2); //2-5
        problem.setLevel3Nodes(r.nextInt(10) + 5); //5-15

        problem.setQ1Result(problem.getLevel1Nodes() * problem.getLevel2Nodes() * problem.getLevel3Nodes());
        problem.setQ2Result(1 + problem.getLevel1Nodes() + problem.getLevel1Nodes()* problem.getLevel2Nodes());
        problem.setQ3Result(problem.getLevel1Nodes() + problem.getLevel1Nodes()*problem.getLevel2Nodes() + problem.getLevel1Nodes()*problem.getLevel2Nodes()* problem.getLevel3Nodes());

        problem.setFullText(problem.text1 + l1(problem.getLevel1Nodes())
                            + problem.text2 + l2(problem.getLevel2Nodes())
                            + problem.text3 + l3(problem.getLevel3Nodes())
                            + problem.text4);

        return problem;
    }

    private static String l1(int num){
        if(num <= 4){
            return num+" poručíky. ";
        } else {
            return num+" poručíků. ";
        }
    }

    private static String l2(int num){
        if(num <= 4){
            return num+" četaře. ";
        } else {
            return num+" četařů. ";
        }
    }

    private static String l3(int num){
        if(num <= 4){
            return num+" vojíny. ";
        } else {
            return num+" vojínů. ";
        }
    }

}
