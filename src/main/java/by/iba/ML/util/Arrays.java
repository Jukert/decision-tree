package by.iba.ML.util;

import java.util.*;

public class Arrays {

    public static <T> Integer[][] nonezero(T[][] array) {
        List<List<Integer>> listResult = new ArrayList<>();
        listResult.add(new ArrayList<>());
        listResult.add(new ArrayList<>());
        int i = 0;
        for (T[] row : array) {
            int j = 0;
            for (T element : row) {
                if (element.equals(0)) {
                    j++;
                    continue;
                }
                listResult.get(1).add(j);
                listResult.get(0).add(i);
                j++;
            }
            i++;
        }

        Integer[][] result = new Integer[2][listResult.get(0).size()];
        result[0] = listResult.get(0).toArray(new Integer[listResult.get(0).size()]);
        result[1] = listResult.get(1).toArray(new Integer[listResult.get(1).size()]);
        return result;
    }

    public static <T> Integer[][] nonezero(T[] array) {
        List<List<Integer>> listResult = new ArrayList<>();
        listResult.add(new ArrayList<>());
        listResult.add(new ArrayList<>());
        int i = 0;
        for (T element : array) {
            if (element.equals(0)) {
                i++;
                continue;
            }
            listResult.get(0).add(0);
            listResult.get(1).add(i);
            i++;
        }

        Integer[][] result = new Integer[2][listResult.get(0).size()];
        result[1] = listResult.get(1).toArray(new Integer[listResult.get(1).size()]);
        result[0] = listResult.get(0).toArray(new Integer[listResult.get(0).size()]);
        return result;
    }


    public static <T> Object[] unique(T[][] array) {
        Set<T> arraySet = new HashSet<>();
        for (T[] row : array) {
            for (T el : row) {
                arraySet.add(el);
            }
        }
        return arraySet.toArray();
    }

    public static <T> Object[] unique(T[] array) {
        Set<T> arraySet = new HashSet<>();
        for (T el : array) {
            arraySet.add(el);
        }
        return arraySet.toArray();
    }

    public static <T> Map<T, Integer> unique(T[] array, boolean returnCounts) {
        Map<T, Integer> map = new HashMap<>();

        for (T element : array) {
            Object currentValue = map.get(element);
            if (currentValue != null) {
                map.replace(element, ((Integer) currentValue) + 1);
                continue;
            }
            map.put(element, 1);
        }

        return map;
    }

    public static <T> Integer[][] arrayEquality(T[][] array, T element) {

        Integer[][] truthTable = new Integer[array.length][array[0].length];

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                if (array[i][j].equals(element)) {
                    truthTable[i][j] = 1;
                    continue;
                }
                truthTable[i][j] = 0;
            }
        }
        return truthTable;
    }

    public static <T> Integer[] arrayEquality(T[] array, T element) {

        Integer[] truthTable = new Integer[array.length];

        for (int i = 0; i < array.length; i++) {
            if (array[i].equals(element)) {
                truthTable[i] = 1;
                continue;
            }
            truthTable[i] = 0;
        }
        return truthTable;
    }
}
