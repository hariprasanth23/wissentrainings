package linkedhashmap.custom.lru;

import java.util.LinkedHashMap;

public class lrudemo {

    private LinkedHashMap<Integer, Integer> map;
    private int SIZE;
    public lrudemo(int capacity) {
        map = new LinkedHashMap<>();
        SIZE = capacity;
    }

    public int get(int key) {
        if(map.containsKey(key)) {
            int value = map.remove(key);
            map.put(key, value);
            return value;
        }
        return -1;
    }

    public void put(int key, int value) {
        if(map.containsKey(key)) {
            map.remove(key);
        }else if(map.size() + 1 > SIZE) {
            map.remove(map.keySet().iterator().next());
        }
        map.put(key, value);
    }

    public static void main(String[] args){

        lrudemo lrudemo = new lrudemo(3);
        lrudemo.put(1,100);
        lrudemo.put(2,200);
        lrudemo.put(3,300);
        lrudemo.put(1,400);

        System.out.println(lrudemo.get(1));


    }

}
