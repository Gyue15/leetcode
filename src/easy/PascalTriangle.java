package easy;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class PascalTriangle {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            List<Integer> list = new ArrayList<>(i + 1);
            res.add(list);
            for (int j = 0; j < i + 1; j++) {
                if (j == 0 || j == i) {
                    list.add(1);
                } else {
                    list.add(res.get(i - 1).get(j - 1) + res.get(i - 1).get(j));
                }
            }
        }
        return res;
    }

    public List<Integer> getRow(int rowIndex) {
        int row = rowIndex + 1;
        List<Integer> res = new ArrayList<>(row);
        int pre;
        for (int i = 0; i < row; i++) {
            pre = 1;
            for (int j = 0; j < i + 1; j++) {
                if (j == 0 || j == i) {
                    if (j >= res.size()) {
                        res.add(1);
                    } else {
                        res.set(j, 1);
                    }
                } else {
                    int element = res.get(j) + pre;
                    pre = res.get(j);
                    res.set(j, element);
                }
            }
        }
        return res;
    }
}
