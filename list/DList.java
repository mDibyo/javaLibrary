/* Dlist.java */

package list;

/**
 * A DList is a mutable doubly-linked list ADT. Its implementation is
 * circularly-linked and emplysa  sentinel node at the head of the list.
 */

public class DList<T> extends List<T> {

	/**
	 * size (inherited) is the number of items in the list
	 * head references the sentinel node
	 */
	protected DListNode<T> head;

	/**
	 * newNode() calls the DListNode constructor, but can be overridden to
	 * call any node class.
	 * @param  item the item to be stored in the node
	 * @param  list the list that owns this node
	 * @param  prev the node previous to this node
	 * @param  next the node following this node
	 */
	protected DListNode<T> newNode(T item, DList<T> list,
                              DListNode<T> prev, DListNode<T> next) {
    return new DListNode<T>(item, list, prev, next);
  }

  /**
   * DList() constructs for an empty DList.
   */
  public DList() {
    head = newNode((T) null, (DList<T>) null, (DListNode<T>) null, (DListNode<T>) null);
    head.next = head.prev = head;
  }

  /**
   * insertFront() inserts an item at the front of this DList.
   * @param item is the item to be inserted.
   */
  public void insertFront(T item) {
    head.next = newNode(item, this, head, head.next);
    head.next.next.prev = head.next;
    size++;
  }

  /**
   * insertBack() inserts an item at the back of this DList.
   * @param item is the item to be inserted.
   */
  public void insertBack(T item) {
    head.prev = newNode(item, this, head.prev, head);
    head.prev.prev.next = head.prev;
  }

  /**
   * front() returns the node at the front of this DList.  If the DList is
   * empty, returns an "invalid" node--a node with the property that any
   * attempt to use it will cause an exception.
   * @return a ListNode at the front of this DList.
   */
  public ListNode<T> front() {
    return head.next;
  }

  /**
   * back() returns the node at the back of this DList.  If the DList is
   * empty, return an "invalid" node--a node with the property that any
   * attempt to use it will cause an exception.  (The sentinel is "invalid".)
   * @return a ListNode at the back of this DList.
   */
  public ListNode<T> back() {
    return head.prev;
  }

  /**
   * toString() returns a String representation of this DList.
   * @return a String representation of this DList.
   */
  public String toString() {
    String result = "[  ";
    try {
    	ListNode<T> current = head.next();
	    while (current != head) {
	      result = result + current.item + "  ";
	      current = current.next();
	    }
    } catch (InvalidNodeException e) {}
    return result + "]";
  }

}