package com.learning;

import java.util.Arrays;
import java.util.List;

public class Day6 {



    public static void main(String[] args) {
        List<Integer> time = Arrays.asList(40,81,77,72);
        List<Integer> distance = Arrays.asList(219, 1012, 1365, 1089);

        part1(time,distance);

        long time2 = Long.parseLong(time.toString().replaceAll("\\D",""));
//        System.out.println(time2);

        long distance2 = Long.parseLong(distance.toString().replaceAll("\\D",""));



        part2(time2, distance2);



    }

    public static void part1(List<Integer> time, List<Integer> distance){
        int product = 1;
        for (int i = 0; i < time.size(); i++){
            product *= beatRecord(time.get(i) , distance.get(i));
        }

        System.out.println(product);



    }

    public static void part2(long time, long distance){
        long min = 0;
        for (long i = 0 ; i< time ; i++) {
            long ownDistance = i * (time - i);
            if (ownDistance > distance){
                min = i;
                break;
            }
        }
        long max = 0;

        for (long i = time; i> 0 ; i-- ){
            long ownDistance = i * (time - i);
            if(ownDistance>distance){
                max = i;
                break;
            }
        }

        System.out.println(max - min + 1);
    }

    public static int beatRecord(int time, int distance){
        int min = 0 ;
        for (int i = 1; i < time; i++ ){
            long ownDistance = i * (time - i);
            if (ownDistance > distance){
                min = i;
                break;
            }

        }

        int max = 0;
        for (int i = time - 1; i > 0; i--){
            int ownDistance = i * (time - i);
            if (ownDistance > distance){
                max = i;
                break;
            }
        }

        return max - min + 1;
    }
}
