package leetcode;

import java.util.ArrayList;
import java.util.List;
/*
40 Combination Sum 2
 */
public class CombinationSum2 {
    int[] candidates;
    int target;
    List<List<Integer>> mList = new ArrayList<>();

    public static void main(String[] args) {
        int[] arr = {2, 3, 5};
        int tar = 8;
        CombinationSum2 combinationSum2 = new CombinationSum2();
        combinationSum2.combinationSum2(arr, tar);
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        this.candidates = candidates;
        this.target = target;
        find(new ArrayList<>(), target);
        //System.out.println(mList);
        return mList;
    }

    public void find(List<Integer> list, int num) {
        //遍历递归
        for (int candidate : candidates) {
            //如果这次选的数比前面已经选了的数还要小，那么直接跳过
            //这样等于剪枝工作，去掉可能重复的list
            if (!list.isEmpty() && candidate < list.get(list.size() - 1)) {
                continue;
            }
            List<Integer> list1 = new ArrayList<>(list);
            list1.add(candidate);
            int res = num - candidate;
            //res为0，代表list1中所有数的和等于target
            //res小于0，则代表这条递归路径行不通
            if (res == 0) {
                mList.add(list1);
            } else if (res > 0) {
                find(list1, res);
            }
        }
    }
}
