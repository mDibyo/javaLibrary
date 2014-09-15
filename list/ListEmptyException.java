/* ListEmptyException.java */

package list;

/**
 *  Implements an Exception that signals that a given list is empty.
 */
public class ListEmptyException extends Exception {

  protected ListEmptyException() {
    super();
  }

  protected ListEmptyException(String s) {
    super(s);
  }
  
}