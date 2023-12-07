package com.learning;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Day7 {



    public static void main(String[] args) {

        List<String> input = new ArrayList<>();

        try {
            File fs = new File("com/learning/day7txt.txt");
            Scanner sc = new Scanner(fs);
            while (sc.hasNextLine()){
                input.add(sc.nextLine());
            }

        }
        catch (FileNotFoundException e){
            System.out.println("error aaya re");
        }

        part1(input);

    }

    public static void part1(List<String> input) {

    }



}
