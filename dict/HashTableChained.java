/* HashTableChained.java */

package dict;

import list.*;

/**
 * HashTableChained implements a Dictionary as a hash table with chaining.
 * All objects used as keys must have a valid hashCode() method, which is
 * used to determine which bucket of the hash table an entry is stored in.
 * Each object's hashCode() is presumed to return an int between
 * Integer.MIN_VALUE and Integer.MAX_VALUE. 
 **/

public class HashTableChained<K, V> implements Dictionary<K, V> {

  /**
   * @param  table the hash table built with a Linked List implementation
   * @param  tableSize number of buckets in the table
   * @param  size number of entries in the table
   */
  private List<Entry <K, V>>[] table;
  private int tableSize;
  private int size;

  /** 
   * Constructs a new empty hash table intended to hold roughly sizeEstimate
   * entries.
   */
  public HashTableChained(int sizeEstimate) {
    tableSize = sizeEstimate * 5 / 3;
    while (!isPrime(tableSize)) {
      tableSize ++;
    }
    table = new DList[tableSize];
    for (int i = 0; i < tableSize; i++) {
      table[i] = new DList<Entry<K, V>>();
    }
    size = 0;
  }

  /** 
   * Constructs a new empty hash table with a default size (101)
   */
  public HashTableChained() {
    tableSize = 101;
    table = new DList[tableSize];
    for (int i = 0; i < tableSize; i++) {
      table[i] = new DList<Entry<K, V>>();
    }
    size = 0;
  }

  /**
   * Converts a hash code in the range Integer.MIN_VALUE...Integer.MAX_VALUE
   * to a value in the range 0...(size of hash table) - 1.
   */
  int compFunction(int code) {
    int value = code % tableSize;
    if (value < 0) {
      return value + tableSize;
    }
    return value;
  }

  /**
   * Tests if the integer parameter is prime.
   * @return true if the parameter is a prime number.
   */
  private boolean isPrime(int n) {
    for (int divisor = 2; divisor < n; divisor++) {
      if (n % divisor == 0) {
        return false;
      }
    }
    return true;
  }

  /** 
   * Returns the number of entries stored in the dictionary.  Entries with
   * the same key (or even the same key and value) each still count as
   * a separate entry.
   * @return number of entries in the dictionary.
   */
  public int size() {
    return size;
  }

  /** 
   * Tests if the dictionary is empty.
   * @return true if the dictionary has no entries; false otherwise.
   **/
  public boolean isEmpty() {
    return (size == 0);
  }

  /**
   * Creates a new Entry object referencing the input key and associated value,
   * and inserts the entry into the dictionary.  Returns a reference to the new
   * entry.  Multiple entries with the same key (or even the same key and
   * value) can coexist in the dictionary.
   * @param key the key by which the entry can be retrieved.
   * @param value an arbitrary object.
   * @return an entry containing the key and value.
   */
  public Entry<K, V> insert(K key, V value) {
    try {
      int hash = key.hashCode();
      Entry<K, V> entry = new Entry<K, V>();
      entry.key = key;
      entry.value = value;
      table[compFunction(hash)].insertFront(entry);
      return entry;
    } catch (Exception e) {
      System.out.println("Unhashable key: " + e);
      return null;
    }
  }

  /** 
   * Searches for an entry with the specified key.  If such an entry is found,
   * returns it; otherwise returns null.  If several entries have the specified
   * key, chooses one arbitrarily and return it.
   * @param key the search key.
   * @return an entry containing the key and an associated value, or null if
   *         no entry contains the specified key.
   */
  public Entry<K, V> find(K key) {
    try {
      int hash = key.hashCode();
      ListNode<Entry<K, V>> node = table[compFunction(hash)].front();
      if (node.isValidNode()) {
        return (Entry<K, V>) node.getItem();
      }
    } catch (Exception e) {
      System.out.println("Unhashable key: " + e);
    }
    return null;
  }

  /** 
   * Removes an entry with the specified key.  If such an entry is found,
   * removes it from the table and return it; otherwise returns null.
   * If several entries have the specified key, chooses one arbitrarily, then
   * removes and returns it.
   * @param key the search key.
   * @return an entry containing the key and an associated value, or null if
   *         no entry contains the specified key.
   */
  public Entry<K, V> remove(K key) {
    try {
      int hash = key.hashCode();
      ListNode<Entry<K, V>> node = table[compFunction(hash)].front();
      if (node.isValidNode()) {
        Entry<K, V> entry = (Entry<K, V>) node.getItem();
        node.remove();
        return entry;
      }
    } catch (Exception e) {
      System.out.println("Unhashable key: " + e);
    }
    return null;
  }

  /**
   * Remove all entries from the dictionary.
   */
  public void makeEmpty() {
    for (int i = 0; i < tableSize; i++) {
      table[i] = new DList<Entry<K, V>>();
    }
  }

  /**
   * Returns a histograph of number of entries in each bucket of the hash table.
   * @return String the representation of the histograph
   */
  public String histograph() {
    int collisions = 0;
    String hist = "[START] Size: " + tableSize + "\n";
    for (int i = 0; i < tableSize; i++) {
      int length = table[i].length();
      hist += i + ": ";
      for (int j = 0; j < length; j++) {
        hist += "*";
      }
      hist += "\n";
      if (length > 1) {
        collisions += (length - 1);
      }
    }
    hist += "[END] Collisions: " + collisions;
    return hist;
  }

  /**
   * Returns the number of collisions in the hash table.
   * @return the number of collisions
   */
  public int numCollisions() {
    int collisions = 0;
    for (int i = 0; i < tableSize; i++) {
      if (table[i].length() > 1) {
        collisions += table[i].length() - 1;
      }
    }
    return collisions;
  }

}
