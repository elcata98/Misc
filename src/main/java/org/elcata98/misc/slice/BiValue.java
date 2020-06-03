package org.elcata98.misc.slice;

import java.util.HashSet;
import java.util.Set;

public class BiValue {

    public static void main(final String[] args) {

        /*
           A[0] = 5
           A[1] = 4
           A[2] = 4
           A[3] = 5
           A[4] = 0
           A[5] = 12
         */
        int[] A = {7, 8, 9, 7, 4, 4, 4, 5, 0, 12};

        int p = 0;
        int q = A.length - 2;
        int distance = 0;

        int expP = p;
        int expQ = q;
        int expDistance = distance;

        while (p != q) {
            while (p != q) {
                if (biValued(A, p, q)) {
                    if (Math.abs(p - q) > distance) {
                        distance = Math.abs(p - q) + 1;
                        expDistance = distance;
                        expP = p;
                        expQ = q;
                    }
                }
                --q;
            }
            q = A.length - 2;
            ++p;
        }

        System.out.println(expP + " - " + expQ + " : " + expDistance);
    }

    public static boolean biValued(final int[] A, final int p, final int q) {

        int differentCount = 0;
        int i = p;

        Set<Integer> values = new HashSet<>();
        while (differentCount != 3 && i <= q) {
            if (!values.contains(A[i])) {
                values.add(A[i]);
                ++differentCount;
            }
            ++i;
        }

        return differentCount != 3;
    }
}