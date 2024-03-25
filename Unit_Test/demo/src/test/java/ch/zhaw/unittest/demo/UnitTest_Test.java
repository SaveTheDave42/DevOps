package test.java.ch.zhaw.unittest;

// import org.junit.jupiter.api.Assertions;
// import org.junit.jupiter.api.Test;

import org.junit.Test;
import static org.junit.Assert.*;

public class FizzBuzzTest {

    @Test
    public void testFizz() {
        assertEquals("fizz", UnitTest.getResult(3));
        assertEquals("fizz", UnitTest.getResult(6));
        assertEquals("fizz", UnitTest.getResult(9));
    }

    @Test
    public void testBuzz() {
        assertEquals("buzz", UnitTest.getResult(7));
        assertEquals("buzz", UnitTest.getResult(14));
        assertEquals("buzz", UnitTest.getResult(28));
    }

    @Test
    public void testFizzBuzz() {
        assertEquals("fizzbuzz", UnitTest.getResult(21));
        assertEquals("fizzbuzz", UnitTest.getResult(42));
        assertEquals("fizzbuzz", UnitTest.getResult(84));
    }

    @Test
    public void testNumber() {
        assertEquals("1", UnitTest.getResult(1));
        assertEquals("2", UnitTest.getResult(2));
        assertEquals("4", UnitTest.getResult(4));
    }
}