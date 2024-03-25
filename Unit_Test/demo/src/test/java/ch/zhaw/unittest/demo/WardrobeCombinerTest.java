package ch.zhaw.unittest.demo;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;
import java.util.Arrays;

public class WardrobeCombinerTest {
    @Test
    public void test250cm() {
        WardrobeCombiner wardrobeCombiner = new WardrobeCombiner(250);
        int[] sizes = {50, 75, 100, 120};
        List<List<Integer>> actualCombinations = wardrobeCombiner.findCombinations(sizes);
        List<List<Integer>> expectedCombinations = Arrays.asList(
            Arrays.asList(50, 50, 50, 50, 50),
            Arrays.asList(50, 50, 50, 100),
            Arrays.asList(50, 50, 75, 75),
            Arrays.asList(50, 100, 100),
            Arrays.asList(75, 75, 100)
        );
        assertEquals(expectedCombinations, actualCombinations);
    }

    @Test
    public void test300cm() {
        WardrobeCombiner wardrobeCombiner = new WardrobeCombiner(300);
        int[] sizes = {50, 75, 100, 120};
        List<List<Integer>> actualCombinations = wardrobeCombiner.findCombinations(sizes);
        // Add the expected combinations for a 300cm wall
        // ...
        assertNotNull(actualCombinations);
    }
}
