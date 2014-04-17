/* List.java */

package list;

/**
 * A List is a generic mutable list ADT which stores objects of only one kind.
 */

public abstract class List<T> {

	/**
	 * size is the number of items in the list.
	 */
	protected int size;

	/**
	 * isEmpty() returns true if this List is empty.
	 * @return true if this List is empty, false otherwise.
	 */
	public boolean isEmpty() {
		return (size == 0);
	}

	/**
	 * length() returns the size of this List.
	 * @return the length of this List.
	 */
	public int length() {
		return size;
	}

	/**
   * insertFront() inserts an item at the front of this List.
   * @param item the item to be inserted.
   */
  public abstract void insertFront(T item);

  /**
   * insertBack() inserts an item at the back of this List.
   * @param item the item to be inserted.
   */
  public abstract void insertBack(T item);

  /**
   * front() returns the node at the front of this List.  If the List is
   * empty, returns a ListEmptyException otherwise.
   * @return a ListNode at the front of this List.
   * @exception ListEmptyException if this List is empty.
   */
  public abstract ListNode front() throws ListEmptyException;

  /**
   * back() returns the node at the back of this List.  If the List is
   * empty, returns a ListEmptyException otherwise.
   * @return a ListNode at the back of this List.
   * @exception ListEmptyException if this list is empty. 
   */
  public abstract ListNode back() throws ListEmptyException;

  /**
   * toString() returns a String representation of this List.
   * @return a String representation of this List.
   */
  public abstract String toString();

}