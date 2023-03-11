/**
 * https://www.codewars.com/kata/54bb6f887e5a80180900046b
 */

package k6.t01_LongestPalindrome;

public class Palindromes {
    public static int longestPalindrome(final String s) {
        var size = s.length();
        if (size < 2) {
            return size;
        }

        var table = new int[size][size];
        var chars = s.toCharArray();
        var longest = 1;

        for (var i = 0; i < size; ++i) {
            table[i][i] = 1;
        }

        for (var left = size - 2; left >= 0; --left) {
            for (var right = left + 1; right < size; ++right) {
                if (chars[left] == chars[right]) {
                    var inner = table[left + 1][right - 1];
                    if (left + 1 != right && inner == 0) {
                        table[left][right] = 0;
                    } else {
                        var length = inner + 2;
                        table[left][right] = length;
                        longest = Math.max(longest, length);
                    }
                }
            }
        }

        return longest;
    }
}