package by.iba.ML;

import by.iba.ML.common.TreeNode;
import by.iba.ML.core.DecisionTree;
import by.iba.ML.util.Arrays;

public class Application {
    public static void main(String[] args) {

        DecisionTree tree = new DecisionTree();
        Integer[] x1 = new Integer[] {0, 1, 1, 2, 2, 2};
        Integer[] x2 = new Integer[] {0, 0, 1, 1, 1, 0};
        Integer[] y = new Integer[] {0, 0, 0, 1, 1, 0};
        Integer[][] X = new Integer[][]{x1, x2};

        //double a = tree.mutualInformation(y, x1);
        //System.out.println(a);

        String[][] x = new String[][] {
                {"q11", "w12", "e13", "r14"},
                {"q21", "r22", "e23", "r24"},
                {"q31", "q32", "e33", "r34"}
        };

        TreeNode treeNode = new TreeNode();
        tree.recursiveSplite(Arrays.transposition(X, Integer.class), y, treeNode);
        System.out.println();
    }
}
