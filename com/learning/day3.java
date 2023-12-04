package com.learning;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class day3 {

    public static void main(String[] args) {

        List<String> input = new ArrayList<>();

        try {
            File txt = new File("src/com/learning/rev5.txt");
            Scanner sc = new Scanner(txt);
            while (sc.hasNextLine()){
                input.add(sc.nextLine() );
            }


        }catch (FileNotFoundException e){
            System.out.println("error" + e);
        }

        part1(input);

    }

    // ok so the approach is just iterate through the text file/ input
    // and create two functions lookTopAndBottom and lookLeftAndRight
    // which will be called by findPartNumbers
    // and we can create a list of strings instead of using File class

    public static void part1(List<String> input){


        List<Long> partNumbers = new ArrayList<>();


        for (int i = 0; i < input.size(); i++){
            String line = input.get(i);
            for (int j = 0 ; j < line.length(); j++){
                char c = line.charAt(j);
                if (c != '.' && (c < '0' || c > '9')){
                    findPartNumbers(input, i , j , partNumbers);
                }
            }
        }

        List<Long> newList = partNumbers.stream().distinct().collect(Collectors.toList());

        System.out.println(newList.stream().map(l -> "" + l).sorted().collect(Collectors.joining(",")));
        System.out.println(newList.stream().collect(Collectors.summarizingLong(l -> l)).getSum());
    }

    private static void findPartNumbers(List<String> input, int i , int j , List<Long> partNumbers){
        if (i>0){
            String l = input.get(i-1);
            searchTopOrBottom(l,j,partNumbers);
        }
        if (i<input.size()-1){
            String l = input.get(i+1);
            searchTopOrBottom(l,j,partNumbers);
        }
        searchLeftAndRight(input.get(i),j,partNumbers );
    }

    public static void searchTopOrBottom(String l, int j , List<Long> partNumbers){
        char c =l.charAt(j);
        if (c>= '0' && c <= '9'){
            int k = j-1;
            while (k >= 0){
                char d = l.charAt(k);
                if (d >= '0' && d <= '9'){
                    k--;
                }else{
                    k++;
                    break;
                }
            }
            if (k<0) {
                k = 0;
                int m = j + 1;
                while (m < l.length()) {
                    char d = l.charAt(m);
                    if (d >= '0' && d <= '9') {
                        m++;
                    } else {
                        break;
                    }
                }
                partNumbers.add(Long.parseLong(l.substring(k,m)));
            }
        }else{
            searchLeftAndRight(l,j,partNumbers);
        }
    }

    public static void searchLeftAndRight(String l , int j , List<Long> partNumbers){
        int k = j-1;
        while(k >= 0){
            char d = l.charAt(k);
            if (d >= '0' && d <= '9'){
                k--;
            }else{
                k++;
                break;
            }
        }
        if (k<0){
            k = 0;
        }
        if (k <j){
            partNumbers.add(Long.parseLong(l.substring(k,j)));
        }
        int m = j+1;
        while (m < l.length()){
            char d = l.charAt(m);
            if (d >= '0' && d <= '9'){
                m++;
            }else{
                break;
            }
        }

        if (m > j + 1){
            partNumbers.add(Long.parseLong(l.substring(j+1,m)));
        }
    }

}
