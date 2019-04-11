package by.iba.ML.core;

import by.iba.ML.util.Arrays;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class DecisionTree {

    private String[][] x = new String[][]{
            {"q", "w", "e", "r"},
            {"q", "r", "e", "r"},
            {"q", "q", "e", "r"}
    };

    public double entropy(Object[] values) {
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


    private <T> Map<T, Integer[]> partition(T[] array) {
        HashMap<T, Integer[]> set = new HashMap<>();
        for (Object element : Arrays.unique(array)) {
            set.put((T) element, Arrays.nonezero(Arrays.arrayEquality(array, element))[0]);
        }
        return set;
    }


    public double mutualInformation(Integer[] y, Integer[] x) {

        double result = entropy(y);


    }

}
