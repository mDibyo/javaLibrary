/* Entry.java */

package dict;

/**
 * A class for dictionary entries.
 */

public class Entry<K, V> {

  protected K key;
  protected V value;

  public K key() {
    return key;
  }

  public V value() {
    return value;
  }

}
