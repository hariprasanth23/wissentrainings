package linkedhashmap.custom.MultiValuedMap;

import java.util.*;

class MultiMap<K, V>
{
    private Map<K, Collection<V>> map = new HashMap<>();

    public void put(K key, V value)
    {
        if (map.get(key) == null) {
            map.put(key, new ArrayList<V>());
        }
        map.get(key).add(value);
    }

    public void putIfAbsent(K key, V value)
    {
        if (map.get(key) == null) {
            map.put(key, new ArrayList<>());
        }

        if (!map.get(key).contains(value)) {
            map.get(key).add(value);
        }
    }

    public Collection<V> get(Object key) {
        return map.get(key);
    }

    public Set<K> keySet() {
        return map.keySet();
    }

    public Set<Map.Entry<K, Collection<V>>> entrySet() {
        return map.entrySet();
    }

    public Collection<Collection<V>> values() {
        return map.values();
    }

    public boolean containsKey(Object key) {
        return map.containsKey(key);
    }

    public Collection<V> remove(Object key) {
        return map.remove(key);
    }

    public boolean isEmpty() {
        return map.isEmpty();
    }

    public void clear() {
        map.clear();
    }

    public boolean remove(K key, V value)
    {
        if (map.get(key) != null)
            return map.get(key).remove(value);

        return false;
    }


    public boolean replace(K key, V oldValue, V newValue)
    {
        if (map.get(key) != null)
        {
            if (map.get(key).remove(oldValue)) {
                return map.get(key).add(newValue);
            }
        }
        return false;
    }
}

public class MultivalueMapDemo
{
    public static void main(String[] args)
    {
        MultiMap<String, String> multimap = new MultiMap();

        multimap.put("GS 1", "HP");
        multimap.put("MS 1", "Hari");
        multimap.put("MS 1", "Prasanth");
        multimap.put("MS 1", "HP");

        for (String lastName: multimap.keySet()) {
            System.out.println(lastName + ": " + multimap.get(lastName));
        }


    }
}
