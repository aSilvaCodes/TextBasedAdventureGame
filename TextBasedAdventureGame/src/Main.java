import java.util.Scanner;
import java.util.Random;

public class Main {
	public static void main(String[] args) {

		//System objects
		Scanner input = new Scanner(System.in);
		Random rand = new Random();
		
		//Game variables
		String[] enemies = {"Skeleton","Zombie","Warrior","Assassin","Witch"};
		int maxEnemyHealth = 75;
		int enemyAttackDamage = 25;
		
		//Player variables
		int health = 100;
		int attackDamage = 50;
		int numHealthPotions = 3;
		int healthPotionHealAmount = 30;
		int healthPotionDropChance = 50; //Percentage
		int numEnemiesDefeated = 0;
		
		boolean running = true;
		System.out.println("Welcome to the Dungeon! ;) ");
		
		
		GAME:
		while(running) {
			System.out.println("-------------------------------------------------------------");
			
			int enemyHealth = rand.nextInt(maxEnemyHealth);
			String enemy = enemies[rand.nextInt(enemies.length)];
			System.out.println("\t# " + enemy + " has appeared! #\n");
			
			while(enemyHealth > 0) {
				System.out.println("\tYour HP: " + health);
				System.out.println("\t" + enemy + "'s HP: " + enemyHealth);
				System.out.println("\n\tWhat would you like to do?");
				System.out.println("\t1. Attack");
				System.out.println("\t2. Drink health potion");
				System.out.println("\t3. Run away");
				
				String userInput = input.nextLine();
				if(userInput.equals("1")) {
					int damageDealt = rand.nextInt(attackDamage);
					int damageTaken = rand.nextInt(enemyAttackDamage);
					
					health -= damageTaken;
					enemyHealth -= damageDealt;
					System.out.println("\tYou strike the " + enemy + " for " + damageDealt + " damage!");
					System.out.println("\tYou recieved " + damageTaken + " damage in retaliation!");
					if(health <= 0) {
						System.out.println("You have taken too much damage, you are too weak to go on!");
						break;
					}
				}
				else if(userInput.equals("2")) {
					if(numHealthPotions > 0) {
						health += healthPotionHealAmount;
						numHealthPotions--;
						System.out.println("\t>You drink a health potion, healing yourself for " + healthPotionHealAmount + "."
										   + "\n\t>You now have " + health + " HP."
										   + "\n\t>You have " + numHealthPotions + " health potions left.\n");
					} else {
						System.out.println("\tYou have no health potions left! Defeat enemies for a chance to get another one!");
					}
					System.out.println();
				}
				else if(userInput.equals("3")) {
					System.out.println("\tYou run away from the " + enemy + "!");
					continue GAME;
				}
				else {
					System.out.println("\tInvalid command!");
				}
			}
			if(health < 1) {
				System.out.println("You limp out of the dungeon, weak from battle.");
				break;
			}
			System.out.println("-------------------------------------------------------------");
			System.out.println(" # " + enemy + " was defeated! # ");
			numEnemiesDefeated++;
			System.out.println(" # You have " + health + " HP left # ");
			if(rand.nextInt(100) < healthPotionDropChance) {
				numHealthPotions++;
				System.out.println(" # The enemy dropped a health potion! #");
				System.out.println(" # You have " + numHealthPotions + " health potion(s) # ");
			}
			System.out.println("-------------------------------------------------------------");
			System.out.println("What would you like to do now?");
			System.out.println("1. Continue fighting?");
			System.out.println("2. Exit dungeon.");
			
			String userInput = input.nextLine();
			while (!userInput.equals("1") && !userInput.equals("2")) {
				System.out.println("Invalid command!");
				userInput = input.nextLine();
			}
			if(userInput.equals("1")) {
				System.out.println("You continue on your adventure!");
			} 
			else if(userInput.equals("2")) {
				System.out.println("You exit the dungeon, successful from your adventures!");
				if(numEnemiesDefeated == 1)
					System.out.println("You defeated 1 enemy!");
				else
					System.out.println("You defeated " + numEnemiesDefeated + " enemies!");
				break;
			}
		}
		System.out.println();
		System.out.println("########################");
		System.out.println(" # THANKS FOR PLAYING # ");
		System.out.println("########################");
	}
}