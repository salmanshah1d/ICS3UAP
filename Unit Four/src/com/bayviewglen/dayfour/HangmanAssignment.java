package com.bayviewglen.dayfour;

import java.util.Scanner;

public class HangmanAssignment {

	public static void main(String[] args) {
		// Declare all variables
		final int MAX_ROUNDS = 10, WHOSE_TURN = 2, MAX_TRIES = 8, SPACES = 20;
		final String ALPHANUM = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789",
				ALPHANUM_SPACED = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789 ";
		String userOne, userTwo, giver, guesser, givenPhrase, guessedPhrase = "", guessedLetter = "", blank = "",
				choice = "0", alphabet = ALPHANUM, givenNoSlash = "";
		int scoreOne = 0, scoreTwo = 0, round = 0, tries;
		boolean continueGame = true, continueRound = true, isValid = true, isNotRepeated = true;
		Scanner keyboard = new Scanner(System.in);
		
		
		// Ask names
		System.out.print("Player one, please enter your first and last name: ");
		userOne = keyboard.nextLine().split(" ")[0];

		System.out.print("Player two, please enter your first and last name: ");
		userTwo = keyboard.nextLine().split(" ")[0];

		// Only do another round if the game is to be continued
		while (continueGame) {
			
			// Determine whose turn it is to guess
			if (round % WHOSE_TURN == 0) {
				giver = userOne;
				guesser = userTwo;
			} else {
				giver = userTwo;
				guesser = userOne;
			}

			// Ask giver to give phrase
			System.out.print(giver + ", please enter a phrase for " + guesser + " to guess: ");
			givenPhrase = keyboard.nextLine().toUpperCase();

			// check if phrase is valid
			for (int i = 0; i < givenPhrase.length() && isValid == true; i++) {
				if (ALPHANUM_SPACED.indexOf(givenPhrase.charAt(i)) != -1) {
					isValid = true;
				} else {
					isValid = false;
				}
			}

			// keep prompting user for phrase until valid phrase is entered
			while (!(isValid)) {
				
				System.out.print(giver + ", please enter an alphanumeric phrase: ");
				givenPhrase = keyboard.nextLine().toUpperCase();

				isValid = true;
				for (int j = 0; j < givenPhrase.length() && isValid == true; j++) {
					if (ALPHANUM_SPACED.indexOf(givenPhrase.charAt(j)) != -1) {
						isValid = true;
					} else {
						isValid = false;
					}
				}
			}

			// clear blank and alphabet for next round
			blank = "";
			alphabet = ALPHANUM;
			
			// fill blank with "_" or "\" based on whether the index is a space or not
			for (int i = 0; i < givenPhrase.length(); i++) {
				if (givenPhrase.charAt(i) == ' ') {
					blank = blank + "\\";
				} else {
					blank = blank + "_";
				}
			}

			// Reset all variables relating to tries loop
			tries = 0;
			guessedPhrase = "";
			guessedLetter = "";
			continueRound = true;

			for (int n = 0; n < SPACES; n++){
				System.out.println("");
			}
			
			System.out.println("–––––––––––––––––––––––––––––––––––" + guesser + "'s turn–––––––––––––––––––––––––––––––––––");
			
			// Tries loop: Go through all 8 turns or until correctly guessed
			while (continueRound) {
				
				// Ask for input on choice or not to continue, up until the last round.
				if (tries != 7){
					System.out.print(guesser + ", would you like to guess the phrase (1) or a letter (2)? ");
					choice = keyboard.nextLine();
				}

				// Check input for choice
				while (choice.length() == 0 || (choice.charAt(0) != '1' && choice.charAt(0) != '2')) {
					System.out.println(guesser + ", please only enter 1 to guess the phrase or 2 to guess a letter: ");
					choice = keyboard.nextLine();
				}
				
				// Check phrase or letters based on if choice was 1 or 2
				if (choice.charAt(0) == '1' || tries == 7) {
					
					System.out.println("");
					
					// Force user to enter phrase on last try
					if (tries == 7){
						System.out.print(guesser + ", you have run out of tries. Please guess the phrase: ");
					} else {
						System.out.print("Alright, " + guesser + ", please enter the phrase: ");
					}

					// Prompt user for guess and check validity
					guessedPhrase = keyboard.nextLine().toUpperCase();

					for (int m = 0; m < guessedPhrase.length() && isValid == true; m++) {
						if (ALPHANUM_SPACED.indexOf(guessedPhrase.charAt(m)) != -1) {
							isValid = true;
						} else {
							isValid = false;
						}
					}

					while (!(isValid)) {
						System.out.print(guesser + ", please enter an alphanumeric phrase: ");
						guessedPhrase = keyboard.nextLine().toUpperCase();

						isValid = true;
						for (int n = 0; n < guessedPhrase.length() && isValid == true && guessedLetter.length() == 1; n++) {
							if (guessedPhrase.length() > 0 && ALPHANUM_SPACED.indexOf(guessedPhrase.charAt(n)) != -1) {
								isValid = true;
							} else {
								isValid = false;
							}
						}
					}

					// Check if the phrase entered by the user is correct 
					if (givenPhrase.equals(guessedPhrase)) {
						System.out.println("Congratulations, " + guesser + "! You have guessed the phrase.");
					} else {
						System.out.println("Sorry, " + guesser + " please try again.");
					}

				} else if (choice.charAt(0) == '2') {

					// Prompt user and check validity of the phrase (has not occurred before + is alphanumeric)
					System.out.print(guesser + ", please enter a single alphanumeric letter: ");
					guessedLetter = keyboard.nextLine().toUpperCase();
					
					if (tries > 0 && alphabet.indexOf(guessedLetter) != -1){
						isNotRepeated = true;
					} else if (tries == 0) {
						isNotRepeated = true;
					} else {
						isNotRepeated = false;
					}
					
					if (isValid && guessedLetter.length() == 1 && ALPHANUM.indexOf(guessedLetter) != -1 && isNotRepeated) {
							isValid = true;
						} else {
							isValid = false;
						}
					

					while (!(isValid)) {
						
						System.out.print(guesser + ", please enter a single alphanumeric letter: ");
						guessedLetter = keyboard.nextLine().toUpperCase();

						if (alphabet.indexOf(guessedLetter) != -1){
							isNotRepeated = true;
						} else if (tries == 0) {
							isNotRepeated = true;
						} else {
							isNotRepeated = false;
						}
						
						isValid = true;
						
						if (isValid && guessedLetter.length() == 1 && ALPHANUM.indexOf(guessedLetter) != -1 && isNotRepeated) {
							isValid = true;
						} else {
							isValid = false;
						}
					}

					
					// Replace index in blank variable if the user guessed a letter correctly
					if (givenPhrase.indexOf(guessedLetter) != -1){
						for (int k = 0; k < givenPhrase.length(); k++) {
							if (givenPhrase.charAt(k) == guessedLetter.charAt(0)) {
								blank = blank.substring(0, k) + guessedLetter + blank.substring(k + 1);
							}
						}
					}
					
					// Replace index in used alphabet list if the user guessed a letter correctly
					for (int l = 0; l < ALPHANUM.length(); l++) {

						if (alphabet.charAt(l) == guessedLetter.charAt(0)) {
							alphabet = alphabet.substring(0, l) + "_" + alphabet.substring(l + 1);
						}
					}
					
					System.out.println("");
					System.out.println(blank);
					System.out.println(alphabet);
				}
				tries++;
				System.out.println("Tries: " + tries);
				System.out.println("");
				
				for (int m = 0; m < givenPhrase.length() && givenPhrase.length() != givenNoSlash.length(); m++){
					if (givenPhrase.charAt(m) != ' ') {
						givenNoSlash = givenNoSlash + givenPhrase.charAt(m);
					} else {
						givenNoSlash = givenNoSlash + "\\";
					}
				}
				
				if (blank.equals(givenPhrase) || blank.equals(givenNoSlash)){
					System.out.println("Congratulations, " + guesser + "! You have guessed the word.");
				}
				
				// Determine whether or not to continue the round.
				if (tries < MAX_TRIES && !guessedPhrase.equals(givenPhrase) && !(blank.equals(givenPhrase) || blank.equals(givenNoSlash))) {
					continueRound = true;
				} else {
					continueRound = false;
				}
			}
			
			// Determines score and prints it
			System.out.println("–––––––––––––––––––––––––––––––––––Total Score–––––––––––––––––––––––––––––––––––");
			
			if (guesser == userOne && (guessedPhrase.equals(givenPhrase) || blank.equals(givenPhrase) || blank.equals(givenNoSlash))) {
				scoreOne = scoreOne + 8 - tries + 1;
				System.out.println(userOne + "'s score is: " + scoreOne);
				System.out.println(userTwo + "'s score is: " + scoreTwo);
				
			} else if (guesser == userTwo && (guessedPhrase.equals(givenPhrase) || blank.equals(givenPhrase) || blank.equals(givenNoSlash))) {
				scoreTwo = scoreTwo + 8 - tries + 1;
				System.out.println(userOne + "'s score is: " + scoreOne);
				System.out.println(userTwo + "'s score is: " + scoreTwo);
				
			} else if (guesser == userOne) {
				System.out.println(userOne + "'s score is: " + scoreOne);
				System.out.println(userTwo + "'s score is: " + scoreTwo);
				
			} else if (guesser == userTwo){
				System.out.println(userOne + "'s score is: " + scoreOne);
				System.out.println(userTwo + "'s score is: " + scoreTwo);
			}
			
			System.out.println("–––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––");
			System.out.println("");
			
			
			round++;
			
			// Determine whether or not to continue the game
			if (round < MAX_ROUNDS || (round < MAX_ROUNDS && scoreOne == scoreTwo)) {
				continueGame = true;
			} else {
				continueGame = false;
			}

		}
	}
}