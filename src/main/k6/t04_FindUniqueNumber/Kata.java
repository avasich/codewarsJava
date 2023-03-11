/**
 * https://www.codewars.com/kata/585d7d5adb20cf33cb000235
 */

package k6.t04_FindUniqueNumber;

import java.util.Arrays;

public class Kata {
    public static double findUniq(double arr[]) {
        final var nonUnique = arr[0] == arr[1] ? arr[0] : arr[2];

        return Arrays.stream(arr)
                .filter(x -> x != nonUnique)
                .findFirst()
                .getAsDouble();
    }
}