package com.currency.service;

public class NotesCounter {
public int[] notesCount(int[] denominationsArray, int payableValue ) {
	int notesCounter[] = new int[denominationsArray.length];
		for(int i=0; i<denominationsArray.length; i++) {
			if(payableValue>=denominationsArray[i]) {
				notesCounter[i] = payableValue/denominationsArray[i];
				payableValue = payableValue%denominationsArray[i];
			}
		}
		if(payableValue>0) {
			System.out.println("The Exact amount can not be reached by provided denominations ");
			return notesCounter;
		}
		else {
			return notesCounter;
		}
	
}
}
