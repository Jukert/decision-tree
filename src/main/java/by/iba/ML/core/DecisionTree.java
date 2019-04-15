package by.iba.ML.core;

import by.iba.ML.util.Arrays;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class DecisionTree {

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


    private <T> Map<T, Integer[]> partition(T[] array) {
        HashMap<T, Integer[]> set = new HashMap<>();
        for (Object element : Arrays.unique(array)) {
            set.put((T) element, Arrays.nonezero(Arrays.arrayEquality(array, element))[0]);
        }
        return set;
    }


    private double mutualInformation(Integer[] y, Integer[] x) {

        double result = entropy(y);
        Map<Object, Integer> map = Arrays.unique(x, true);

        for (Map.Entry<Object, Integer> entry : map.entrySet()) {
            result -= ((double) entry.getValue() / (double) x.length) *
                    entropy(Arrays.getTruthElements(y, Arrays.arrayEquality(x, entry.getKey())));
        }

        return result;
    }

    public Integer[] recusiveSplite(Integer[] x, Integer[] y) {

        if (Arrays.isPure(y) || y.length == 0) {
            return y;
        }

        return null;
    }

    private Double[] countGain(Integer[] y, Integer[][] transpX) {

        Double[] gain = new Double[transpX.length];

        for (int i = 0; i < transpX.length; i++) {
            gain[i] = mutualInformation(y, transpX[i]);
        }

        return gain;
    }

}
