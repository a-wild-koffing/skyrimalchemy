import java.util.Comparator;

///////////////////////////////////////////////////////////////////////////////
// Main Class File:  
// File:             Potion.java
// 
// Author(s):           Nicholas Cook 
// Description: 
///////////////////////////////////////////////////////////////////////////////

public class Potion {
	private String potionName;
	private String[] requiredIngreds;
	private int potValue;
	
	/**
	 * Constructor method for Potion object
	 * 
	 * @param potionName
	 * @param requiredIngreds
	 * @param potEffects
	 * @param potValue
	 * 
	 */
	public Potion(String potionName, String[] requiredIngreds, int potValue) {
		this.potionName = potionName;
		this.requiredIngreds = requiredIngreds;
		this.potValue = potValue;
	}
	
	public String getName() {
		return this.potionName;
	}
	
	public String[] getIngredients() {
		return this.requiredIngreds;
	}

	public int getValue() {
		return this.potValue;
	}
	
}
