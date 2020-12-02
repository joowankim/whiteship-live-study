package Homeworks;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import Homeworks.DataStructures.Queue;

public class QueueTest {
    @Test
    public void integratedQueueTest() throws Exception {
        Queue queue = new Queue();

        queue.add(1);
        queue.add(-1);
        queue.add(0);
        queue.add(123);
        queue.add(-32);
        queue.add(-4343);
        queue.add(111);
        queue.add(2323);
        queue.add(1);
        queue.add(1);
        queue.add(555);

        assertEquals(1, queue.peek());
        assertEquals(1, queue.remove());
        assertEquals(-1, queue.peek());
        assertEquals(-1, queue.remove());
        assertEquals(0, queue.peek());
        assertEquals(0, queue.remove());
        assertEquals(123, queue.peek());
        assertEquals(123, queue.remove());
        assertEquals(-32, queue.peek());
        assertEquals(-32, queue.remove());
        assertEquals(-4343, queue.peek());
        assertEquals(-4343, queue.remove());
        assertEquals(111, queue.peek());
        assertEquals(111, queue.remove());
        assertEquals(2323, queue.peek());
        assertEquals(2323, queue.remove());
        assertEquals(1, queue.peek());
        assertEquals(1, queue.remove());
        assertEquals(1, queue.peek());
        assertEquals(1, queue.remove());
        assertEquals(555, queue.peek());
        assertEquals(555, queue.remove());
        
        queue.add(2323);
        queue.add(1);
        queue.add(1);
        queue.add(555);

        assertEquals(2323, queue.peek());
        assertEquals(2323, queue.remove());
        assertEquals(1, queue.peek());
        assertEquals(1, queue.remove());
        assertEquals(1, queue.peek());
        assertEquals(1, queue.remove());
        assertEquals(555, queue.peek());
        assertEquals(555, queue.remove());
        
        Exception exception = assertThrows(Exception.class, ()->{
            queue.peek();
        });
        assertEquals("No more queue", exception.getMessage());
        exception = assertThrows(Exception.class, ()->{
            queue.remove();
        });
        assertEquals("No more queue", exception.getMessage());
    }
}
