package io.hank.leetcode.practices.hash;

import io.hank.leetcode.annotations.Topic;
import io.hank.leetcode.annotations.TopicType;
import io.hank.leetcode.practices.LeetcodeProblemSolution;

import java.util.*;

public class _380_Insert_Delete_Getrandom_O1 extends LeetcodeProblemSolution {

    @Override
    @Topic(TopicType.HASH)
    public void execute() {
        super.execute();
        RandomizedSet randomizedSet = new RandomizedSet();
        System.out.println(randomizedSet.insert(1));
        System.out.println(randomizedSet.remove(2));
        System.out.println(randomizedSet.insert(2));
        System.out.println(randomizedSet.getRandom());
    }
}

class RandomizedSet {
    List<Integer> values;
    Map<Integer, Integer> indexMap; // { value: index }
    Random randomIndex;

    public RandomizedSet() {
        values = new ArrayList<>();
        indexMap = new HashMap<>();
        randomIndex = new Random();
    }

    public boolean insert(int val) {
        if (indexMap.containsKey(val)) {
            return false;
        }
        values.add(val);
        indexMap.put(val, values.size() - 1);
        return true;
    }

    public boolean remove(int val) {
        if (!indexMap.containsKey(val)) {
            return false;
        }
        int index = indexMap.get(val);
        int lastVal = values.getLast(); // move last element to removed index
        values.set(index, lastVal);
        values.removeLast();
        indexMap.put(lastVal, index);
        indexMap.remove(val); // delete in map, do this step last in case that remove last one element
        return true;
    }

    public int getRandom() {
        return values.get(randomIndex.nextInt(values.size()));
    }
}