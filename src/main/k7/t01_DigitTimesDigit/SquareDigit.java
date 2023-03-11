/**
 * https://www.codewars.com/kata/546e2562b03326a88e000020
 */

package k7.t1_DigitTimesDigit;

public class SquareDigit {
    public int squareDigits(int n) {
        var acc = 0;
        var p = 1;

        while (n > 0) {
            var d = n % 10;
            var d2 = d * d;
            acc = d2 * p + acc;
            p *= d2 < 10 ? 10 : 100;
            n /= 10;
        }

        return acc;
    }
}
