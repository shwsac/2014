package mystructures;

import java.util.HashMap;

public class LRUCache<E, V> {
  private HashMap<E, DoublyLinkedListNode<E, V>> hMap = new HashMap<E, DoublyLinkedListNode<E, V>>();
  private DoublyLinkedListNode<E, V> head;
  private DoublyLinkedListNode<E, V> tail;
  private int capacity;
  private int size;

  public void put(E key, V Value) {
    if (key == null)
      return;
    if (hMap.containsKey(key)) {
      DoublyLinkedListNode<E, V> node = hMap.get(key);
      removeNode(node);
      setHead(node);
    } else {
      DoublyLinkedListNode<E, V> node = new DoublyLinkedListNode<E, V>(key,
          Value);
      hMap.put(key, node);
      setHead(node);
      if (size >= capacity) {
        hMap.remove(tail.key);
        tail = tail.prev;
        if (tail != null) {
          tail.next = null;
        }
      } else {
        size++;
      }
    }

  }

  private void setHead(DoublyLinkedListNode<E, V> val) {
    // TODO Auto-generated method stub

  }

  private void removeNode(DoublyLinkedListNode<E, V> val) {
    DoublyLinkedListNode prv  = val.prev;
    DoublyLinkedListNode nxt = val.next;
    if(prv!=null) {
      prv.next = nxt;
    }else {
      head = nxt;
    }
    if (nxt!=null) {
      nxt.prev = prv;
    }else {
      tail = prv;
    }
  }

  public V get(E key) {
    if (hMap.containsKey(key)) {
      DoublyLinkedListNode<E, V> node = hMap.get(key);
      removeNode(node);
      setHead(node);
      return node.value;
    } else {
      return null;
    }
  }

  class DoublyLinkedListNode<E, V> {
    public DoublyLinkedListNode(E key, V value) {
      this.key = key;
      this.value = value;
    }

    E key;
    V value;
    DoublyLinkedListNode<E, V> next;
    DoublyLinkedListNode<E, V> prev;
  }

  public static void main(String[] args) {
    // TODO Auto-generated method stub

  }

}
