package by.iba.ML;

import by.iba.ML.core.DecisionTree;

public class Application {
    public static void main(String[] args) {

        DecisionTree tree = new DecisionTree();
        double a = tree.entropy(new String[]{"q", "w", "q"});
        System.out.println(a);

        String[][] x = new String[][] {
                {"q", "w", "e", "r"},
                {"q", "r", "e", "r"},
                {"q", "q", "e", "r"}
        };

    }
}
