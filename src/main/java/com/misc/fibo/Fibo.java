package com.misc.fibo;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

public class Fibo {

    private static final Map<Float, Float> CALCULATED = new HashMap<>();

    public static void main(String[] args) {
//        IntStream.range(0, 100).forEachOrdered(i -> System.out.println("fib("+i+") = "+ BigDecimal.valueOf(fibRec(i)).toPlainString()));
//        IntStream.range(0, 8181).forEachOrdered(i -> System.out.println("fib("+i+") = "+ fibIt(BigInteger.valueOf(i))));

        System.out.println(fibIt(BigInteger.valueOf(8181)));
    }

    public static BigInteger fibIt(final BigInteger x) {

        if(BigInteger.ZERO.equals(x) || (BigInteger.ONE.equals(x))){
            return x;
        }

        BigInteger fib = BigInteger.ONE;
        BigInteger prevFib = BigInteger.ONE;

        BigInteger i = BigInteger.TWO;

        while(i.compareTo(x) < 0) {
            BigInteger temp = fib;
            fib = fib.add(prevFib);
            prevFib = temp;
            i = i.add(BigInteger.ONE);
        }
        return fib;
    }

    /**
     * Recursive implementation
     * Given positive integer returns the Fibonacci number of that integer
     * @param x
     * @return Fibonacci number of x
     */
    public static float fibRec(final float x){

        float a;
        float b;

        if (x<=1) {

            return x;
        } else {

            if(CALCULATED.get(x-1) != null) {
                a = CALCULATED.get(x-1);
            } else {
                a = fibRec(x-1);
                CALCULATED.put(x-1,a);
            }

            if(CALCULATED.get(x-2) != null) {
                b = CALCULATED.get(x-2);
            } else {
                b = fibRec(x-2);
                CALCULATED.put(x-2, b);
            }
            return a + b;
        }
    }
}