package com.atguigu.landlord;


import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class PokerUtils {
    int[] pokers;
    int[] checkPokers = new int[5];
    Map<Integer, Integer> map = new HashMap<>();

    public PokerUtils(int[] pokers) {
        this.pokers = pokers;
    }

    void get3With2(int n, int pokerCheckIndex) {
        if (n >= 5) {
            System.out.println(Arrays.toString(checkPokers));
            map.clear();
            return;
        }
        for (int i = n; i < pokers.length; i++) {
//            System.out.println(i);
            if (pokerCheckIndex >= pokers.length) return;
            checkPokers[n] = pokers[pokerCheckIndex];
            if (judge(n)) {
                get3With2(n + 1, ++pokerCheckIndex);
            }
        }
    }

    boolean judge(int n) {
        for (int i = 0; i <= n; i++) {
            if (map.containsKey(checkPokers[i])) {
                Integer count = map.get(checkPokers[i]);
                count++;
                map.put(checkPokers[i], count);
            } else {
                map.put(checkPokers[i], 1);
            }
        }
        if (map.size() > 2) {
            map.clear();
            return false;
        }
        if (map.size() == 1 && n == 3) {
            map.clear();
            return false;
        }
        map.clear();
        return true;
    }


}
