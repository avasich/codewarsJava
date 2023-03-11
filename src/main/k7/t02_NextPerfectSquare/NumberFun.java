/**
 * https://www.codewars.com/kata/56269eb78ad2e4ced1000013
 */

package k7.t02_NextPerfectSquare;

public class NumberFun {
    private static final long maxRoot = (long) Math.sqrt((double) Long.MAX_VALUE);

    public static long findNextSquare(long sq) {
        var upper = Math.min(1 + sq / 2, maxRoot);
        var lower = 1L;

        while (upper != lower) {
            var m = lower + (upper - lower) / 2;
            var m2 = m * m;
            if (m2 > sq) {
                upper = m;
            } else if (m2 < sq) {
                lower = m + 1;
            } else {
                upper = lower = m;
                break;
            }
        }

        if (upper * upper != sq) {
            return -1;
        } else {
            return (upper + 1) * (upper + 1);
        }
    }
}