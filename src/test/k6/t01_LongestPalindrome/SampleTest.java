package k6.t01_LongestPalindrome;

import org.junit.Assert;
import org.junit.Test;

public class SampleTest {
    @Test
    public void basicTests() {
        doTest("a", 1);
        doTest("aa", 2);
        doTest("baa", 2);
        doTest("aab", 2);
        doTest("zyabyz", 1);
        doTest("baabcd", 4);
        doTest("baablkj12345432133d", 9);
    }

    private void doTest(final String s, int expected) {
        Assert.assertEquals(expected, Palindromes.longestPalindrome(s));
    }
}