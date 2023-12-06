package com.learning;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Day4 {

    static class Card {
        int index;
        int copies = 1;

        List<Integer> left;
        List<Integer> right;

        Card(String s){
            int i1 = s.indexOf(':');
            int i2 = s.indexOf('|');

            index = Integer.parseInt(s.substring(5, i1).trim());

            left = Arrays.stream(s.substring(i1+1,i2).split(" ")).filter(t -> !"".equals(t))
                    .map(Integer::parseInt).toList();
            right = Arrays.stream(s.substring(i2+1).split(" ")).filter(t -> !"".equals(t))
                    .map(Integer::parseInt).toList();
        }
        int score(){
            int count = hits();
            if (count == 0){
                return 0;
            }
            return 1 << (count -1); // learnt smthg new here
        }

        int hits(){
            Set<Integer> hits = new HashSet<>(left); // kinda here too
            hits.retainAll(right);
            return hits.size();
        }

    }

    public static void part1(List<String> input){
        List<Card> cards = input.stream().filter(s -> !"".equals(s)).map(s -> new Card(s)).toList();

        int sum = cards.stream().map(c -> c.score()).reduce((a,b)-> a+b).orElse(0);

        System.out.println(sum);
    }

    public static void part2(List<String> input) {
        List<Card> cards = input.stream().filter(s -> !"".equals(s)).map(s -> new Card(s)).toList();

        for (int i = 0; i< cards.size(); i++){
            Card c = cards.get(i);
            int m = cards.get(i).copies;
            int f = c.hits();
            for (int j = i+1; j <Math.min(i + f + 1 , cards.size()); j++){
                cards.get(j).copies += m;
            }
        }

        System.out.println(cards.stream().map(c -> c.copies).reduce((a,b) -> a + b).orElse(0));

    }

    public static void main(String[] args) {

        List<String> input = new ArrayList<>();

        try {
            File file = new File("src/com/learning/rev6.txt");
            Scanner text = new Scanner(file);
            while (text.hasNextLine()){
                input.add(text.nextLine());
            }

        }catch (FileNotFoundException e){
            System.out.println("error he ");
        }

        part2(input);


    }
}
