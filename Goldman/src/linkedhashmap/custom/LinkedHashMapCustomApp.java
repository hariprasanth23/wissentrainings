package linkedhashmap.custom;



class LinkedHashMapCustom<K, V> {

    private Entry<K,V>[] table;
    private int capacity= 4;
    private Entry<K,V> header;
    private Entry<K,V> last;
    static class Entry<K, V> {
        K key;
        V value;
        Entry<K,V> next;
        Entry<K,V> before,after;
        public Entry(K key, V value, Entry<K,V> next){
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }

    public LinkedHashMapCustom(){
        table = new Entry[capacity];
    }

    public void put(K newKey, V data){
        if(newKey==null)
            return;
        int hash=hash(newKey);
        Entry<K,V> newEntry = new Entry<K,V>(newKey, data, null);
        maintainOrderAfterInsert(newEntry);
        if(table[hash] == null){
            table[hash] = newEntry;
        }else{
            Entry<K,V> previous = null;
            Entry<K,V> current = table[hash];
            while(current != null){
                if(current.key.equals(newKey)){
                    if(previous==null){
                        newEntry.next=current.next;
                        table[hash]=newEntry;
                        return;
                    }
                    else{
                        newEntry.next=current.next;
                        previous.next=newEntry;
                        return;
                    }
                }
                previous=current;
                current = current.next;
            }
            previous.next = newEntry;
        }
    }


    private void maintainOrderAfterInsert(Entry<K, V> newEntry) {
        if(header==null){
            header=newEntry;
            last=newEntry;
            return;
        }
        if(header.key.equals(newEntry.key)){
            deleteFirst();
            insertFirst(newEntry);
            return;
        }
        if(last.key.equals(newEntry.key)){
            deleteLast();
            insertLast(newEntry);
            return;
        }
        Entry<K, V> beforeDeleteEntry = deleteSpecificEntry(newEntry);
        if(beforeDeleteEntry==null){
            insertLast(newEntry);
        }
        else{
            insertAfter(beforeDeleteEntry,newEntry);
        }
    }

    private void maintainOrderAfterDeletion(Entry<K, V> deleteEntry) {
        if(header.key.equals(deleteEntry.key)){
            deleteFirst();
            return;
        }
        if(last.key.equals(deleteEntry.key)){
            deleteLast();
            return;
        }
        deleteSpecificEntry(deleteEntry);
    }

    private void insertAfter(Entry<K, V> beforeDeleteEntry, Entry<K, V> newEntry) {
        Entry<K, V> current=header;
        while(current!=beforeDeleteEntry){
            current=current.after;
        }
        newEntry.after=beforeDeleteEntry.after;
        beforeDeleteEntry.after.before=newEntry;
        newEntry.before=beforeDeleteEntry;
        beforeDeleteEntry.after=newEntry;
    }


    private void deleteFirst(){
        if(header==last){
            header=last=null;
            return;
        }
        header=header.after;
        header.before=null;
    }

    private void insertFirst(Entry<K, V> newEntry){
        if(header==null){
            header=newEntry;
            last=newEntry;
            return;
        }
        newEntry.after=header;
        header.before=newEntry;
        header=newEntry;
    }

    private void insertLast(Entry<K, V> newEntry){
        if(header==null){
            header=newEntry;
            last=newEntry;
            return;
        }
        last.after=newEntry;
        newEntry.before=last;
        last=newEntry;
    }

    private void deleteLast(){
        if(header==last){
            header=last=null;
            return;
        }
        last=last.before;
        last.after=null;
    }

    private Entry<K, V> deleteSpecificEntry(Entry<K, V> newEntry){
        Entry<K, V> current=header;
        while(!current.key.equals(newEntry.key)){
            if(current.after==null){
                return null;
            }
            current=current.after;
        }
        Entry<K, V> beforeDeleteEntry=current.before;
        current.before.after=current.after;
        current.after.before=current.before;
        return beforeDeleteEntry;
    }

    public V get(K key){
        int hash = hash(key);
        if(table[hash] == null){
            return null;
        }else{
            Entry<K,V> temp = table[hash];
            while(temp!= null){
                if(temp.key.equals(key))
                    return temp.value;
                temp = temp.next;
            }
            return null;
        }
    }


    public boolean remove(K deleteKey){
        int hash=hash(deleteKey);
        if(table[hash] == null){
            return false;
        }else{
            Entry<K,V> previous = null;
            Entry<K,V> current = table[hash];
            while(current != null){
                if(current.key.equals(deleteKey)){
                    maintainOrderAfterDeletion(current);
                    if(previous==null){
                        table[hash]=table[hash].next;
                        return true;
                    }
                    else{
                        previous.next=current.next;
                        return true;
                    }
                }
                previous=current;
                current = current.next;
            }
            return false;
        }
    }


    public void display(){
        Entry<K, V> currentEntry=header;
        while(currentEntry!=null){
            System.out.print("{"+currentEntry.key+"="+currentEntry.value+"}" +" ");
            currentEntry=currentEntry.after;
        }
    }


    private int hash(K key){
        return Math.abs(key.hashCode()) % capacity;
    }

}

public class LinkedHashMapCustomApp {

    public static void main(String[] args) {
        LinkedHashMapCustom<Integer, Integer> linkedHashMapCustom = new LinkedHashMapCustom<>();

        linkedHashMapCustom.put(21, 12);
        linkedHashMapCustom.put(25, 121);
        linkedHashMapCustom.put(30, 151);
        linkedHashMapCustom.put(33, 15);
        linkedHashMapCustom.put(35, 89);

        System.out.println("Display values corresponding to keys>");
        System.out.println("value corresponding to key 21="+ linkedHashMapCustom.get(21));
        System.out.println("value corresponding to key 51="+ linkedHashMapCustom.get(51));

        System.out.print("Displaying : ");
        linkedHashMapCustom.display();

        System.out.println("\n\nvalue corresponding to key 21 removed: "+ linkedHashMapCustom.remove(21));
        System.out.println("value corresponding to key 22 removed: "+ linkedHashMapCustom.remove(22));

        System.out.print("Displaying : ");
        linkedHashMapCustom.display();






    }
}
