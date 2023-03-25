package com.maruti.codility;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class MissingInteger {
public static void main(String[] args) {
	int[] A = new int[] { 1,1,4,2,3,5,9 };
	int[] B = new int[] { 1,2,3 };
	int[] C = new int[] { -1,-3 };
	int[] D = new int[] { 10021,58541,99999 };
	System.out.println(solution(A)); // expected 6
	System.out.println(solution(B)); // expected 4
	System.out.println(solution(C)); // expected 1
	System.out.println(solution(D)); // expected 1
	
	System.out.println(solutionTwo(D));
}

private static int  solutionTwo(int[] A) {
	//special case
    if(A.length ==0){
        return 1;
    }
    
    // Using "set" to check if an element has appeared
    // note: need to "import java.util.*" (important)
    Set<Integer> set = new HashSet<Integer>();
    
    // add elements into the set
    for(int i=0; i< A.length; i++){
        set.add(A[i]);
    }
    
    // note: the missing number is not possible bigger than (A.length)
    //       because there are only (A.length) numbers
    for(int i=1; i<= A.length; i++){
        if(set.contains(i) != true) // the 1st missing element
            return i;
    }
    
    // means: there are no missing numbers from 1 to A.length
    // Therefore, the missing number is "A.length+1" (important)
    return A.length+1;
}

private static int solution(int[] A) {
	// sort and remove duplication
			int[] AN = Arrays.stream(A).filter(n -> n > 0).distinct().sorted().toArray();
	        	int N = AN.length;
	        	int MIN = 1;
	        
			for (int i = 0; i < N; i++) {
			    MIN = i+1;
			    if (AN[i] != MIN) {
			        return MIN;
			    } 
			    else if (MIN == N) {
			        return ++MIN;
			    }
			}
			return MIN;
}
}
