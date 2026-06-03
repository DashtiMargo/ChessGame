package com.example.bookmarket.bb;

import java.util.*;

public class Bankomat {
    public static void main(String[] args) {
        Map<Integer,Integer> map = new TreeMap<>(Comparator.reverseOrder());
        map.put(1000,34);
        map.put(500,46);
        map.put(100,235);
        map.put(50,58);
        map.put(5,600);
        System.out.println(Bankomat.sum(map,6350));
    }
    //6350
    private static List<Integer> sum(Map<Integer,Integer> map, int sum){
        List<Integer> list = new ArrayList<>();
        int currentSum = 0;
        for(Map.Entry<Integer,Integer> entry : map.entrySet()){
            int value = entry.getValue();
            int key = entry.getKey();

            while (value > 0 && currentSum + key <= sum){
                list.add(key);
                currentSum += key;
                value--;
            }
        }
        return list;
    }
}
