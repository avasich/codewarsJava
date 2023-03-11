/**
 * https://www.codewars.com/kata/545cedaa9943f7fe7b000048
 */

package k6.t05_DetectPangram;

public class PangramChecker {

    public boolean check(String sentence) {
        return sentence.chars()
                .filter(Character::isAlphabetic)
                .map(Character::toLowerCase)
                .distinct()
                .count() == 26;
    }
}
