/**
 * HashTable Interface
 * @author Zhengkai Zhang
 */

public interface HashTableInterface {
    /**
     * add to the map.
     */
    void put(String key, int value);
    /**
     * get the value from map return -1 if not exits.
     */
    int get(String key);
    /**
     * Remove the key value pair
     */
    boolean remove(String key);
}
