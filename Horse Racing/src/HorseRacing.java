// Special effects: (Super Loud) Backgrund Music 

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class HorseRacing {

	public static void main(String[] args) throws IOException {
		// THERE IS SOME LOUD BG MUSIC, JUST SAYING
		File bgm = new File("input/bgm.wav"); 
		boolean closeMusic = false;
		PlaySound(bgm, closeMusic); // play music
		introMessage(); 
		String[] horses = getHorses();
		String[] playerNames = getPlayerNames();
		int[] playerWallets = getPlayersWallets(); // attain various arrays
		int numPlayers = playersAmount(); // prompt user for number of players
		System.out.println("");

		boolean gameOver = false;
		while (!gameOver) { // do the race while the user hasn't said no
			doRace(horses, playerNames, playerWallets, numPlayers);
			gameOver = promptForGameOver();
		} 
		updatePlayerData(playerNames, playerWallets); 
		closeMusic = true; // end music
		outroMessage();
	}

	static void PlaySound(File audio, boolean closeMusic) { // play previously loaded music
		try {
			Clip clip = AudioSystem.getClip();
			clip.open(AudioSystem.getAudioInputStream(audio));
			clip.start();

			while (closeMusic) {
				clip.close();
			}

		} catch (Exception e) {
			System.out.println("");
		}
	}

	private static int playersAmount() { //Prompt how many players
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);

		System.out.print("How many players? Between 1 and 5, please. ");
		int players = scanner.nextInt();

		while (!(players == 1 || players == 2 || players == 3 || players == 4 || players == 5)) {
			System.out.print("Please enter a number (1, 2, 3, 4, or 5) only: ");
			players = scanner.nextInt();
		}
		return players;
	}

	private static void introMessage() { // print introductory message
		System.out.println("Welcome to the track! Enjoy your stay, and good luck!");
		System.out.println("");

	}

	private static void outroMessage() { // print closing message
		System.out.println("Thanks for playing! Do make sure to come again.");

	}

	private static void updatePlayerData(String[] playerNames, int[] playerWallets) throws IOException { //updates files with money after bet
		PrintWriter saver = new PrintWriter(new FileWriter("Input/player.dat"));
		saver.print(playerNames.length);
		for (int i = 0; i < playerNames.length; i++) {
			saver.write("\n" + playerNames[i] + " " + playerWallets[i]);
		}
		saver.close();
	}

	private static boolean promptForGameOver() { //prompts user for ending game or not
		@SuppressWarnings("resource")
		Scanner keyboard = new Scanner(System.in);
		System.out.print("Would you like to continue? Y/N ");
		String response = keyboard.nextLine();

		while (!(response.charAt(0) == 'Y' || response.charAt(0) == 'N' || response.charAt(0) == 'y'
				|| response.charAt(0) == 'n') && response.length() == 0) {
			System.out.print("Please only respond with Y for yes or N for no: ");
			response = keyboard.nextLine();
		}
		if (response.charAt(0) == 'n' || response.charAt(0) == 'N') {
			return true;
		}

		return false;
	}

	private static void doRace(String[] horses, String[] playerNames, int[] playerWallets, int numPlayers) { // bulk of program except the race and printing of tables
		// horsesInRace contains the index of the horses from the master horse
		// array
		int numHorses = 86; // amount of horses in race (86), not 86 + 1 like in
							// next line because array indices start 0
		int num = (int) (Math.random() * 4) + 5; // Chooses how many horses
													// (between 5-8)
		int[][] horsesInRace = getHorsesInRace(numHorses, num);
		printPlayers(playerNames, playerWallets);
		@SuppressWarnings("resource")
		Scanner keyboard = new Scanner(System.in);
		int[] players = new int[numPlayers];
		int player, one = 1; // there is a discrepancy of 1 for the difference
								// between array index and player number

		for (int i = 0; i < numPlayers; i++) {
			System.out.print("Player " + (i + one) + ", please select a player by number: ");
			player = Integer.parseInt(keyboard.nextLine());
			while (!(player == 1 || player == 2 || player == 3 || player == 4 || player == 5)) {
				System.out.print("Player " + (i + one) + ", please select a player by number: ");
				player = Integer.parseInt(keyboard.nextLine());
			}
			for (int j = 0; j < i; j++) {
				while (player - one == players[j]) {
					System.out.print("Player " + (i + one)
							+ ", please select a player by number that hasn't been chosen before: ");
					player = Integer.parseInt(keyboard.nextLine());
				}
			}
			players[i] = player - one;
		}

		String response = null;

		// 2D array with col0 = betAmt and col1 = horseIndex(from horsesInRace);
		int[][] playerBets = new int[2][5];

		for (int i = 0; i < numPlayers; i++) {

			System.out.print(playerNames[players[i]] + ", would you like to place a bet? (Y/N) ");
			response = keyboard.nextLine();

			while (!(response.charAt(0) == 'Y' || response.charAt(0) == 'N' || response.charAt(0) == 'y'
					|| response.charAt(0) == 'n') && response.length() != 0) {
				System.out.print("Please only respond with Y for yes or N for no: ");
				response = keyboard.nextLine();
			}

			if (response.charAt(0) == 'Y' || response.charAt(0) == 'y') {
				printHorses(horsesInRace, horses, num);
				System.out.print(
						playerNames[players[i]] + ", please select the number of the horse you would like to bet on: ");
				playerBets[0][i] = Integer.parseInt(keyboard.nextLine());

				while (!(playerBets[0][i] > 0 && playerBets[0][i] < num)) {
					System.out.print("Please select the number of the horse you would like to bet on: ");
					playerBets[0][i] = Integer.parseInt(keyboard.nextLine());
				}

				System.out.print(playerNames[players[i]] + ", how much would you like to bet (you have "
						+ +playerWallets[players[i]] + ")? ");
				playerBets[1][i] = Integer.parseInt(keyboard.nextLine());

				while (!(playerBets[1][i] > 0 && playerBets[1][i] < playerWallets[i])
						|| playerBets[1][i] >= playerWallets[i]) {
					System.out.print("Please enter the number amount that you would like to bet (you have "
							+ +playerWallets[players[i]] + "): ");
					playerBets[1][i] = Integer.parseInt(keyboard.nextLine());
				}
			}
		}

		race(horsesInRace, horses, num, players.length, playerBets); 
		calculate(playerWallets, playerBets, players, one);

	}

	private static void calculate(int[] playerWallets, int[][] playerBets, int[] players, int one) { //adds amount won to player net worth (negative amount if lost)
		for (int i = 0; i < players.length; i++) {
			playerWallets[players[i]] = playerWallets[players[i]] + playerBets[1][i];
		}
	}

	private static void race(int[][] horsesInRace, String[] horses, int num, int players, int[][] playerBets) { 
		// continues until a "horse" reaches the end of the "track"
		while (horsesInRace[1][0] <= 100 && horsesInRace[1][1] <= 100 && horsesInRace[1][2] <= 100
				&& horsesInRace[1][3] <= 100 && horsesInRace[1][5] <= 100 && horsesInRace[1][6] <= 100
				&& horsesInRace[1][7] <= 100) {
			System.out.println(
					"--------------------|-----------------------------------------------------------------------------------------------------|");
			for (int i = 0; i < num; i++) {
				System.out.printf("%-20s|", horses[horsesInRace[0][i]]);

				for (int j = 0; j < horsesInRace[1][i]; j++) {
					System.out.print(" ");
				}

				System.out.print(i);

				for (int l = horsesInRace[1][i] + 1; l < 100; l++) {
					System.out.print(" ");
				}
				System.out.println("");
				System.out.println(
						"--------------------|-----------------------------------------------------------------------------------------------------|");
				horsesInRace[1][i] = horsesInRace[1][i] + (int) (Math.random() * 10);
			}

			try { // waits a few seconds before reprinting
				Thread.sleep(250);
			} catch (InterruptedException ex) {
				Thread.currentThread().interrupt();
			}

			// prints 15 blank lines
			for (int k = 0; k < 15; k++) {
				System.out.println("");
			}
		}

		System.out.println("");

		for (int i = 0; i < horsesInRace[1].length; i++) { //prints horses that have won
			if (horsesInRace[1][i] > 100) {
				System.out.println(horses[horsesInRace[0][i]] + " has won!");
			}
		}

		for (int i = 0; i < playerBets[0].length; i++) { // negates the bet amount so that it gets subtracted when calculating payout/winning
			if (!(horsesInRace[1][playerBets[0][i]] > 100)) {
				playerBets[1][i] = playerBets[1][i] * -1;
			}
		}

		System.out.println("");
	}

	private static void printHorses(int[][] horsesInRace, String[] horses, int num) { //print horse names in table
		System.out.println("");
		System.out.println("#|Horse Name                    |");
		for (int i = 0; i < num; i++) {
			System.out.println("-|------------------------------|");
			System.out.print(i + "|");
			System.out.printf("%-30s|", horses[horsesInRace[0][i]]);
			System.out.println("");
		}
		System.out.println("");
	}

	private static void printPlayers(String[] playerNames, int[] playerWallets) { //print player names in table
		System.out.println("#|Player Names  |   Wallets ");
		int num = 5;
		for (int i = 0; i < num; i++) {
			System.out.println("-|--------------|----------");
			System.out.print(i + 1 + "|");
			System.out.printf("%-14s", playerNames[i]);
			System.out.printf("|%10d", playerWallets[i]);
			System.out.println("");
		}
		System.out.println("");
	}

	private static int[][] getHorsesInRace(int numHorses, int num) { //randomly pick 5-8 horses
		int[][] horsesInRace = new int[2][8];
		int horse;
		boolean repeat = false;

		for (int i = 0; i < num; i++) {
			horse = (int) (Math.random() * numHorses);
			repeat = alreadyInRace(horse, horsesInRace, i);
			while (repeat) { // prevents repetition of horse
				horse = (int) (Math.random() * numHorses);
				repeat = alreadyInRace(horse, horsesInRace, i);
			}
			horsesInRace[0][i] = horse;
		}

		return horsesInRace;
	}

	private static int[] getPlayersWallets() { //reads player.dat file for wallet amounts and stores in array
		int[] wallets = null;
		try {
			@SuppressWarnings("resource")
			Scanner scanner = new Scanner(new File("input/player.dat"));
			int numWallets = Integer.parseInt(scanner.nextLine());
			wallets = new int[numWallets];

			for (int i = 0; i < numWallets; i++) {
				scanner.next();
				wallets[i] = scanner.nextInt();
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		return wallets;
	}

	private static String[] getPlayerNames() { //reads player.dat file for player names and stores in array
		String[] players = null;
		try {
			@SuppressWarnings("resource")
			Scanner scanner = new Scanner(new File("input/player.dat"));
			int numPlayers = Integer.parseInt(scanner.nextLine());
			players = new String[numPlayers];

			for (int i = 0; i < numPlayers; i++) {
				players[i] = scanner.nextLine().split(" ")[0];
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		return players;
	}

	public static boolean alreadyInRace(int horse, int[][] horsesInRace, int index) { // checks if randomly selected horse is being repeated
		for (int i = 0; i < index; i++) {
			if (horsesInRace[0][i] == horse) {
				return true;
			}
		}
		return false;
	}

	public static String[] getHorses() { // reads horses and stores in array from horses.dat
		String[] horses = null;
		try {
			@SuppressWarnings("resource")
			Scanner scanner = new Scanner(new File("input/horses.dat"));
			int numHorses = Integer.parseInt(scanner.nextLine());
			horses = new String[numHorses];

			for (int i = 0; i < numHorses; i++) {
				horses[i] = scanner.nextLine();
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		return horses;
	}

}
