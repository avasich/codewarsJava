package k6.t07_AreTheyTheSame;

import java.util.Arrays;
import java.util.stream.Collectors;

public class AreSame {

    public static boolean comp(int[] a, int[] b) {
        if (a == null || b == null || a.length != b.length) {
            return false;
        }
        var aSet = Arrays.stream(a).boxed().collect(Collectors.groupingBy(x -> x * x, Collectors.counting()));
        var bSet = Arrays.stream(b).boxed().collect(Collectors.groupingBy(x -> x, Collectors.counting()));
        return aSet.equals(bSet);
    }
}
