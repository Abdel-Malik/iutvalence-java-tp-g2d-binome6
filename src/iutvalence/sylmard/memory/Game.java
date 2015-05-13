package iutvalence.sylmard.memory;

import java.util.Scanner;

/**
 * Game: a player and a grid.
 *
 * @author aymardh sylvestr
 * @version 1.1
 */
public class Game {

	/** Game's player. */
	private final Player player;

	/** Game's grid. */
	private final Grid grid;

	/** Constructor of the game, we need his name and the level of the game. */
	public Game(final String name, final int level) {
		/* TODO Code the parameter's checking */
		player = new Player(name);
		grid = new Grid(level);
	}

	/** Start the game. */
	public void start() {
		System.out.println(grid);
	}

	/** Play a game. */
	public void play() {
		Scanner sc = new Scanner(System.in);

		while (!victory()) {
			int i, j;
			boolean good;
			do {
				good = true;
				System.out
						.println("Veuillez saisir les coordonn�es de la carte � retourner :");
				i = sc.nextInt();
				j = sc.nextInt();
				if (i > 3 || i < 0 || j < 0 || j > 3) {
					System.err
							.println("Vous avez saisi de mauvaises coordonn�es !");
					good = false;
				}
			} while (!good);

			System.out.println("Vous avez saisi les coordonn�es : (" + i + "," + j + ")");
			int val1 = grid.swap(i, j);
			System.out.println(grid);

			int x, y;
			do {
				good = true;
				System.out.println("Veuillez saisir les coordonn�es de la seconde carte � retourner :");
				x = sc.nextInt();
				y = sc.nextInt();
				if (x > 3 || x < 0 || y > 3 || y < 0 || (x == i && y == j)) {
					System.err.println("Vous avez saisi de mauvaises coordonn�es !");
					good = false;
				}
			} while (!good);
			System.out.println("Vous avez saisi les coordonn�es : (" + x + "," + y + ")");
			int val2 = grid.swap(x, y);
			System.out.println(grid);
			
			
			// TODO val1 != val2 ??? -> Retourner les cartes � nouveaux.
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) { /* NOTHING */ }
			
			// TODO metho
			
		}
	}
	
	/** Test the victory */
	private boolean victory() {
		return grid.victory();
	}

}
