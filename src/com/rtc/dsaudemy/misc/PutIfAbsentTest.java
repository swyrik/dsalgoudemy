package com.rtc.dsaudemy.misc;

import java.util.HashMap;
import java.util.Map;

public class PutIfAbsentTest {

    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        map.put("A", 9);
        System.out.println(map.putIfAbsent("B", 10));
        System.out.println(map.putIfAbsent("A", 10));
        System.out.println(map);
    }
}
