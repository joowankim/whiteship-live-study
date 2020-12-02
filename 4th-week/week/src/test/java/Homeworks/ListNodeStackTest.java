package Homeworks;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import Homeworks.DataStructures.ListNodeStack;

public class ListNodeStackTest {
    @Test
    public void stackIntegratedTest() throws Exception {
        ListNodeStack stack = new ListNodeStack();
        
        stack.push(1);
        stack.push(2);
        stack.push(2);
        stack.push(-2);
        stack.push(12412);
        stack.push(0);
        stack.push(20);

        assertEquals(20, stack.pop());
        assertEquals(0, stack.pop());
        assertEquals(12412, stack.pop());
        assertEquals(-2, stack.pop());

        stack.push(7);
        stack.push(88);

        assertEquals(88, stack.pop());
        assertEquals(7, stack.pop());
        assertEquals(2, stack.pop());
        assertEquals(2, stack.pop());
        assertEquals(1, stack.pop());

        Exception exception = assertThrows(Exception.class, ()->{
            stack.pop();
        });
        assertEquals("No more stack", exception.getMessage());
    }
}
