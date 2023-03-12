package k5.t03_TheBee;

import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.math.BigInteger;

import static org.junit.jupiter.api.Assertions.assertEquals;

// TODO: Replace examples and use TDD by writing your own tests

public class SolutionTest {
    @ParameterizedTest(name = "theBee({0})")
    @CsvSource(textBlock = """
                 2, 11
                 3, 291
                 5, 259123
                20, 11419120154603538332020717795
                33, 706829476133138423874525925298446150375545319299
                50, 61068096560504518254246449553519425203436341865056944755649047832571626123
            """)
    @DisplayName("Sample Tests")
    public void sampleTests(int n, BigInteger expected) {
        assertEquals(expected, Kata.theBee(n));
    }

    @Test
    public void testSmall() {
        assertEquals(259123, Kata.smallBee(5));
    }
}