package com.theowinter.PumpingLemma;

public class PumpingLemma {

	/**
	 *	http://en.wikipedia.org/wiki/Pumping_lemma
	 */
	
	public static void main(String[] args) {
		System.out.println(binaryDividedByThreeLanguage("10101"));
	}
	
	public static void pump(){
		
	}
	/**
	 * Math2I language containing all words consisting of binary numbers
	 * that can be divided by three. (Note for viewer: yes this could be made
	 * much simpler, the purpose of this methods is no to answer whether a binary
	 * can be divided by three but rather to model the deterministic-finite machine
	 * you can see in the image file that comes with this source.
	 *
	 * @param input
	 * @return
	 */
	public static boolean binaryDividedByThreeLanguage(String input){
		boolean isPartOfLanguage;
		char[] charArray = input.toCharArray();
		int currentStatus = 0;
		for(char check : charArray){
			if(currentStatus == 0){
				currentStatus = status0(Integer.valueOf(check));
			}
			else if(currentStatus == 1){
				currentStatus = status1(Integer.valueOf(check));
			}
			else if(currentStatus == 2){
				currentStatus = status2(Integer.valueOf(check));
			}
		}
		if(currentStatus==0){
			isPartOfLanguage = true;
		}
		else{
			isPartOfLanguage = false;
		}
		return isPartOfLanguage;
	}
	
	private static int status0(int input){
		int nextState;
		if(input == 1){
			nextState = 1;
		}
		else{
			nextState = 0;
		}
		return nextState;
	}
	
	private static int status1(int input){
		int nextState;
		if(input == 1){
			nextState = 0;
		}
		else{
			nextState = 2;
		}
		return nextState;
	}
	
	private static int status2(int input){
		int nextState;
		if(input == 1){
			nextState = 2;
		}
		else{
			nextState = 1;
		}
		return nextState;
	}
}
