package leetcode.datastructure;

import java.util.*;

public class RandomizedSet {
    Map<Integer, Integer> map = new HashMap<>();
    List<Integer> list = new ArrayList<>();
    public RandomizedSet() {

    }
    
    public boolean insert(int val) {
        if (!map.containsKey(val)) {
            map.put(val, list.size());
            list.add(val);
            return true;
        }
        return false;
    }
    
    public boolean remove(int val) {
        if (map.containsKey(val)) {
            int eIdx = map.remove(val);
            int lastVal = list.get(list.size() - 1);
            list.set(eIdx, lastVal);
            map.put(lastVal, eIdx);
            list.remove(list.size() - 1);
            map.remove(val);
            return true;
        }
        return false;
    }
    
    public int getRandom() {
        int rand = new Random().nextInt(0, list.size());
        return list.get(rand);
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */