import java.util.List;
import java.util.ArrayList;
/**
 * HashTable Implememtnation
 * @author Zhengkai Zhang
 */

public class HashTable {

    public class Entry {
        private String key;
        private int value;
    
        public Entry(String key, int value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public boolean equals(Object input) {
            if (input == this) {
                return true;
            }
            if (!(input instanceof Entry)) {
                return false;
            }
            Entry temp = (Entry) input;
            return key.equals(temp.key);
        }
        @Override
        public String toString() {
            return "[" + key + ":" + Integer.toString(value) + "]";
        }
    }

    private List<List<Entry>> table;
    private int size;
    private int DEFAULT_SIZE = 10;
    
    public HashTable(int size) {
        if (size < 0) {
            throw new IllegalArgumentException();
        }
        table = new ArrayList<List<Entry>>();
        for (int i = 0; i < size; i++) {
            table.add(new ArrayList<Entry>());
        }
        this.size = size;
    }

    public HashTable() {
        table = new ArrayList<List<Entry>>(DEFAULT_SIZE);
        size = DEFAULT_SIZE;
        for (int i = 0; i < size; i++) {
            table.add(new ArrayList<Entry>());
        }
    }
    
    public int hash(String key) {
        double hashCode = 0;
        for (int i = 0; i < key.length(); i++) {
            hashCode = (hashCode * 31 + key.charAt(i)) % size;
        }

        return (int) hashCode;
    }

    public void put(String key, int value) {
        if (key == null) {
            throw new IllegalArgumentException();
        }
        Entry newEntry = new Entry(key, value);
        int hashCode = hash(key);
        if (table.get(hashCode) == null) {
            table.set(hashCode, new ArrayList<Entry>());
            table.get(hashCode).add(newEntry);
            return;
        }
        List<Entry> list = table.get(hashCode);
        for (Entry e : list) {
            if (e.equals(newEntry)) {
                e.value = value;
                return;
            }
        }
        table.get(hashCode).add(newEntry);
    }
    
    public int get(String key) {
        if (key == null) {
            throw new IllegalArgumentException();
        }
        int hashCode = hash(key);
        List<Entry> list = table.get(hashCode);
        if (list == null) {
            return -1;
        }
        for (Entry e : list) {
            if (key.equals(e.key)) {
                return e.value;
            }
        }
        return -1;
    }

    public boolean remove(String key) {
        if (key == null) {
            throw new IllegalArgumentException();
        }
        int hashCode = hash(key);
        List<Entry> list = table.get(hashCode);
        if (list == null) {
            return false;
        }
        for (Entry e : list) {
            if (key.equals(e.key)) {
                list.remove(e);
                return true;
            }
        }
        
        return false;
    }
    
    @Override
    public String toString() {
        int size = table.size();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size; i++) {
            sb.append(i);
            sb.append(": {");
            List<Entry> list = table.get(i);
            if (list == null) {
                sb.append("}\n");
                continue;
            }
            for (Entry e : table.get(i)) {
                sb.append(e.toString());
                sb.append(" ");
            }
            sb.append("}\n");
        }

        return sb.toString();
    
    }

    public static void main(String[] args) {
        HashTable ht = new HashTable(9);
        ht.put("a", 1);
        ht.put("aa", 1);
        ht.put("a", 2);
        ht.remove("a");
        System.out.println(ht.get("aa"));
        System.out.println(ht);
    }
}
