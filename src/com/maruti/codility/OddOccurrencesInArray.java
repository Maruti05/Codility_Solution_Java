package com.maruti.codility;

import java.util.HashSet;
import java.util.Set;

public class OddOccurrencesInArray {

	public static void main(String[] args) {
		int A[]=new int[] { 9, 3, 9, 3, 9, 7, 9, 7, 7, 1, 1, 4 };
		System.out.println(solution(A));
		System.out.println(solutionTwo(A));
	}

	private static int solutionTwo(int[] A) {
		Set<Integer> set = new HashSet<Integer>(A.length / 2);

		for (int i = 0; i < A.length; i++) {
			if (set.contains(A[i])) set.remove(A[i]);
			 else set.add(A[i]);
		}

		return (int) set.toArray()[0];
	}

	private static int solution(int[] A) {

        // Using the concept of "XOR" (^)
        // when there is a pair A and B 
        // A^B will be zero 
        // A^B^C (where C is not paired), 
        // then A^B^C = C
        
        // special case
        if(A.length == 0)
            return 0;
        
        int unpaired;
        unpaired = A[0]; // initial
        
        for(int i=1; i< A.length; i++){    
            unpaired = unpaired ^ A[i]; // xor    
        }
        
        return unpaired; // return the unpaired value
	}

}
