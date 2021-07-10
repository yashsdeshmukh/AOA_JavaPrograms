package aoaPrograms;

import java.util.Arrays;
/*
 * Using simple 2 pointer method for sum of subsets and printing the same
 */
public class SumOfSubset {
	static int count = 0;
	static int[] solutionSet = new int[2];

	public static int[] sumOfSubset(int[] array, int sum) {
		Arrays.sort(array);

		int leftIndex = 0;
		int rightIndex = array.length - 1;

		while (array[rightIndex] > sum + array[0]) {
			rightIndex--;
		}

		while (leftIndex < rightIndex) {
			if (array[leftIndex] + array[rightIndex] == sum) {
				count++;
				solutionSet[0] = array[leftIndex];
				solutionSet[1] = array[rightIndex];
				System.out.println("Solution set number " + count + " :- " + solutionSet[0] + " " + solutionSet[1]);
				leftIndex++;
				rightIndex--;
			}
			else if (array[leftIndex] + array[rightIndex] < sum) {
				leftIndex++;
			} 
			else {
				rightIndex--;
			}
		}

		return solutionSet;
	}

	/* Driver program to test above function */
	public static void main(String args[]) {

		int set[] = { 6, 4, 3, 0, 5, 1 };
		int sum = 9;

		sumOfSubset(set, sum);

	}
}
