package by.iba.ML.core;

import by.iba.ML.common.TreeNode;
import by.iba.ML.util.Arrays;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class DecisionTree<T> {


    private double entropy(Object[] values) {
        double result = 0;

        Collection<Integer> countsUnique = Arrays.unique(values, true).values();
        for (Integer counts : countsUnique) {

            double freq = (double) counts / (double) values.length;
            if (freq != 0.0) {
                result -= freq * (Math.log(freq) / Math.log(2));
            }
        }
        return result;
    }

    //return map{ 'unique element' : array {nonzero[0] }}
    //nonzero[0] - index i element, where element non zero elements
    //nonzero[1] - j elements, where element non zero elements
    private <T> Map<T, Integer[]> partition(T[] array) {
        HashMap<T, Integer[]> hashMap = new HashMap<>();
        for (Object element : Arrays.unique(array)) {
            hashMap.put((T) element, Arrays.nonzero(Arrays.arrayEquality(array, element))[1]);
        }
        return hashMap;
    }

    //return value (result = entropy(y) - (count unique value/ x.length)* entropy(truth elements)-.......... )
    private double mutualInformation(Integer[] y, Integer[] x) {

        double result = entropy(y);
        Map<Object, Integer> map = Arrays.unique(x, true);

        for (Map.Entry<Object, Integer> entry : map.entrySet()) {
            result -= ((double) entry.getValue() / (double) x.length) *
                    entropy(Arrays.getTruthElements(y, Arrays.arrayEquality(x, entry.getKey())));
        }

        return result;
    }

    public TreeNode recursiveSplite(Integer[][] x, Integer[] y, TreeNode<T> node) {

        if (Arrays.isPure(y) || y.length == 0) {
            node.setValues((T[]) y);
            return node;
        }

        Double gain[] = countGain(y, x);
        int selectedAttr = Arrays.getMaxElementIndex(gain);
        Map<Object, Integer[]> partition = partition(Arrays.getColumn(x, selectedAttr, Integer.class));

        Map<String, TreeNode> map = new TreeMap<>();
        for (Map.Entry<Object, Integer[]> entry : partition.entrySet()) {
            Integer[][] xSubset = Arrays.take(x, entry.getValue());
            Integer[] ySubset = Arrays.take(y, entry.getValue());

            TreeNode treeNode = new TreeNode();
            map.put("x_" + selectedAttr + "=" + entry.getKey(), treeNode);
            node.setMap(map);
            recursiveSplite(xSubset, ySubset, treeNode);
        }
        return node;
    }

    private Double[] countGain(Integer[] y, Integer[][] x) {

        Double[] gain = new Double[x[0].length];
        x = Arrays.transposition(x, Integer.class);
        for (int i = 0; i < x.length; i++) {
            gain[i] = mutualInformation(y, x[i]);
        }

        return gain;
    }

}
