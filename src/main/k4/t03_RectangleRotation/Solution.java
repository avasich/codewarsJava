/**
 * https://www.codewars.com/kata/5886e082a836a691340000c3
 */

package k4.t03_RectangleRotation;

class Solution {

    static int rectangleRotation(final int a, final int b) {
        final var sqrt2 = Math.sqrt(2);
        final var a1 = a / 2 / sqrt2;
        final var b1 = b / 2 / sqrt2;
        final var ao = (int) (1 + 2 * Math.floor(a1));
        final var ae = a1 % 1 > 0.5 ? ao + 1 : ao - 1;
        final var bo = (int) (1 + 2 * Math.floor(b1));
        final var be = b1 % 1 > 0.5 ? bo + 1 : bo - 1;

        return ao * bo + ae * be;
    }
}