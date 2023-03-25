package com.maruti.codility;

import java.util.Arrays;

public class Distinct {
	public static void main(String[] args) {
		int[] array = new int[] { 2, 1, 1, 2, 3, 1, 4, 4, 7 };
		System.out.println(solution(array));
		System.out.println(solutionAdv(array));
	}

	private static int solutionAdv(int[] array) {
		return (int) Arrays.stream(array).distinct().count();
	}

	private static int solution(int[] array) {
		int count = 0;
		int size = array.length;
		if (size == 0)
			return count;
		Arrays.sort(array);
		for (int i = 1; i < size; i++)
			if (array[i] != array[i - 1])
				count++;
		return count + 1;
	}
}
