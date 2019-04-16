package by.iba.ML.common;

import java.util.Arrays;
import java.util.Map;

public class TreeNode<T> {

    private Map<String, TreeNode> map;

    private T[] values;


    public TreeNode() {
    }

    public TreeNode(Map<String, TreeNode> map) {
        this.map = map;
    }

    public TreeNode(Map<String, TreeNode> map, T[] values) {
        this.map = map;
        this.values = values;
    }

    public Map<String, TreeNode> getMap() {
        return map;
    }

    public void setMap(Map<String, TreeNode> map) {
        this.map = map;
    }

    public T[] getValues() {
        return values;
    }

    public void setValues(T[] values) {
        this.values = values;
    }
}
