/**
 * https://www.codewars.com/kata/54dc6f5a224c26032800005c
 */

package k6.t06_HelpTheBookseller;

import java.util.Arrays;
import java.util.stream.Collectors;

public class StockList {

    // 1st parameter is the stocklist (L in example),
    // 2nd parameter is list of categories (M in example)
    public static String stockSummary(String[] lstOfArt, String[] lstOf1stLetter) {
        final var categories = Arrays.stream(lstOf1stLetter).collect(Collectors.toUnmodifiableSet());
        final var available = Arrays.stream(lstOfArt)
                .filter(code -> categories.contains(code.substring(0, 1)))
                .collect(Collectors.groupingBy(
                        code -> code.substring(0, 1),
                        Collectors.summingInt(code -> Integer.parseInt(code.split(" ")[1]))
                ));
        if (available.isEmpty()) {
            return "";
        }
        return Arrays.stream(lstOf1stLetter)
                .map(category -> "(%s : %d)".formatted(category, available.getOrDefault(category, 0)))
                .collect(Collectors.joining(" - "));
    }
}
