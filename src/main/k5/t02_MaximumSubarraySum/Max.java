/**
 * https://www.codewars.com/kata/54521e9ec8e60bc4de000d6c/
 */

package k5.t02_MaximumSubarraySum;

public class Max {
    public static int sequence(int[] arr) {
        var currMax = 0;
        var max = 0;
        for (var v : arr) {
            currMax = Math.max(0, currMax + v);
            max = Math.max(max, currMax);
        }
        return max;
    }
}