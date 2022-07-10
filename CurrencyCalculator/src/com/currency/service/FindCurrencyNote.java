package com.currency.service;

import java.util.Scanner;

public class FindCurrencyNote {
	
	public static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		System.out.println("Please Enter the No. of Different Denominations available");
		int noOfUniqueDenominations = sc.nextInt();
		int[] denominationsArray = new int[noOfUniqueDenominations];
		System.out.println("Please Enter the Value of Denominations Available");
		
		for(int index=0; index<noOfUniqueDenominations;) {
			int denominations = sc.nextInt();
			if (denominations > 0) {
				denominationsArray[index] = denominations;
				index++;
			}
		}
		System.out.println("/n Please Enter the Value to be Paid off = ");
		int payableValue = sc.nextInt();
		
		ReverseMergeSort.reversemergeSort(denominationsArray,0,(denominationsArray.length-1));
		for(int i=0; i<denominationsArray.length; i++) {
			System.out.print(denominationsArray[i]+",");
		}
		System.out.println();
		NotesCounter notesCounter = new NotesCounter();
		int[] notesCounterArray = notesCounter.notesCount(denominationsArray, payableValue);
		
		System.out.println("No. of Denominations required are shown below as -"+"Value of Denomination : No. of Denominations");
		
		for (int i=0; i<notesCounterArray.length;i++) {
			System.out.println(denominationsArray[i]+":"+notesCounterArray[i]);
		}
		
		
	}

}
