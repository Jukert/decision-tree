package by.iba.ML.util;

import java.lang.reflect.Array;
import java.util.*;

public class Arrays {

    public static <T> Integer[][] nonzero(T[][] array) {
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

    public static <T> Integer[][] nonzero(T[] array) {
        List<List<Integer>> listResult = new ArrayList<>();
        listResult.add(new ArrayList<>());//index array, having non zero elements
        listResult.add(new ArrayList<>());//index elements in array, having non zero elements
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

    public static <T> T[] getTruthElements(T[] array, T element) {
        Integer[] truthTable = arrayEquality(array, element);

        List<T> result = new ArrayList<>();
        int i = 0;
        for (Integer value : truthTable) {
            if (value == 1) {
                result.add(array[i]);
            }
            i++;
        }
        return (T[]) result.toArray();
    }

    public static <T> T[] getTruthElements(T[] array, Integer[] truthTable) {
        List<T> result = new ArrayList<>();
        int i = 0;
        if (truthTable.length != array.length) {
            throw new RuntimeException("Array length should be equals");
        }
        for (Integer value : truthTable) {
            if (value == 1) {
                result.add(array[i]);
            }
            i++;
        }
        return (T[]) result.toArray();
    }

    public static boolean isPure(Integer[] array) {
        if (array == null) {
            return true;
        }
        Set<Integer> set = new HashSet<>(java.util.Arrays.asList(array));
        return set.size() <= 1;

    }

    public static <T> T[][] transposition(T[][] array, Class<?> clazz) {
        T[][] arrayT = (T[][]) Array.newInstance(clazz, array[0].length, array.length);

        for (int i = 0; i < array[0].length; i++) {
            for (int j = 0; j < array.length; j++) {
                arrayT[i][j] = (T) array[j][i];
            }
        }
        return arrayT;
    }

    public static <T extends Number> int getMaxElementIndex(T[] array) {

        T max = array[0];
        int index = 0;
        for (int i = 0; i < array.length; i++) {
            if ((Double) max < (Double) array[i]) {
                max = array[i];
                index = i;
            }
        }
        return index;
    }

    public static <T> Integer[][] take(T[][] array, Integer[] arraySet) {

        Set<Integer> set = new HashSet<>(java.util.Arrays.asList(arraySet));
        Integer[][] result = new Integer[set.size()][array[0].length];
        for (int i = 0; i < set.size(); i++) {
            Integer[] tempColumn = new Integer[array[0].length];
            for (int j = 0; j < array[0].length; j++) {
                tempColumn[j] = (Integer) array[i][j];
            }
            result[i] = tempColumn;
        }

        return result;
    }

    public static <T> Integer[] take(T[] array, Integer[] set) {

        Integer result[] = new Integer[set.length];

        for (int i = 0; i < set.length; i++) {
            result[i] = (Integer) array[set[i]];
        }

        return result;
    }

    public static <T> T[] getColumn(T[][] array, int index, Class<?> clazz) {
        T[] column = (T[]) Array.newInstance(clazz, array.length);
        int i = 0;
        for (T el[] : array) {
            column[i] = el[index];
            i++;
        }
        return column;
    }
}

