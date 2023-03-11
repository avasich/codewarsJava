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
