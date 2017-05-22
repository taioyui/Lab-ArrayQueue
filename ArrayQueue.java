package org.cct;

import java.util.NoSuchElementException;

/**
 * A Queue is a data structure that stores data (integers here) according to a set of rules.
 * Specifically each element added to the queue gets added to the end (tail) of the Queue, and every
 * element removed from the Queue is taken from the front of the queue (head).
 *
 * @author Jenny
 * @version 0.0.1
 */
public class ArrayQueue {

  int size = 0;          // current number of elements in the Queue
  int[] arrayQueue;        // data structure to hold the elements
  int maxCapacity;        // maximum capacity of the queue
  int head;            // pointer to the front of the Queue
  int tail;            // pointer to the end of the Queue

  /**
   * Default constructor to set default capacity to 10
   */
  public ArrayQueue() {
    maxCapacity = 10;
    arrayQueue = new int[maxCapacity];
    //Fix 3: We are not moving head anymore so it`s always 0
    head = 0;
    tail = -1;
    size = 0;
  }

  /**
   * Bespoke constructor that allows the client to set the maximum capacity
   *
   * @param maxCapacity capacity of the array holding the data
   */
  public ArrayQueue(int maxCapacity) {
    this.maxCapacity = maxCapacity;
    arrayQueue = new int[maxCapacity];
    //Fix 3: We are not moving head anymore so it`s always 0
    head = 0;
    tail = -1;
    size = 0;
  }

  /**
   * Is the Queue empty or not
   *
   * @return whether the Queue is empty or not
   */
  public boolean isEmpty() {
    return size == 0;
  }

  /**
   * Add data to the end of the queue
   *
   * @param data Data to be added
   * @throws IndexOutOfBoundsException cannot add to a full queue (reached end of queue)
   */
  public void enqueue(int data) throws IndexOutOfBoundsException {
    if (isFull()) {
      throw new IndexOutOfBoundsException("Out of bounds");
    }
    arrayQueue[++tail] = data;
    size++;
  }

  /**
   * Remove data from the front of the queue
   *
   * @return the data from the front of the queue
   * @throws NoSuchElementException Cannot remove data from an empty queue
   */
  public int dequeue() throws NoSuchElementException {
    if (size == 0) {
      throw new NoSuchElementException();
    }
    int result = arrayQueue[head];
    //Fix 2: Take head element from the queue and shift elements towards head
    System.arraycopy(arrayQueue, 1, arrayQueue, 0, size);

    size--;
    return result;
  }

  /**
   * Determine if the Queue is full or not
   *
   * @return whether the Queue is full or not
   */
  public boolean isFull() {
    //Fix 1: size should equals maxCapacity
    return size == maxCapacity;
  }

  /**
   * Look at the data at the front of the queue, do not remove it.
   *
   * @return the data at the front of the queue
   * @throws NoSuchElementException We cannot peek at elements in an empty queue
   */
  public int peek() throws NoSuchElementException {
    if (size == 0) {
      throw new NoSuchElementException();
    }
    //Fix 4: As head is always 0 we should not increment head
    return arrayQueue[head];
  }

  public int size() {
    return size;
  }


}
