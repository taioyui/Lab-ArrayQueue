package org.cct;

import static org.junit.Assert.*;

import java.util.NoSuchElementException;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by taioyui on 26/02/17.
 */
public class ArrayQueueTest {

  /**
   * object being tested
   */

  ArrayQueue arrayQueue;

  /**
   * method setUp executes before every test method
   * initialises arrayQueue object
   */

  @Before
  public void setUp() {
    arrayQueue = new ArrayQueue();
  }


  /**
   * 1. Push 10 Integers into Queue
   * 2. Assert that the size equals 10
   */

  @Test
  public void testDefaultConstructor() throws Exception {
    for (int i = 0; i < 10; i++) {
      arrayQueue.enqueue(100 + i);
    }
    assertEquals(10, arrayQueue.size());
  }

  /**
   * 1. Call method isEmpty on empty Queue
   * 2. Assert that result is True
   * 3. Enqueue Integer into Queue
   * 4. Call isEmpty again
   * 5. Assert that result is false
   */

  @Test
  public void testQueueIsEmpty() throws Exception {
    boolean result = arrayQueue.isEmpty();
    assertTrue(result);
    arrayQueue.enqueue(1);
    result = arrayQueue.isEmpty();
    assertFalse(result);
  }

  /**
   * 1. Push two Integers into Queue
   * 2. Assert size of array equals 2
   * 3. Call method dequeue and check that the first element returns
   * 4. Assert that the size equals 1
   * 5. Assert that next call of dequeue method returns last element
   * 6. Assert that the Queue is empty
   */

  @Test
  public void testDequeueAndSize() throws Exception {
    int first = 123;
    int last = 321;
    arrayQueue.enqueue(first);
    arrayQueue.enqueue(last);
    assertEquals(2, arrayQueue.size());
    assertEquals(first, arrayQueue.dequeue());
    assertEquals(1, arrayQueue.size());
    assertEquals(last, arrayQueue.dequeue());
    assertTrue(arrayQueue.isEmpty());
  }

  /**
   * 1. Create Queue with size 2. Assert isFull returns False
   * 2. Push two Integers into Queue
   * 3. Call method isFull
   * 4. Assert result is True
   */
  @Test
  public void testQueueIsFull() throws Exception {
    arrayQueue = new ArrayQueue(2);
    assertFalse(arrayQueue.isFull());
    arrayQueue.enqueue(123);
    arrayQueue.enqueue(321);
    assertTrue(arrayQueue.isFull());
  }


  /**
   * 1. Push Integer into Queue
   * 2. Look at the data at the head of the Queue
   * 3. Assert data is the same
   */
  @Test
  public void testPeek() throws Exception {
    int data = 123;
    arrayQueue.enqueue(data);
    int result = arrayQueue.peek();
    assertEquals(data, result);

  }


  @Test(expected = IndexOutOfBoundsException.class)
  public void testQueueCapacity() throws Exception {
    for (int i = 0; i < 11; i++) {
      arrayQueue.enqueue(100 + i);
    }
  }

  @Test(expected = NoSuchElementException.class)
  public void testDequeueEmpty() throws Exception {
    arrayQueue.dequeue();
  }

  @Test(expected = NoSuchElementException.class)
  public void testPeekEmpty() throws Exception {
    arrayQueue.peek();
  }

}