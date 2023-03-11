/**
 * https://www.codewars.com/kata/578aa45ee9fd15ff4600090d
 */
package k6.t03_SortTheOdd;

import java.util.Arrays;

public class Kata {
    public static int[] sortArray(int[] array) {
        var sortedOdds = Arrays.stream(array)
                .filter(x -> x % 2 == 1)
                .sorted()
                .toArray();
        var cursor = 0;
        for (int i = 0; i < array.length; ++i) {
            if (array[i] % 2 == 1) {
                array[i] = sortedOdds[cursor];
                cursor += 1;
            }
        }

        return array;
    }
}
