package com.maruti.codility;
/**
A small frog wants to get to the other side of the road. The frog is currently located at position X and wants to get to a position greater than or equal to Y. The small frog always jumps a fixed distance, D. Count the minimal number of jumps that the small frog must perform to reach its target.
Write a function:
class Solution { public int solution(int X, int Y, int D); }
that, given three integers X, Y and D, returns the minimal number of jumps from position X to a position equal to or greater than Y.
For example, given:
X = 10 Y = 85 D = 30
the function should return 3, because the frog will be positioned as follows: after the first jump, at position 10 + 30 = 40 after the second jump, at position 10 + 30 + 30 = 70 after the third jump, at position 10 + 30 + 30 + 30 = 100
Assume that:
X, Y and D are integers within the range [1..1,000,000,000];
X ≤ Y.
Complexity:
expected worst-case time complexity is O(1);
expected worst-case space complexity is O(1)
*/
public class FrogJump {
public static void main(String[] args) throws Exception {
	int A = 10;
	int B = 85;
	int D = 30;
	System.out.println(solutionAdv(A, B, D));
	System.out.println(solution(A, B, D));
}

private static int solution(int X, int Y, int D) {
	long difference = Y - X;
	long plus =0; // note: need to decide if to "plus one" or not
	if( difference % D !=0 ) // using "mod" to decide
        plus =1;             // if not "perfectly Divisible", then plus one 
    
    long hop =0; // number of hops the frog needs to jump
    
    hop = difference / D;
    
    hop = hop + plus;
    
    return (int)hop; // return number of hops (long -> int)
}

private static int solutionAdv(int a, int b, int d) throws Exception {
	if (b < a) 
		throw new Exception("b can't be less than a");

	return (int) Math.ceil(((double) b - a) / d);
}
}
