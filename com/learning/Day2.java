package com.learning;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Day2 {

    public static void main(String[] args) {
        game();
    }

    public static void game(){

        int sum = 0;
        int noOfLines = 0;
        try{
            File txt = new File("src/com/learning/rev3.txt");
            Scanner reader= new Scanner(txt);
            while (reader.hasNextLine()){
                noOfLines++;
                sum += games(reader.nextLine());
            }


        }catch (FileNotFoundException e){
            System.out.println("error occurred");
            e.printStackTrace();
        }

        int output = (noOfLines * (noOfLines + 1))/2 - sum;

        System.out.println(output);
    }

    public static int games(String s){

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

    static class game{
        long id;
        List<turn> turns = new ArrayList<>();
    }

    static class turn{
        long red;
        long green;
        long blue;
    }

}
