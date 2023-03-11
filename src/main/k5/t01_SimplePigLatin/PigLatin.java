/**
 * https://www.codewars.com/kata/520b9d2ad5c005041100000f
 */

package k5.t01_SimplePigLatin;

import java.util.Arrays;
import java.util.stream.Collectors;

public class PigLatin {
    public static String pigIt(String str) {
        return Arrays.stream(str.split("\\b"))
                .filter(s -> !s.isEmpty())
                .map(s -> {
                    if (!Character.isAlphabetic(s.charAt(0))) {
                        return s;
                    }

                    return "%s%say".formatted(
                            s.substring(1),
                            s.charAt(0)
                    );
                }).collect(Collectors.joining());
    }
}