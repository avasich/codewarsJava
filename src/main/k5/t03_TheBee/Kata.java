/**
 * https://www.codewars.com/kata/6408ba54babb196a61d66a65
 */

package k5.t03_TheBee;

import java.math.BigInteger;
import java.util.Arrays;

public class Kata {

    public static BigInteger theBee(int n) {
        var t = System.nanoTime();

        var old = new BigInteger[n];
        Arrays.fill(old, BigInteger.ZERO);
        old[0] = BigInteger.ONE;

        var curr = new BigInteger[n];

        for (var i = 1; i < n; ++i) {
            Arrays.fill(curr, BigInteger.ZERO);
            curr[0] = BigInteger.ONE;
            for (var j = 1; j < i; ++j) {
                curr[j] = curr[j - 1].add(old[j - 1]).add(old[j]);
            }
            curr[i] = curr[i - 1].multiply(BigInteger.TWO).add(old[i - 1]);
            System.arraycopy(curr, 0, old, 0, n);
        }

        for (var i = 0; i < n - 1; ++i) {
            Arrays.fill(curr, BigInteger.ZERO);
            curr[0] = old[0].add(old[1]);
            for (var j = 1; j < n - 1; ++j) {
                curr[j] = curr[j - 1].add(old[j]).add(old[j + 1]);
            }
            curr[n - 1] = curr[n - 2].multiply(BigInteger.TWO).add(old[n - 1]);
            System.arraycopy(curr, 0, old, 0, n);
        }

        if (n == 50) {
            var elapsed = System.nanoTime() - t;
            System.out.printf("b0: n=%d, t=%d\n", n, elapsed);
        }
        return old[n - 1];
    }

    public static long smallBee(int n) {
        var old = new long[n];
        var curr = new long[n];
        old[0] = 1L;

        for (var i = 1; i < n; ++i) {
            Arrays.fill(curr, 0L);
            curr[0] = 1L;
            for (var j = 1; j < i; ++j) {
                curr[j] = curr[j - 1] + old[j - 1] + old[j];
            }
            curr[i] = 2 * curr[i - 1] + old[i - 1];
            System.arraycopy(curr, 0, old, 0, n);
        }

        for (var i = 0; i < n - 1; ++i) {
            Arrays.fill(curr, 0L);
            curr[0] = old[0] + old[1];
            for (var j = 1; j < n - 1; ++j) {
                curr[j] = curr[j - 1] + old[j] + old[j + 1];
            }
            curr[n - 1] = 2 * curr[n - 2] + old[n - 1];
            System.arraycopy(curr, 0, old, 0, n);
        }

        return old[n - 1];
    }
}