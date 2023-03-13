/**
 * https://www.codewars.com/kata/51c8e37cee245da6b40000bd
 */

package k4.t04_StripComments;

import java.util.Arrays;
import java.util.stream.Collectors;

public class StripComments {
    // should have used regex
    public static String stripComments(String text, String[] commentSymbols) {
        final var delimiters = Arrays.stream(commentSymbols)
                .map(s -> s.codePointAt(0))
                .collect(Collectors.toSet());
        return text.lines().map(line -> {
            var len = (int) line.chars().takeWhile(i -> !delimiters.contains(i)).count();
            return line.substring(0, len).replaceAll("\\s+$", "");
        }).collect(Collectors.joining("\n"));
    }

}
