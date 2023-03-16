package trainings;


import java.util.Map;
import java.util.TreeMap;

class Key implements Comparable<Key>{

    private String key;

    public Key(String key){
        super();
        this.key = key;
    }

    public String printKey(){
        return this.key;
    }

    @Override
    public int compareTo(Key o) {
        return key.compareTo(o.key);
    }
}
public class TreeMapDemo {
    public static void main(String[] args){

        Map<Key,String> map = new TreeMap<>();
        map.put(new Key("key1"),"Hari");
        map.put(new Key("key5"),"Prasanth");
        map.put(new Key("key2"),"HP");
        map.put(new Key("key4"),"HP1");

        for(Map.Entry<Key,String> entry : map.entrySet()){
            System.out.println(entry.getKey().printKey() + "----"+ entry.getValue());
        }
    }
}
