package com.learning;
import java.io.File;
import java.io.FileNotFoundException;
import java.rmi.MarshalledObject;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your coe here
//        part1();
        part2();
    }

    public static void part2(){
        int sum = 0;

        try{
            File advOfCode = new File("src/com/learning/rev2.txt");
            Scanner reading = new Scanner(advOfCode);
            while (reading.hasNextLine()){
                sum += numberFromString2(reading.nextLine());
            }
        }catch (FileNotFoundException e){
            System.out.println("error aya gandu");
            e.printStackTrace();
        }

        System.out.println(sum);
        //same shit as part1 bhai just the string to number function
        // will be a bit more exciting
    }

    public static int numberFromString2(String s){
        Map<Integer,Integer> elvishBhai = new HashMap<>();

        for (int i = 0; i< s.length(); i++){
            char c = s.charAt(i);
            if (c >= '0' && c <='9'){
                elvishBhai.put(i, c-'0'); // if found a number
                // just add it to the hashMap with index
                // index needed to like find out which was the
                // first and last occuring element to form a number and
                // return and add and get solution and get a star :)
            }
        }

        Map<String, Integer> wordedNumbers = new HashMap<>();

        wordedNumbers.put("one",1 );
        wordedNumbers.put("two",2 );
        wordedNumbers.put("three", 3);
        wordedNumbers.put("four",4 );
        wordedNumbers.put("five",5 );
        wordedNumbers.put("six",6 );
        wordedNumbers.put("seven",7 );
        wordedNumbers.put("eight",8 );
        wordedNumbers.put("nine", 9);

        for (Map.Entry<String, Integer> e : wordedNumbers.entrySet()){
            String tatabyebye = e.getKey();

            int i = s.indexOf(tatabyebye);
            // checking if tatabyebye is found in the main String
            // ok so we are iterating over one-nine in worded numbers and
            // checking if the string s has any of them and adding them in elvish
            // bhai map if found with index ( why index ? read the above comments )

            while(i>=0){
                elvishBhai.put(i, e.getValue());
                i = s.indexOf(tatabyebye, i + 1);
                // why this line? well cuz u cant check aadha string
                // cuz there can be multiple worded digits in the substring
                // hence search again from i+1 only
            }
        }
        int lowIndex = elvishBhai.keySet().stream().reduce(Math::min).orElse(0);
        int highIndex = elvishBhai.keySet().stream().reduce(Math::max).orElse(0);
        // fancy/compact way of finding out first and last index from map

        int left = elvishBhai.get(lowIndex);
        int right = elvishBhai.get(highIndex);
        return left * 10 + right;

    }




    public static void part1(){
        int sum = 0;

        try{
            File advOfCode = new File("src/com/learning/rev.txt");
            Scanner reading = new Scanner(advOfCode);
            while (reading.hasNextLine()){
                sum += numberFromString(reading.nextLine());
            }
        }catch (FileNotFoundException e){
            System.out.println("error aya gandu");
            e.printStackTrace();
        }

        System.out.println(sum);
    }

    public static int numberFromString(String s){
        List<Integer> numbers = s.chars().filter(c -> c >= '0').filter(c -> c <= '9').map(c->c -'0').boxed().toList();
        // fancy code i just learnt . basically iterating over the string adding filter functions and then subtracting
        // with '0'  to get the true integer value before we add it to the list
        int left =  numbers.get(0); // for the left number
        int right = numbers.get(numbers.size() - 1); // whatever the number is in the last index

        return left * 10 + right; // two digit number isliye left *10

    }

}
