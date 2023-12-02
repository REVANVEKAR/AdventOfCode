package com.learning;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Day2 {

    public static void main(String[] args) {
        game2();
//        int dummy = gamesPart2("Game 5: 6 red, 1 blue, 3 green; 2 blue, 1 red, 2 green");
//        System.out.println(dummy);
    }


    public static void game(){

        int sum = 0;
        int noOfLines = 0;
        try{
            File txt = new File("src/com/learning/rev3.txt");
            Scanner reader= new Scanner(txt);
            while (reader.hasNextLine()){
                noOfLines++;
                sum += gamesPart1(reader.nextLine());
            }


        }catch (FileNotFoundException e){
            System.out.println("error occurred");
            e.printStackTrace();
        }

        int output = (noOfLines * (noOfLines + 1))/2 - sum;

        System.out.println(output);
    }



    public static int gamesPart1(String s){

        int sum = 0;

//        boolean idAdded = false;
        int id = Integer.parseInt(s.substring(5, s.indexOf(':')));
        String[] turns = s.substring(s.indexOf(":") + 1 ).split(";");

        for (String t1 : turns){

            String[] t2 = t1.split(",");
            for (String c : t2){
                String[] c1 = c.trim().split(" ");
                int num = Integer.parseInt(c1[0]);
                String color = c1[1];

                switch (color){
                    case "red" :
                        if (num > 12){
                            sum += id;
                            return sum;
                        }
                        break;
                    case "green" :
                        if(num>13){
                            sum += id;
                            return sum;
                        }
                        break;
                    case "blue":
                        if (num>14){
                            sum += id;
                            return sum;
                        }
                        break;
                }


            }

        }

        return 0; // dummy return
    }

    public static int gamesPart2(String s){
        int power = 1;

//        boolean idAdded = false;
        int id = Integer.parseInt(s.substring(5, s.indexOf(':')));
        String[] turns = s.substring(s.indexOf(":") + 1 ).split(";");
        Map<String,Integer> map = new HashMap<>();

        for (String t1 : turns){

            String[] t2 = t1.split(",");
            for (String c : t2){
                String[] c1 = c.trim().split(" ");
                int num = Integer.parseInt(c1[0]);
                String color = c1[1];

                if (map.containsKey(color)){
                    map.put(color,Math.max(num , map.get(color)));
                }else {
                    map.put(color,num);
                }


            }

        }
        for (int i : map.values()){
//            System.out.println(i);
            power *= i;
        }

        return power;
    }


    public static void game2(){

        int sum = 0;
//        int noOfLines = 0;
        try{
            File txt = new File("src/com/learning/rev4.txt");
            Scanner reader= new Scanner(txt);
            while (reader.hasNextLine()){
                sum += gamesPart2(reader.nextLine());
            }


        }catch (FileNotFoundException e){
            System.out.println("error occurred");
            e.printStackTrace();
        }

        System.out.println(sum);
    }






}
