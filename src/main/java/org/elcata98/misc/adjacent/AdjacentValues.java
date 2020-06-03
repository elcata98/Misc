package org.elcata98.misc.adjacent;

import java.util.*;
import java.util.stream.IntStream;

public class AdjacentValues {

    private static Map<Integer, List<Integer>> MAP = new TreeMap<>();
    private static final int DEFAULT_DISTANCE = -1;

    public static void main(String[] args){

        /*
         A[0] = 1
  A[1] = 4
  A[2] = 7
  A[3] = 3
  A[4] = 3
  A[5] = 5
         */

        int A[] = {4,7,3,3,5};

        buildMap(A);

        System.out.println(MAP);

System.out.println(calculateDistances());
    }

    public static void buildMap(int[] A){

        IntStream.range(0,A.length)
                .forEachOrdered(i -> {
                    MAP.computeIfAbsent(A[i], k -> new ArrayList<>());
                    MAP.get(A[i]).add(i);
                });
    }

    public static int calculateDistances(){

        int maxDistance = DEFAULT_DISTANCE;
        Object[] keys = MAP.keySet().toArray();

        for (int i = 0; i< MAP.size()-3; ++i){
            Integer key = (Integer) keys[i];
            Integer key2 = (Integer) keys[i+1];
            Integer key3 = (Integer) keys[i+2];

            if(strictlyBetween(key2, key, key3)){
                keys[i+1] = -1;
            }
        }

        for (int i = 0; i< MAP.size()-2; ++i){
            int delta = 1;
            Integer key = (Integer) keys[i];
            Integer key2 = (Integer) keys[i+delta];

            int distance = calculateDistance(key, key2);
            while(distance == DEFAULT_DISTANCE && i+delta< MAP.size()-1){
                ++delta;
                key2 = (Integer) keys[i+delta];
                distance = calculateDistance(key, key2);
            }
            if(distance != DEFAULT_DISTANCE){
                if(distance > maxDistance) {
                    maxDistance = distance;
                }
            }
        }
        return maxDistance;
    }

    public static int calculateDistance(int i, int j){

        int distance = DEFAULT_DISTANCE;

        if(i != -1 && j != -1){
            List<Integer> iList = MAP.get(i);
            List<Integer> jList = MAP.get(j);

            distance =
                    iList
                            .stream()
                            .map(integer ->
                                    jList
                                            .stream()
                                            .map(value -> Math.abs(integer - value))
                                            .max(Comparator.naturalOrder())
                                            .orElse(DEFAULT_DISTANCE))
                            .max(Comparator.naturalOrder())
                            .orElse(DEFAULT_DISTANCE);
        }

        return distance;
    }

    public static boolean strictlyBetween(int v, int u, int w){

        return (u<v && v<w) || (w<v && v<u);
    }


}