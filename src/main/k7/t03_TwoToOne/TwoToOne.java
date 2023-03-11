/**
 * https://www.codewars.com/kata/5656b6906de340bd1b0000ac
 */

package k7.t3_TwoToOne;

import java.util.stream.IntStream;

public class TwoToOne {

    public static String longest(String s1, String s2) {
        return IntStream.concat(s1.chars(), s2.chars())
                .distinct()
                .sorted()
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
    }
}