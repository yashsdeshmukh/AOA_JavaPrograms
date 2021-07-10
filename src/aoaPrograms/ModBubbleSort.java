package aoaPrograms;

import java.util.Scanner;

public class ModBubbleSort {
	public static void modBubbleSort(int [] a, int n) {
		int i,j,t;
		int exchange = 1;//boolean variable to denote exchange has happened or not in the previous pass
		for(i=1; i<= n-1 && exchange==1 ; i++)
		{
			exchange=0;	//assuming exchange won't happen in this pass

			for(j=0 ; j<n-i ; j++)
			{
				if (a[j] > a[j+1])		//if consecutive elements not in order then swap
				{
					t=a[j];
					a[j]=a[j+1];
					a[j+1]=t;
					exchange=1;//exchange has occured
				}
			}
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
		modBubbleSort(a, n);
		System.out.println("The sorted array is:\t");		//print the sorted elements
		for(int i=0;i<n;i++)
			System.out.println(a[i]);
		sc.close();

	}

}
