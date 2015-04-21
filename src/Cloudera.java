import java.io.*;
import java.util.*;

/*
 * To execute Java, please define "static void main" on a class
 * named Solution.
 *
 * If you need more classes, simply define them inline.
 */

class Cloudera {
  interface Stack<E> {
    void push(E elem);

    E pop();

    boolean isEmpty();

    int size();
  }

  static class StackImpl<E> implements Stack<E> {
    E arr[];
    int size;
    int top = -1;

    StackImpl(int size) {
      this.size = size;
      arr = (E[]) new Object[size];
    }

    public E pop() {
      if (isEmpty()) {
        return null;
        // throw new Exception("Popping out of empty stack");
      } else {
        E e = arr[top--];
        return e;
        // return (E) arr[top--];
      }
    }

    public void push(E elem) {
      if (top == size - 1) {
        E newArr[] = (E[]) new Object[2 * size];
        for (int i = 0; i < size; i++) {
          newArr[i] = arr[i];
        }
        arr = newArr;
      }
      arr[++top] = elem;
    }

    public boolean isEmpty() {
      if (top == -1) {
        return true;
      } else {
        return false;
      }
    }

    public int size() {
      return top + 1;
    }

  }

  public static void main(String[] args) {
    StackImpl<Integer> st = new StackImpl<Integer>(10);
    System.out.println(st.isEmpty());
    st.push(1);
    st.push(2);
    st.push(3);
    System.out.println(st.isEmpty());
    System.out.println(st.pop());
    System.out.println(st.pop());
    System.out.println(st.pop());
    System.out.println(st.isEmpty());

    StackImpl<String> st2 = new StackImpl<String>(10);
    System.out.println(st2.isEmpty());
    st2.push("Monish");
    st2.push("Bhagat");
    st2.push("Shweta");
    System.out.println(st2.isEmpty());
    System.out.println(st2.pop());
    System.out.println(st2.pop());
    System.out.println(st2.pop());
    System.out.println(st2.isEmpty());

  }
}