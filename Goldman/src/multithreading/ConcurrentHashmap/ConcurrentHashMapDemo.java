package multithreading.ConcurrentHashmap;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

class MapHelper1 implements Runnable {
    Map<String, Integer> map;

    public MapHelper1(Map<String, Integer> map) {
        this.map = map;
        new Thread(this, "MapHelper1").start();
    }

    public void run() {
        map.put("One", 1);
        try {
            System.out.println("MapHelper1 sleeping");
            Thread.sleep(100);
        } catch (Exception e) {
            System.out.println(e);
        }

    }
}

class MapHelper2 implements Runnable {
    Map<String, Integer> map;

    public MapHelper2(Map<String, Integer> map) {
        this.map = map;
        new Thread(this, "MapHelper2").start();
    }

    public void run() {
        map.put("two", 2);
        try {
            System.out.println("MapHelper1 sleeping");
            Thread.sleep(100);
        } catch (Exception e) {
            System.out.println(e);
        }

    }
}

public class ConcurrentHashMapDemo {
    public static void main(String[] args) {
        Map<String, Integer> hashMap = new HashMap<>();
        Map<String, Integer> syncMap = new ConcurrentHashMap<>();
        MapHelper1 mapHelper1 = new MapHelper1(syncMap);
        MapHelper2 mapHelper2 = new MapHelper2(syncMap);

        for (Map.Entry<String, Integer> e : syncMap.entrySet()) {
            System.out.println(e.getKey() + "=" + e.getValue());
        }

    }
}
//t1-->key  1 --> value 1
//t2-->key  1 --> value 2
//t3-->key  1 --> value 3
//t4-->key  1 --> value 4


//t5-->key  1 --> get(key 1)
