package org.elcata98.misc.xor;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class XOR {

    /** Starting at 0
        1 - 1 - M%4: 1
        11 - 3 - M%4: 2
        00 - 0 - M%4: 3
        100 - 4 - M%4: 0
        001 - 1 - M%4: 1
        111 - 7 - M%4: 2
        000 - 0 - M%4: 3
        1000 - 8 - M%4: 0
        0001 - 1 - M%4: 1
        1011 - 11 - M%4: 2
        0000 - 0 - M%4: 3
        1100 - 12 - M%4: 0
        0001 - 1 - M%4: 1
        1111 - 15 - M%4: 2
        0000 - 0 - M%4: 3
        10000 - 16 - M%4: 0
        00001 - 1 - M%4: 1

        (M,0) -> M%4 {
                            0 -> M
                            1 -> 1
                            2 -> M+1
                            3 -> 0
                        }
     **/
    /** Starting at 1

        11 - 3 - M%4: 2
        00 - 0 - M%4: 3
        100 - 4 - M%4: 0
        001 - 1 - M%4: 1
        111 - 7 - M%4: 2
        000 - 0 - M%4: 3
        1000 - 8 - M%4: 0
        0001 - 1 - M%4: 1
        1011 - 11 - M%4: 2
        0000 - 0 - M%4: 3
        1100 - 12 - M%4: 0
        0001 - 1 - M%4: 1
        1111 - 15 - M%4: 2
        0000 - 0 - M%4: 3

         (M,1) -> M%4 {
                            0 -> M
                            1 -> 1
                            2 -> M-1
                            3 -> 0
                        }
     */
    public static void main(String[] args) {
	// write your code here
        int M = 16;
        int N = 2;

        IntStream.range(0, M)
                .forEachOrdered(m ->
                        {
                            int result2 = bitxorProdV2(m, N);

//                            switch(Math.floorMod(m-N,4)) {
//                                case 0 : if(result2!=m){
//                                    throw new AssertionError(m + " - "+ result2);
//                                } break;
//                                case 1 : if(result2!=1){
//                                    throw new AssertionError(m + " - "+ result2);
//                                } break;
//                                case 2 : if(result2!=m+1){
//                                    throw new AssertionError(m + " - "+ result2);
//                                } break;
//                                case 3 : if(result2!=0){
//                                    throw new AssertionError(m + " - "+ result2);
//                                } break;
//                            }
                            System.out.println(result2);
                        }
                );
    }

    private static int bitxorProdV2(int M, int N){

        // To use the range correctly need to check which is bigger
        if(M<N){

            return
                    IntStream.range(M, N+1)
                            .reduce(XOR::bitxorV2)
                            .getAsInt();
        }else if(M>N) {

            return
                    IntStream.range(N, M+1)
                            .reduce(XOR::bitxorV2)
                            .getAsInt();
        }else{
            return 0;
        }
    }

    private static int bitxorV2(int K, int L) {

        String bytesK = Integer.toBinaryString(K);
        String bytesL = Integer.toBinaryString(L);

        int diff = bytesK.length() - bytesL.length();

        if (diff < 0) {

            StringBuilder b = new StringBuilder();
            for (int i = 0; i > diff; --i) {
                b.append("0");
            }
            bytesK = b.append(bytesK).toString();

        } else if (diff > 0) {

            StringBuilder b = new StringBuilder();
            for (int i = 0; i < diff; ++i) {
                b.append("0");
            }
            bytesL = b.append(bytesL).toString();
        }

        String finalBytesK = bytesK;
        String finalBytesL = bytesL;

        String result =
                IntStream.range(0, bytesK.length())
                        .map(i -> finalBytesK.charAt(i) ^ finalBytesL.charAt(i))
                        .mapToObj(Integer::toString)
                        .collect(Collectors.joining());

        System.out.println(result + " - "+ Integer.parseInt(result,2) + " - M%4: "+ Math.floorMod(L, 4));

        return Integer.parseInt(result, 2);
    }

//    FIXME: Missing treatment for M = N, where the result should be zero
//    TODO: Some protection for the get on the optional
    private static int bitxorProd(int M, int N){

        // To use the range correctly need to check which is bigger
        if(M<N){

            return
                    IntStream.range(M, N+1)
                            .reduce(XOR::bitxor)
                            .getAsInt();
        }else{

            return
                    IntStream.range(N, M+1)
                            .reduce(XOR::bitxor)
                            .getAsInt();
        }
    }

    private static int bitxor(int K, int L){

        String bytesK = Integer.toBinaryString(K);
        String bytesL = Integer.toBinaryString(L);

        int diff = bytesK.length() - bytesL.length();

        if(diff < 0){
            StringBuilder b = new StringBuilder();
            for(int i=0; i>diff; --i){
                b.append("0");
            }
            bytesK = b.append(bytesK).toString();

        }else if(diff > 0){
            StringBuilder b = new StringBuilder();
            for(int i=0; i<diff; ++i){
                b.append("0");
            }
            bytesL = b.append(bytesL).toString();
        }

        StringBuilder bytesC = new StringBuilder();

        for (int i= 0; i< bytesK.length(); ++i){
            bytesC.append(bytesK.charAt(i)^bytesL.charAt(i));
        }
//        System.out.println(bytesC.toString() + " - "+ Integer.parseInt(bytesC.toString(),2));
        return Integer.parseInt(bytesC.toString(),2);
    }
}