/* Dictionary.java */

package dict;

/**
 *  An interface for (unordered) dictionary ADTs.
 */

public interface Dictionary<K, V> {

  /** 
   * Returns the number of entries stored in the dictionary.  Entries with
   * the same key (or even the same key and value) each still count as
   * a separate entry.
   * @return number of entries in the dictionary.
   */
  public int size(); 

  /** 
   * Tests if the dictionary is empty.
   * @return true if the dictionary has no entries; false otherwise.
   */
  public boolean isEmpty();

  /** 
   * Creates a new Entry object referencing the input key and associated value,
   * and inserts the entry into the dictionary.  Returns a reference to the new
   * entry.  Multiple entries with the same key (or even the same key and
   * value) can coexist in the dictionary.
   * @param key the key by which the entry can be retrieved.
   * @param value an arbitrary object.
   * @return an entry containing the key and value.
   */
  public Entry<K, V> insert(K key, V value);

  /** 
   * Searches for an entry with the specified key.  If such an entry is found,
   * returns it; otherwise returns null.  If several entries have the specified
   * key, chooses one arbitrarily and return it.
   * @param key the search key.
   * @return an entry containing the key and an associated value, or null if
   *         no entry contains the specified key.
   */
  public Entry<K, V> find(K key);

  /** 
   * Removes an entry with the specified key.  If such an entry is found,
   * removes it from the table and return it; otherwise returns null.
   * If several entries have the specified key, chooses one arbitrarily, then
   * removes and returns it.
   * @param key the search key.
   * @return an entry containing the key and an associated value, or null if
   *          no entry contains the specified key.
   */
  public Entry<K, V> remove(K key);

  /**
   * Removes all entries from the dictionary.
   */
  public void makeEmpty();

}
