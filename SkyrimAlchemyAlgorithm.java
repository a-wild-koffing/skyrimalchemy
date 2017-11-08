///////////////////////////////////////////////////////////////////////////////
// Title:            AlchemyAlgorithm
// Files:            AlchemyAlgorithm.java
//					 Ingredient.java
//					 IngredientList.java
//					 Potion.java
//					 PotionList.java
//
// Author(s):           Nicholas Cook 
// Description: 
///////////////////////////////////////////////////////////////////////////////
import java.util.*;
import java.io.*;

public class SkyrimAlchemyAlgorithm {
	private static ArrayList<Ingredient> ingredient_list;
	private static ArrayList<Potion> potions_database;

	private static void generate_ingredient_list(File fp) {
		ingredient_list = new ArrayList<Ingredient>();
		String line;
		String[] ingredients;
		
		try {
			Scanner scnr = new Scanner(fp);
			//read in file which contains list of ingredients
			//each line of file is formatted as
			// ingredient, effect, effect, effect, effect
			while(scnr.hasNextLine()) {
				line = scnr.nextLine();
				ingredients = line.split(line, ',');
				
				if(ingredients.length != 5) {
					System.out.println("File not formatted correctly.\nExiting");
					System.exit(0);
				}
				
				Ingredient new_ingredient = new Ingredient(ingredients[0],
						ingredients[1], ingredients[2], ingredients[3],
						ingredients[4]);
				ingredient_list.add(new_ingredient);
			}
			scnr.close();
		} catch(FileNotFoundException e) {
			System.out.println("The file was not located. Check file name.");
		}

	}
	
	//Generates the database of potions that we will check against
	//when we want to craft. Sorted in highest order
	private static void generate_potions_list(File fp) {
		potions_database = new ArrayList<Potion>();
		String line;
		String[] potion_info;
		String[] ingredients = new String[2]; //2 ingredients per potion
		
		try {
			Scanner scnr = new Scanner(fp);

			while(scnr.hasNextLine()) {
				line = scnr.nextLine();
				potion_info = line.split(line,',');
				ingredients[0] = potion_info[1];
				ingredients[1] = potion_info[2];
				
				Potion pot = new Potion(potion_info[0], ingredients, Integer.parseInt(potion_info[3]));
				potions_database.add(pot);
			}
			scnr.close();
		} catch(FileNotFoundException e) {
			System.out.println("The file was not located. Check file name.");
		}
		
		//sort the database by potion value
		Collections.sort(potions_database, new PotionComparator());
		
	}
	/**
	 * Main Method
	 * @param args
	 */
	public static void main(String[] args) {
		String[] potion_ingreds;
		ArrayList<Potion> pots_crafted = new ArrayList<Potion>();
		Boolean stay;
		
		if(args.length != 2) {
			System.out.println("Usage: java AlchemyAlgorithm [ingredients_file] [potion_file]\n"
					+ "Please configure a filename on the server.");
		} else {
			File fp = new File(args[0]);
			
			//populates the ingredient list from the file
			generate_ingredient_list(fp);
			
			fp = new File(args[1]);
			//populate potions db from file
			generate_potions_list(fp);
			
			//iterate through list of potions from highest value to lowest
			for(Potion pot : potions_database) {
				stay = true;
				//while loop to ensure we stay at current potion if we just made one
				//will check to see if we can make multiple of same kind
				while(stay) {
					//check to see if we have ingredients to make each
					potion_ingreds = pot.getIngredients();
					if(ingredient_list.contains(potion_ingreds[0]) 
							& ingredient_list.contains(potion_ingreds[1])) {
						//add potion to crafted list
						pots_crafted.add(pot);
						//remove ingredients from our list
						ingredient_list.remove(potion_ingreds[0]);
						ingredient_list.remove(potion_ingreds[1]);
					} else stay = false; //if we didn't then we don't want to stay
				} //end while
			} //end for each
		}
	}

}
