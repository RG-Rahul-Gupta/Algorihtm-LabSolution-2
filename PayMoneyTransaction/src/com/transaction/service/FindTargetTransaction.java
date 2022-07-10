package com.transaction.service;

import java.util.Scanner;

public class FindTargetTransaction {
	private static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {

		System.out.println("Enter the no. of Transactions per day");
		int size = sc.nextInt();

		int[] transactionArray = new int[size];

		System.out.println("Enter the Transactions now -");

		for (int index = 0; index < size;) {
			int transaction = sc.nextInt();
			if (transaction > 0) {
				transactionArray[index] = transaction;
				index++;
			}
		}
		System.out.println("Enter the no. of Targets =");
		int noOfTarget = sc.nextInt();
		printNoOfTransactions(transactionArray, noOfTarget);

	}

	private static void printNoOfTransactions(int[] transactionArray, int noOfTarget) {
		while (noOfTarget > 0) {
			System.out.println("Enter the Daily Target =");
			int target = sc.nextInt();
			int transactionCount = getNumberofTransactions(transactionArray, target);
			if (transactionCount > 0) {
				System.out.println("The number of Transactions to Achieve the Target =" + (transactionCount));
			} 
			else {
				System.out.println("No. of Targets insufficient to Achieve Target");
			}
			noOfTarget--;
		}
	}

	private static int getNumberofTransactions(int[] transactionArray, int target) {
		int transactionCount = 0;
		int sum = 0;
		int size = transactionArray.length;
		while (sum <= target && transactionCount < size) {
			sum = sum + transactionArray[transactionCount];
			transactionCount++;
		}
		if (transactionCount >= size) {
			return -1;
		} else {
			return transactionCount;
		}

	}

}
