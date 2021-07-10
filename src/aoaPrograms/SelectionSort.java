package aoaPrograms;

import java.util.Scanner;

public class SelectionSort {
	public static void selectionSort(int [] a, int n) {
		int pass,i, min, pos;
		for(pass=1; pass<=n-1;pass++)
		{
			//code to find minimum in unsorted array pass-1 till n
			min = a[pass-1];//assume first element of the array as minimum 
			pos = pass-1; //minimum element is found at 'pos' position

			for( i = pass; i < n; i++) //iterate through other elements of array
			{
				if( a[i] < min) //if array element is smaller than current minimum
				{
					min = a[i]; //update minimum
					pos = i; //update 'pos'
				}
			}

			//exchange minimum element with element at pass-1
			a[pos] = a[pass-1]; 
			a[pass-1] = min;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("How many numbers?");
		int n = sc.nextInt();
		int[] a = new int[n];
		System.out.println("Enter the numbers");
		for(int i = 0; i<n; i++) {
			a[i] = sc.nextInt();
		}
		selectionSort(a, n);
		System.out.println("The sorted array is:\t");		//print the sorted elements
		for(int i=0;i<n;i++)
			System.out.println(a[i]);
		sc.close();

	}
}
