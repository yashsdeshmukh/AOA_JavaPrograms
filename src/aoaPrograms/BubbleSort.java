package aoaPrograms;

import java.util.Scanner;

public class BubbleSort {
	public static void bubbleSort(int [] a, int n) {
		int i,j,temp;
		for(i = 1; i<= n-1 ; i++) {  //n
			System.out.println("yash");
			for(j=0 ; j<n-i ; j++){  //n 
				System.out.println("Warren");
				if (a[j] > a[j+1]){		//if consecutive elements not in order then swap
					System.out.println("AOA");
					temp=a[j];
					a[j]=a[j+1];
					a[j+1]=temp;	
				}
			}
			
			//for output after every pass, write print in for loop
			
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
		bubbleSort(a, n);
		System.out.println("The sorted array is:\t");		//print the sorted elements
		for(int i=0;i<n;i++)
			System.out.println(a[i]);
		sc.close();
		
	}

}
