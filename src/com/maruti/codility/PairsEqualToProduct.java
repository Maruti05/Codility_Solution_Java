package com.maruti.codility;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class PairsEqualToProduct {
	 static class Pairs {
	        private int x;
	        private int y;

	        public Pairs(int x, int y) {
	            this.x = x;
	            this.y = y;
	        }

	        @Override
	        public String toString() {
	            return "{" + x + "," + y + "}";
	        }
	    }
	

	private static void print(List<Pairs> pairs) {
		pairs.forEach(System.out::println);
        System.out.println(" # of pairs: " + pairs.size());		
	}

	private static List<Pairs> findPairs(int sum, List<Integer> listOfSum) {
		List<Pairs> pairs = new ArrayList<>();

        IntStream.range(0, listOfSum.size())
                .forEach(i -> IntStream.range(i, listOfSum.size())
                        .filter(j -> i != j && listOfSum.get(i) * listOfSum.get(j) == sum)
                        .forEach(j -> pairs.add(new Pairs(listOfSum.get(i), listOfSum.get(j))))
                );

        return pairs;
	}
	public static void main(String[] args) {
		PairsEqualToProduct.print(PairsEqualToProduct.findPairs(400, Arrays.asList(10, 20, 9, 40)));
	        System.out.println("------------------");

	        print(findPairs(1906, Arrays.asList(10, 20, 9, 40)));
	        System.out.println("------------------");

	        print(findPairs(400, Arrays.asList(-10, 20, 9, -40)));
	        System.out.println("------------------");

	        print(findPairs(-400,Arrays.asList(-10, 20, 9, 40,-10)));
	        System.out.println("------------------");

	}

}
