/* DListNode.java */

package list;

/**
 * A DListNode is a mutable node in a DList (doubly-linked list).
 */

public class DListNode<T> extends ListNode<T> {

  /**
   * (inherited)  item references the item stored in the current node.
   * (inherited)  list references the List that contains this node.
   * prev references the previous node in the DList.
   * next references the next node in the DList.
   */
  protected DListNode<T> prev;
  protected DListNode<T> next;

  /**
   * DListNode() constructor.
   * @param i the item to store in the node.
   * @param l the list this node is in.
   * @param p the node previous to this node.
   * @param n the node following this node.
   */
  DListNode(T i, DList<T> l, DListNode<T> p, DListNode<T> n) {
    item = i;
    list = l;
    prev = p;
    next = n;
  }

  /**
   * isValidNode returns true if this node is valid; false otherwise.
   * An invalid node is represented by a `list' field with the value null.
   * Sentinel nodes are invalid, and nodes that don't belong to a list are
   * also invalid.
   * @return true if this node is valid; false otherwise.
   */
  public boolean isValidNode() {
    return list != null;
  }

  /**
   * next() returns the node following this node.  If this node is invalid,
   * throws an exception.
   * @return the node following this node.
   * @exception InvalidNodeException if this node is not valid.
   */
  public ListNode<T> next() throws InvalidNodeException {
    if (!isValidNode()) {
      throw new InvalidNodeException("next() called on invalid node");
    }
    return next;
  }

  /**
   * prev() returns the node preceding this node.  If this node is invalid,
   * throws an exception.
   * @param node the node whose predecessor is sought.
   * @return the node preceding this node.
   * @exception InvalidNodeException if this node is not valid.
   */
  public ListNode<T> prev() throws InvalidNodeException {
    if (!isValidNode()) {
      throw new InvalidNodeException("prev() called on invalid node");
    }
    return prev;
  }

  /**
   * insertAfter() inserts an item immediately following this node.  If this
   * node is invalid, throws an exception.
   * @param item the item to be inserted.
   * @exception InvalidNodeException if this node is not valid.
   */
  public void insertAfter(T item) throws InvalidNodeException {
    if (!isValidNode()) {
      throw new InvalidNodeException("insertAfter() called on invalid node");
    }
    next = ((DList<T>) list).newNode(item, (DList<T>) list, this, next);
    next.next.prev = next;
    list.size ++;
  }

  /**
   * insertBefore() inserts an item immediately preceding this node.  If this
   * node is invalid, throws an exception.
   * @param item the item to be inserted.
   * @exception InvalidNodeException if this node is not valid.
   */
  public void insertBefore(T item) throws InvalidNodeException {
    if (!isValidNode()) {
      throw new InvalidNodeException("insertBefore() called on invalid node");
    }
    prev = ((DList<T>) list).newNode(item, (DList<T>) list, prev, this);
    prev.prev.next = prev;
    list.size ++;
  }

  /**
   * remove() removes this node from its DList.  If this node is invalid,
   * throws an exception.
   * @exception InvalidNodeException if this node is not valid.
   */
  public void remove() throws InvalidNodeException {
    if (!isValidNode()) {
      throw new InvalidNodeException("remove() called on invalid node");
    }
    prev.next = next;
    next.prev = prev;
    list.size --;
    list = null;
    next = null;
    prev = null;
  }

}