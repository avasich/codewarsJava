/**
 * https://www.codewars.com/kata/517abf86da9663f1d2000003
 */

package k6.t02_ConvertToCamelCase;

import java.util.Set;

class Solution {

    static String toCamelCase(String s) {
        if (s.isEmpty()) {
            return "";
        }

        var sep = Set.of('_', '-');
        var sb = new StringBuilder(s.length());
        var newWord = false;

        for (var i = 0; i < s.length(); ++i) {
            var ch = s.charAt(i);
            if (sep.contains(ch)) {
                newWord = true;
            } else {
                sb.append(newWord ? Character.toUpperCase(ch) : ch);
                newWord = false;
            }
        }

        return sb.toString();
    }
}
