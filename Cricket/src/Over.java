import java.util.ArrayList;

public class Over {

	boolean boolPlayer1 = true;
	boolean boolPlayer2 = false;
	boolean tempPlayer = false;
	int totalRun = 0;
	int wicketDown = 0;

	int run1 = 1;
	int run2 = 2;
	int run3 = 3;
	int run4 = 4;
	int totalOver = 2;

	int runPerBall = 2;
	int tempRun = 0;
	int player1Run = 0;
	int player2Run = 0;
	int tempPlayerRun = 0;
	int temId = 0;
	int playerNumber = 1;
	int tempBall = 0;

	ArrayList<Integer> runOverIntList = new ArrayList();
	ArrayList<Integer> playerRunList = new ArrayList();
	ArrayList<Boolean> boolPlayerList = new ArrayList();
	ArrayList<Integer> runThisOver = new ArrayList();
	ArrayList<String> playerName = new ArrayList();
	ArrayList<Integer> ballPlayedList = new ArrayList();

	void checker() {

		playerName.add("Hemant");
		playerName.add("Alpesh");
		playerName.add("Arpit");
		playerName.add("Ashokian");
		playerName.add("Piyush");
		playerName.add("Arjit");
		System.out.println("Plyer List : " + playerName);

		ballPlayedList.add(0);
		ballPlayedList.add(0);
		ballPlayedList.add(0);
		ballPlayedList.add(0);
		ballPlayedList.add(0);
		ballPlayedList.add(0);
		System.out.println("BallPlayed : " + ballPlayedList);

		runOverIntList.add(1);
		runOverIntList.add(2);
		runOverIntList.add(1);
		runOverIntList.add(1);
		System.out.println("This over Run :" + runOverIntList);

		playerRunList.add(0);
		playerRunList.add(0);
		playerRunList.add(0);
		playerRunList.add(0);
		playerRunList.add(0);
		playerRunList.add(0);

		System.out.println("Player  Run :" + playerRunList);

		boolPlayerList.add(true);
		boolPlayerList.add(true);
		boolPlayerList.add(false);
		boolPlayerList.add(false);
		boolPlayerList.add(false);
		System.out.println("Boolean  Run :" + boolPlayerList);

		runThisOver.add(1);
		runThisOver.add(2);
		runThisOver.add(9);
		runThisOver.add(1);
		runThisOver.add(2);
		runThisOver.add(1);

		System.out.println("This over  Run :" + runThisOver);

		for (int k = 1; k <= totalOver; k++) {
			for (int j = 0; j < runThisOver.size(); j++) {
				System.out.println();
				System.out.println("--------");
				if (runThisOver.get(j) == 1 || runThisOver.get(j) == 3 || runThisOver.get(j) == 5) {
					System.out.println("tempId " + temId);

					tempPlayerRun = playerRunList.get(temId);
					System.out.println("tempPlayerRun " + tempPlayerRun);

					tempPlayerRun = tempPlayerRun + runThisOver.get(j);
					totalRun = totalRun + runThisOver.get(j);
					System.out.println("updated " + tempPlayerRun);

					playerRunList.set(temId, tempPlayerRun);
					tempBall = ballPlayedList.get(temId);
					tempBall++;
					ballPlayedList.set(temId, tempBall);

					for (int i = 0; i < boolPlayerList.size(); i++) {

						if (boolPlayerList.get(i) && temId != i) {

							temId = i;
							System.out.println("====== " + temId);
							break;

						}

					}
					System.out.println("Ball " + (j + 1) + "= " + playerRunList);

				}
				if (runThisOver.get(j) == 0 || runThisOver.get(j) == 2 || runThisOver.get(j) == 4
						|| runThisOver.get(j) == 6) {

					System.out.println("tempId " + temId);
					tempPlayerRun = playerRunList.get(temId);
					System.out.println("tempPlayerRun " + tempPlayerRun);

					tempPlayerRun = tempPlayerRun + runThisOver.get(j);
					System.out.println("updated " + tempPlayerRun);
					totalRun = totalRun + runThisOver.get(j);

					playerRunList.set(temId, tempPlayerRun);
					System.out.println("Ball " + (j + 1) + "= " + playerRunList);

					tempBall = ballPlayedList.get(temId);
					tempBall++;
					ballPlayedList.set(temId, tempBall);
				}
				// agar out hua to
				if (runThisOver.get(j) == 9) {

					tempBall = ballPlayedList.get(temId);
					tempBall++;
					ballPlayedList.set(temId, tempBall);
					wicketDown++;
					boolPlayerList.set(temId, false);
					playerNumber++;
					boolPlayerList.set(playerNumber, true);
					temId = playerNumber;

				}
				System.out.println("Updated Run = " + playerRunList);
			}

			// Strike change
			for (int i = 0; i < boolPlayerList.size(); i++) {

				if (boolPlayerList.get(i) && temId != i) {

					temId = i;
					System.out.println("====== " + temId);
					break;

				}

			}

			// print scoreboard
			System.out.println("-----------------------------------------");
			System.out.println("PlayerName          Run   Ball  4     6  ");
			System.out.println("-----------------------------------------");
			for (int m = 0; m < playerName.size(); m++) {
				String formattedString = String.format("%-20s %-5s %-5s", playerName.get(m), playerRunList.get(m),
						ballPlayedList.get(m));
				System.out.println(formattedString);
			}
			System.out.println("-----------------------------------------");
			System.out.println("Total Run : " + totalRun + "/"+wicketDown+"       Overs : " + "" + k);
			System.out.println("-----------------------------------------");

		}
	}

}
