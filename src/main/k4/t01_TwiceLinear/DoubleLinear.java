/**
 * https://www.codewars.com/kata/5672682212c8ecf83e000050
 */

package k4.t01_TwiceLinear;

import java.util.ArrayList;
import java.util.Collections;
import java.util.TreeSet;

class DoubleLinear {

    public static int dblLinear(int n) {
        var list = new ArrayList<Integer>(3 * n);
        list.add(1);

        for (var i = 0; i < n; ++i) {
            var u = list.get(i);
            var x2 = 2 * u + 1;
            var x3 = 3 * u + 1;
            var i2 = Collections.binarySearch(list, x2);
            var i3 = Collections.binarySearch(list, x3);
            if (i3 < 0) {
                list.add(-i3 - 1, x3);
            }
            if (i2 < 0) {
                list.add(-i2 - 1, x2);
            }
        }

        return list.get(n);
    }

    public static int dblLinearTreeSet(int n) {
        var tree = new TreeSet<Integer>();
        tree.add(1);
        for (var i = 0; i < n; ++i) {
            int x = tree.pollFirst();
            int y = x + x + 1;
            int z = y + x;
            tree.add(y);
            tree.add(z);
        }
        return tree.first();
    }

    public static int dblLinearCursors(int n) {
        var list = new ArrayList<>(n);
        list.add(1);
        int u = 0;
        int v = 0;
        for (int i = 0; i < n; i++) {
            int y = 2 * (int) list.get(u) + 1;
            int z = 3 * (int) list.get(v) + 1;
            if (y < z) {
                list.add(y);
                u = u + 1;
            } else if (y > z) {
                list.add(z);
                v = v + 1;
            } else {
                list.add(y);
                u = u + 1;
                v = v + 1;
            }
        }
        return (int) list.get(n);
    }

    public static void main(String[] args) {
        final var n = 50000000;
        var start = 0L;
        var res = 0;
//        start = System.currentTimeMillis();
//        res = dblLinear(n);
//        final var eNaive = System.currentTimeMillis() - start;

        start = System.currentTimeMillis();
        res = dblLinearTreeSet(n);
        final var eTreeSet = System.currentTimeMillis() - start;

        start = System.currentTimeMillis();
        res = dblLinearCursors(n);
        final var eCursors = System.currentTimeMillis() - start;

//        System.out.println(eNaive);
        System.out.println(eTreeSet);
        System.out.println(eCursors);
    }
}