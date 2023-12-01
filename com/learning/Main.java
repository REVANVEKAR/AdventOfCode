package com.learning;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your coe here
        part1();
    }

    public static void part2(){
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
        //same shit as part1 bhai just the string to number function
        // will be a bit more exciting
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
